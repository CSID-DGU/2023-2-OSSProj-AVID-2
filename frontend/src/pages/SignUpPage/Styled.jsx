import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  margin: 0;
`;

export const Container = styled.div`
  width: 900px;
  height: 500px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
  border: 7px solid #e39a29;
  border-radius: 40px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.3);
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
  padding: 10px;
  border-radius: 5px;
  border: 5px solid #ddd;
  width: 100%;
  box-sizing: border-box;
`;

export const SubmitButton = styled.button`
  padding: 10px;
  width: 900px;
  font-size: 4rem;
  letter-spacing: 1rem;
  font-family: "Nanum Gothic", sans-serif;
  margin-left: 0 auto;
  border-radius: 15px;
  background-color: rgb(233, 218, 218);
  color: rgb(156, 37, 37);
  border: 5px solid #ddd;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.3);
  cursor: pointer;

  &:hover {
    background-color: #e39a29;
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
