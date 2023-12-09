import React, { useState, useEffect } from "react";
import styled from "styled-components";
import * as s from "../Calendar/Styled.jsx";
import Modal from "react-modal";
import API from "../../api/axios.jsx";

const customModalStyles = {
  content: {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    backgroundColor: "transparent",
    border: "none",
    borderRadius: "10px",
    padding: "20px",
  },
  overlay: {
    backgroundColor: "rgba(0, 0, 0, 0.5)",
    zIndex: 1000,
  },
};

const addMemberModalStyles = {
  content: {
    width: "500px",
    height: "300px",
    backgroundColor: "white",
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    border: "none",
    borderRadius: "10px",
    alignItems: "center",
    justifyContent: "center",
    overflow: "auto",
    padding: "20px",
  },
  overlay: {
    backgroundColor: "rgba(0, 0, 0, 0.5)",
    zIndex: 1000,
  },
};

const AddTeam = () => {
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [AddMemberModalOpen, setAddMemberModalOpen] = useState(false);
  const [AddTeamModalOpen, setAddTeamModalOpen] = useState(false);
  const [classTeamList, setClassTeamList] = useState([]); //팀이 생성된 과목리스트
  const [newTeamName, setNewTeamName] = useState(""); //각 팀의 이름
  const [selectedTeam, setSelectedTeam] = useState(""); //현재 정보 표시되고 있는 팀
  const [teamMembers, setTeamMembers] = useState({});
  const [selectedLecture, setSelectedLecture] = useState("");
  const [lectureList, setLectureList] = useState([]);
  const [teamList, setTeamList] = useState([]);

  
  const getLectureList = async () => {
    try {
      const response = await API.get("/api/user-subjects");
      if(response.data.resultCode === "SUCCESS"){
        setLectureList(response.data.result);
        console.log(response.data.result);
      }
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    getLectureList();
    getTeamList();
  }, []);

  const handleClickAddMember = () => {
    setAddMemberModalOpen((prev) => !prev);
  };
  const handleClickAddTeam = () => {
    setAddTeamModalOpen((prev) => !prev);
  };
  const handleCreateTeam = () => {
    if (newTeamName.trim() !== "") {
      setClassTeamList((prevList) => [...prevList, newTeamName]);
      setAddTeamModalOpen(false);
    }
  };

  const createTeam = async () => {  
    try {
      const response = await API.post("/api/team/create", {
        subjectId: Number(selectedLecture),
      });
      console.log(response);
      if(response.data.resultCode === "SUCCESS"){
        setClassTeamList((prevList) => [...prevList, newTeamName]);
        setAddTeamModalOpen(false);
      }
    } catch (error) {
      console.error(error);
  
      alert("팀 생성에 실패했습니다.");
    }
  };

  const getTeamList = async () => {
    try {
      const response = await API.get("/api/team/list");
      if(response.data.resultCode === "SUCCESS"){
        setTeamList(response.data.result);
        console.log("response" + JSON.stringify(response.data.result));
        console.log("class"+classTeamList);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleSelectTeam = (teamName) => {
    console.log("Selected Team Name:", teamName); // 확인을 위한 로그 추가
    setSelectedTeam(teamName);
    // Create an empty array for the team members if it doesn't exist
    if (!teamMembers[teamName]) {
      setTeamMembers((prevMembers) => ({
        ...prevMembers,
        [teamName]: [],
      }));
    }
};

  const handleAddTeamMember = (memberName) => {
    if (selectedTeam && memberName.trim() !== "") {
      setTeamMembers((prevMembers) => ({
        ...prevMembers,
        [selectedTeam]: [...prevMembers[selectedTeam], memberName],
      }));
      setAddMemberModalOpen(false);
    }
  };

  return (
    <>
      <s.AddTeamButton onClick={() => setModalIsOpen(true)}>
        <s.img src="/img/AddTeamIcon.png" alt="Button Image" />
      </s.AddTeamButton>

      <s.AddTeamModal
        isOpen={modalIsOpen}
        onRequestClose={() => setModalIsOpen(false)}
        style={customModalStyles}
      >
        <s.AddTeamContainer>
          <s.ClassTeamContainer>
            {teamList.map((classTeam, index) => (
              <s.ClassTeamList
                key={index}
                onClick={() => handleSelectTeam(classTeam.subjectName)}
              >
                {classTeam.subjectName}
              </s.ClassTeamList>
            ))}
          </s.ClassTeamContainer>

          <s.SelectedClassContainer>
            {selectedTeam && (
              <>
                <s.TeamName>{selectedTeam}</s.TeamName>
                <s.TeamMember>
                  팀원:
                  {teamMembers[selectedTeam] &&
                    teamMembers[selectedTeam].map((member, index) => (
                      <s.TeamMemberList key={index}>{member}</s.TeamMemberList>
                    ))}
                </s.TeamMember>
              </>
            )}
          </s.SelectedClassContainer>

          <s.ModalButtonContainer>
            <s.sbutton onClick={handleClickAddTeam}>팀 생성</s.sbutton>
            <Modal
              isOpen={AddTeamModalOpen}
              style={addMemberModalStyles}
              onRequestClose={handleClickAddTeam}
              ariaHideApp={false}
            >
              {/* 강의를 선택할 드롭다운 추가 */}
            <select value={selectedLecture} onChange={(e) => setSelectedLecture(e.target.value)}>
                <option value="" disabled>Select a lecture</option>
                {lectureList.map((lecture, index) => (
                    <option key={index} value={lecture.id}>{lecture.subjectName}</option>
                ))}
            </select>

              {/* <s.NewTeamLabel>
                New Team Name:
                <input
                  type="text"
                  id="newTeamName"
                  value={newTeamName}
                  onChange={(e) => setNewTeamName(e.target.value)}
                />
              </s.NewTeamLabel> */}
              <s.sbutton onClick={createTeam}>Create Team</s.sbutton>
            </Modal>

            <s.sbutton onClick={handleClickAddMember}>팀원 추가</s.sbutton>
            <Modal
              isOpen={AddMemberModalOpen}
              style={addMemberModalStyles}
              onRequestClose={handleClickAddMember}
              ariaHideApp={false}
            >
              New Team Member:
              <input
                type="text"
                id="newTeamMember"
                value={newTeamName}
                onChange={(e) => setNewTeamName(e.target.value)}
              />
              <s.sbutton onClick={() => handleAddTeamMember(newTeamName)}>
                Add Team Member
              </s.sbutton>
            </Modal>

            <s.sbutton onClick={() => setModalIsOpen(false)}>닫기</s.sbutton>
          </s.ModalButtonContainer>
        </s.AddTeamContainer>
      </s.AddTeamModal>
    </>
  );
};

export default AddTeam;
