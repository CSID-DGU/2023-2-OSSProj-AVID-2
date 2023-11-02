import styled from "styled-components";

export const Container = styled.div`
  width: 900px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
  border: 7px solid #cb6666;
  border-radius: 5px;
`;

export const HeaderContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
`;

export const SignUpHeader = styled.h1`
  text-align: center;
  margin: 0 auto;
`;

export const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

export const InputContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 15px;
  text-align: left;
`;

export const Label = styled.label`
  font-size: 1.5rem;
  text-align: left;
  margin-right: 13px;
  flex: 0 0 140px;
`;

export const Input = styled.input`
  flex: 1;
  font-size: 1.3rem;
  padding: 20px;
  border-radius: 5px;
  border: 5px solid #ddd;
  width: 100%;
  box-sizing: border-box;
`;

export const SubmitButton = styled.button`
  padding: 10px;
  border-radius: 5px;
  background-color: rgb(233, 218, 218);
  color: rgb(156, 37, 37);
  border: 5px solid #ddd;
  cursor: pointer;

  &:hover {
    background-color: #30b337;
  }
`;

export const RadioContainer = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 15px;
  text-align: left;
`;

export const RadioLabel = styled.label`
  font-size: 1.5rem;
  text-align: left;
  margin-right: 130px;
  align-items: center;
`;

export const RadioInput = styled.input`
  margin-right: 5px;
  width: 30px;
  height: 30px;
`;
