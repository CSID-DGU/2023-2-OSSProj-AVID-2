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
    display: "flex",
    flexDirection: "column",
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
  const [selectedTeam, setSelectedTeam] = useState({}); //현재 정보 표시되고 있는 팀
  const [teamMembers, setTeamMembers] = useState({});
  const [selectedLecture, setSelectedLecture] = useState({});
  const [lectureList, setLectureList] = useState([]);
  const [teamList, setTeamList] = useState([{}]);

  const [students, setStudents] = useState([]);

  const [selectedMember, setSelectedMember] = useState({});

  const getLectureList = async () => {
    try {
      const response = await API.get("/api/user-subjects");
      if (response.data.resultCode === "SUCCESS") {
        setLectureList(response.data.result);
        console.log(response.data.result);
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getLectureList();
    getTeamList();
  }, []);

  const fetchStudents = async (selectedTeam) => {
    console.log("Fetching students for subject ID:", selectedTeam);

    try {
      const response = await API.get(
        `/api/user-subjects/${selectedTeam.subjectId}/students`
      );
      if (response.data.resultCode === "SUCCESS") {
        setStudents(response.data.result);
        console.log("Students:", response.data.result);
      }
    } catch (error) {
      console.error("Error fetching students:", error);
    }
  };

  // 모달이 열릴 때 학생 목록 불러오기 (예: handleClickAddMember 함수 내부)
  const handleClickAddMember = () => {
    // 선택한 강좌의 ID를 이용해서 학생 목록을 불러옴
    console.log("Selected TEAM:", selectedTeam);
    fetchStudents(selectedTeam);
    setAddMemberModalOpen(true);
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
      if (response.data.resultCode === "SUCCESS") {
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
      if (response.data.resultCode === "SUCCESS") {
        setTeamList(response.data.result);
        console.log("response" + JSON.stringify(response.data.result));
        console.log("class" + classTeamList);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleSelectTeam = async (team) => {
    console.log("Selected Team Name:", team.subjectName);
    setSelectedTeam(team);
    // 호출할 API 엔드포인트 및 팀에 대한 정보 전달
    const apiEndpoint = `/api/team/${team.teamId}/userInfo`;

    try {
      // API 호출
      const response = await API.get(apiEndpoint);

      // API 응답에서 팀 멤버 정보 추출
      const teamMembersData = response.data;
      console.log("Team Members:", teamMembersData);
      // 추출한 정보를 state에 반영
      setTeamMembers((prevMembers) => ({
        ...prevMembers,
        [team.subjectName]: teamMembersData,
      }));
    } catch (error) {
      console.error("Error fetching team members:", error);
    }
  };

  const handleSelectMember = (member) => {
    console.log("Selected Member:", member);
    setSelectedMembers(member);
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

  const handleAddTeamMembers = async () => {
    if (selectedTeam && selectedMember) {
      // 선택한 팀원을 서버로 보내는 요청 보내기
      const memberRequest = {
        userId: Number(selectedMember),
        teamId: selectedTeam.teamId,
        subjectId: selectedTeam.subjectId,
      };
      console.log(memberRequest);
      // 서버로 팀원을 추가하는 요청 보내기
      try {
        const response = await API.post(
          `/api/team/${selectedTeam.teamId}/addUser`,
          memberRequest
        );
        console.log(response);
        if (response.data.resultCode === "SUCCESS") {
          // 성공적으로 추가되었을 때의 처리
          console.log("Member added successfully");
          setAddMemberModalOpen(false);
        } else {
          // 추가 실패 시의 처리
          console.error("Failed to add member");
          alert("팀원 추가에 실패했습니다.");
        }
      } catch (error) {
        console.error(error);
        alert("팀원 추가에 실패했습니다.");
      }
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
                onClick={() => handleSelectTeam(classTeam)}
              >
                {classTeam.subjectName}
              </s.ClassTeamList>
            ))}
          </s.ClassTeamContainer>

          <s.SelectedClassContainer>
            {selectedTeam && (
              <>
                <s.TeamName>{selectedTeam.subjectName}</s.TeamName>
                <s.TeamMember>
                  팀원:
                  {teamMembers[selectedTeam.subjectName] &&
                    teamMembers[selectedTeam.subjectName].map(
                      (member, index) => (
                        <s.TeamMemberList key={index}>
                          {member.split(",")[1]}
                        </s.TeamMemberList>
                      )
                    )}
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
              <select
                value={selectedLecture}
                onChange={(e) => setSelectedLecture(e.target.value)}
              >
                <option value="" disabled>
                  Select a lecture
                </option>
                {lectureList.map((lecture, index) => (
                  <option key={index} value={lecture.id}>
                    {lecture.subjectName}
                  </option>
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
              <s.mbutton
                onClick={createTeam}
                style={{ width: "30%", height: "40px", marginTop: "20%" }}
              >
                팀 생성
              </s.mbutton>
            </Modal>

            <s.sbutton onClick={handleClickAddMember}>팀원 추가</s.sbutton>
            <Modal
              isOpen={AddMemberModalOpen}
              style={addMemberModalStyles}
              onRequestClose={handleAddTeamMembers}
              ariaHideApp={false}
            >
              새로운 팀원:
              {/* <input
                type="text"
                id="newTeamMember"
                value={newTeamName}
                onChange={(e) => setNewTeamName(e.target.value)}
              /> */}
              <select
                value={selectedMember}
                onChange={(e) => setSelectedMember(e.target.value)}
                style={{ width: "30%", height: "40px", marginTop: "2%" }}
              >
                <option value="" disabled>
                  Select a student
                </option>
                {students.map((student, index) => (
                  <option
                    key={index}
                    value={student.userID}
                    style={{ width: "30%", height: "30px" }}
                  >
                    {student.username}
                  </option>
                ))}
              </select>
              <s.mbutton
                onClick={() => handleAddTeamMembers()}
                style={{ width: "30%", height: "40px", marginTop: "20%" }}
              >
                팀원 초대
              </s.mbutton>
            </Modal>

            <s.cbutton onClick={() => setModalIsOpen(false)}>닫기</s.cbutton>
          </s.ModalButtonContainer>
        </s.AddTeamContainer>
      </s.AddTeamModal>
    </>
  );
};

export default AddTeam;
