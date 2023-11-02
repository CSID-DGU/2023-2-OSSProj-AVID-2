import styled from "styled-components";

export const Container = styled.div`
  width: 700px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
  border: 0px solid;
  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
`;

export const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  margin: 0;
  border: 0px solid;
  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
`;

export const HeaderContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;


export const Form = styled.form`
  display: flex;
  flex-direction: column;
  
`;

export const InputContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 15px;
  text-align: left;
`;

export const Label = styled.label`
  font-size: 1.2rem;
  text-align: left;
  margin-right: 13px;
  flex: 0 0 140px;
`;

export const Input = styled.input`
  flex: 1;
  font-size: 1.2rem;
  padding: 20px;
  border-radius: .5rem;
  border: 0.125rem solid white;
  width: 100%;
  background-color: #e2e1e1;
  box-sizing: border-box;
  color: grey;
  height: 20px;
`;

export const SubmitButton = styled.button`
  padding: 10px;
  border-radius: 5px;
  width: 100%;
  background-color: orange;
  color: white;
  border: 1px solid #cdcdcd;
  cursor: pointer;
  font-weight: bold;
`;

export const RadioContainer = styled.div`
  display: flex;
  align-items: center;
  margin-top: 15px;
  text-align: left;
`;

export const RadioLabel = styled.label`
  font-size: 1.2rem;
  text-align: left;
  margin-right: 105px;
  align-items: center;
`;

export const RadioInput = styled.input`
  margin-right: 5px;
  width: 2.5rem;
  height: 2.5rem;
  -webkit-appearance: none; // 웹킷 브라우저에서 기본 스타일 제거
  -moz-appearance: none; // 모질라 브라우저에서 기본 스타일 제거 
  appearance: none; // 기본 브라우저에서 기본 스타일 제거
  width: 18px;
  height: 18px;
  border: 2px solid #ccc; // 체크되지 않았을 때의 테두리 색상
  border-radius: 50%;
  outline: none; // focus 시에 나타나는 기본 스타일 제거
  cursor: pointer;
  &:checked {
    background-color: #1e91fcf8;
    border: 3px solid white;
    box-shadow: 0 0 0 1.6px #1e91fcf8;
  }
`;
