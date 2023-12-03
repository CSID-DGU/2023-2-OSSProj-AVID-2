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
  width: 60%;
  height: 80%;
  position: relative;
`;

export const ListContainer = styled.div`
  width: 50%;
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
    // Use a function to dynamically set the background color based on the value
    switch (value) {
      case "과제":
        return "#6d66b7";
      case "발표":
        return "#02A0FC";
      case "팀플":
        return "#14148e";
      default:
        return "#E39A29"; // Default color if the value doesn't match any case
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
    background-color: #blue;
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
`;

//AddBtn.jsx
export const AddBtnContainer = styled.div`
  width: 1000px;
  height: 100px;
  margin-left: 15%;
  position: relative;
  background: white;
`;

export const ModalTitleLabel = styled.div`
  width: 200px;
  font-size: 50px;
  font-family: "DM Sans";
  font-weight: 500;
  margin-left: 40px;
  color: rgba(0, 0, 0, 0.5);
  word-wrap: break-word;
`;

export const ModalContentLabel = styled.div`
  width: 200px;
  height: 55px;
  margin-left: 40px;
  font-size: 35px;
  font-family: "DM Sans";
  font-weight: 500;
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
  margin-top: 5px;
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
