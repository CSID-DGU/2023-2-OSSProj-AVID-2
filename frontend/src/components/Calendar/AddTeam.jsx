import React, { useState } from "react";
import styled from "styled-components";
import * as s from "./Styled.jsx";
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
  const handleSelectTeam = (teamName) => {
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
            {classTeamList.map((classTeam, index) => (
              <s.ClassTeamList
                key={index}
                onClick={() => handleSelectTeam(classTeam)}
              >
                {classTeam}
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
              <s.NewTeamLabel>
                New Team Name:
                <input
                  type="text"
                  id="newTeamName"
                  value={newTeamName}
                  onChange={(e) => setNewTeamName(e.target.value)}
                />
              </s.NewTeamLabel>
              <s.sbutton onClick={handleCreateTeam}>Create Team</s.sbutton>
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
