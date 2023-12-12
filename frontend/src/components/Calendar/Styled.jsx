import styled from "styled-components";
import Modal from "react-modal";

export const TeamWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-start; /* Align items at the top */
`;

export const TeamCalendarContainer = styled.div`
  padding: 20px;
  width: 100%;
  height: 80%;
  position: relative;
`;

export const ListContainer = styled.div`
  width: 15%;
  height: 20px;
  margin-right: 100px;
  flex-direction: column;
  background-color: #ffffff;
  padding: 10px;
`;

export const ListTitle = styled.div`
  font-size: 30px;
  font-family: "DM Sans";
  font-weight: 500;
  margin-left: 40px;
  color: rgba(0, 0, 0, 0.5);
  word-wrap: break-word;
`;

export const ListItemContainer = styled.div`
  display: flex;
  align-items: center;
  width: 500px;
  height: 40px;
  margin-top: 10px;
  background-color: ${({ value }) => {
    switch (value) {
      case "과제":
        return "#6d66b7";
      case "발표":
        return "#02A0FC";
      case "팀플":
        return "#14148e";
      default:
        return "#E39A29";
    }
  }};
  border-radius: 8px;
  display: flex;
  flex-direction: row;
  font-family: var(--h3);
  color: rgba(255, 255, 255, 255);
  font-size: 24px;
`;

export const Checkbox = styled.input`
  margin-right: 10px;
  background-color: #ffffff;

  &:checked {
    background-color: #0000ff;
  }
`;

export const AttributeLabel = styled.div`
  margin-right: 10px;
  width: 180px;
  text-align: left;
`;
export const ProgressLabel = styled.div`
  margin-right: 10px;
  margin-left: 10px;
`;

export const CategoryLabel = styled.div`
  margin-right: 10px;
  margin-left: 10px;
`;
export const EnddateLabel = styled.div`
  margin-right: 10px;
  margin-left: 15px;
`;

//Calendar.jsx
export const CalendarContainer = styled.div`
  padding: 20px;
  margin-top: 40px;
  margin-left: 80px;
  width: 80%;
  height: 80%;
  position: relative;
  flex: horizontal;
  /* &:a {
   color: #000000; 
  }
  .fc-day-sat{
    color: blue !important;
  }
  .fc-day-sun {
    color: red !important;
  }

  .fc-day-mon, .fc-day-tue, .fc-day-wed, .fc-day-thu, .fc-day-fri {
    color: black !important;
  } */
`;

//AddBtn.jsx
export const AddBtnContainer = styled.div`
  width: 1000px;
  height: 500px;
  position: relative;
  background: white;
  font-family: "DM Sans";
  font-size: 35px;
  font-weight: 500;
`;

export const ModalLabel = styled.div`
  width: 200px;
  height: 55px;
  margin-left: 15px;
  color: rgba(0, 0, 0, 0.5);
  word-wrap: break-word;
`;

export const AddButton = styled.button`
  background-color: #4339f2;
  color: white;
  border: none;
  border-radius: 50%;
  font-size: 1rem;
  width: 50px;
  height: 50px;
  cursor: pointer;
  position: absolute;
  left: 83%;
  transition: all 0.2s ease-in-out;
  margin-top: 40px;
  &:hover {
    background-color: #4339f2;
    transform: scale(1.1);
  }

  &:active {
    background-color: #4339f2;
    transform: scale(0.9);
  }
`;

export const AddBtnModal = styled(Modal)`
  .AddBtn-modal {
    background-color: gray;
    border-radius: 10px;
    padding: 20px;
    position: relative;
    z-index: 10;
  }
`;

export const CheckButton = styled.button`
  margin-top: 20px;
  background-color: #4339f2;
  color: white;
  border: none;
  font-size: 1rem;
  font-weight: bold;
  width: 100px;
  height: 50px;
  cursor: pointer;
  position: relative;
  left: 42.5%;
`;
export const CancelButton = styled.button`
  margin-top: 20px;
  background-color: #4339f2;
  margin-left: 20px;
  color: white;
  border: none;
  font-size: 1rem;
  font-weight: bold;
  width: 100px;
  height: 50px;
  cursor: pointer;
  position: relative;
  left: 42.5%;
`;

export const FlexContainer = styled.div`
  display: flex;
  align-items: center;
  margin-left: 40px;
  margin-top: 20px;
`;

export const Input = styled.input`
  font-size: 1.2rem;
  padding: 20px;
  border-radius: 0.5rem;
  border: 0.125rem solid white;
  width: 600px;
  background-color: #eaf5fa;
  box-sizing: border-box;
  color: #cfc7c7;
  height: 20px;
`;

export const AddTeamModal = styled(Modal)`
  .AddBtn-modal {
    background-color: gray;
    border-radius: 10px;
    padding: 20px;
    position: relative;
    z-index: 10;
  }
`;

export const AddTeamContainer = styled.div`
  width: 1000px;
  height: 500px;
  position: relative;
  display: flex;
  flex-direction: row;
  background: white;
  font-family: "DM Sans";
`;

export const AddTeamButton = styled.button`
  border: none;
  border-radius: 20%;
  padding: 0px;
  width: 50px;
  height: 50px;
  margin-top: 20px;
  right: 10%;

  background-color: #4339f2;
  &:hover {
    background-color: #4339f2;
    transform: scale(1.05);
  }

  &:active {
    background-color: #4339f2;
    transform: scale(0.9);
  }
`;

export const img = styled.img`
  width: 45px;
  height: 45px;
`;
export const ClassTeamContainer = styled.div`
  width: 200px;
  position: relative;
  display: flex;
  flex-direction: column;
  background: #c3b8b8;
  font-family: "DM Sans";
  font-size: 35px;
  font-weight: 500;
`;
export const SelectedClassContainer = styled.div`
  width: 800px;
  position: relative;
  flex-direction: column;
  background: #ffffff;
  font-family: "DM Sans";
  font-size: 35px;
  font-weight: 500;
`;

export const ModalButtonContainer = styled.div`
  display: flex;
  flex-direction: column;
  background: #ffffff;
`;

export const sbutton = styled.button`
  width: 100px;
  height: 50px;
  font-size: 15px;
`;

export const cbutton = styled.button`
  width: 100px;
  height: 50px;
  font-size: 0.9rem;
  margin-top: auto;
  background-color: #c3b8b8;
`;

export const ClassTeamList = styled.button`
  display: flex;
  align-items: center;
  margin-left: 5px;
  width: 170px;
  height: 40px;
  margin-top: 10px;
  background-color: #ffffff;
  color: rgba(0, 0, 0, 0.5);
  font-size: 15px;
  text-align: center;
  &:hover {
    transform: scale(1.1);
  }
`;

export const TeamName = styled.div`
  font-size: 50px;
  text-align: center;
  /* font-family: ; */
`;

export const TeamMember = styled.div`
  display: flex;
  flex-direction: row;
  font-size: 30px;
  margin-left: 20px;
`;

export const TeamMemberList = styled.div`
  margin-left: 20px;
`;

export const SelectClassContainer = styled.div`
  width: 300px;
  height: 150px;
  margin-left: 15%;
  position: relative;
  display: flex;
  flex-direction: row;
  background: white;
  font-family: "DM Sans";
`;

export const NewTeamLabel = styled.div`
  width: 200px;
  height: 55px;
  margin-left: 15px;
  color: rgba(0, 0, 0, 0.5);
  word-wrap: break-word;
`;

export const mbutton = styled.button`
  width: 100px;
  height: 50px;
  font-size: 0.9rem;
  background-color: #c3b8b8;
`;
