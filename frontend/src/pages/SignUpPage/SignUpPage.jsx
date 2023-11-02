import React, { useState } from "react";
import API from "../../api/axios.jsx";
import { Navigate } from "react-router-dom";
import * as s from "./Styled.jsx";

const SignUpPage = () => {
  const [Name, setName] = useState("");
  const [userType, setUserType] = useState(""); // 유저 타입 추가
  const [studentId, setStudentId] = useState("");
  const [studentEmail, setStudentEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");

  async function SignUp(e) {
    e.preventDefault(); // 기본 동작 중지
    try {
      // POST 요청 코드
      const response = await API.post("/signup", {
        name: Name,
        userID: studentId,
        userPwd: password,
        userName: Name,
        userType: userType,
      });
      console.log(response);
    } catch (error) {
      console.log("error");
      console.error(error);
    }
  }
  return (
    <s.Wrapper>
      <s.Container>
        <s.HeaderContainer>
          <s.SubmitButton type="submit">회원가입</s.SubmitButton>
        </s.HeaderContainer>
        <s.Form onSubmit={SignUp}>
          <s.RadioContainer>
            <s.RadioLabel>소속:</s.RadioLabel>
            <s.RadioInput
              type="radio"
              id="studentType"
              name="userType"
              value="STUDENT"
              checked={userType === "STUDENT"}
              onChange={() => setUserType("STUDENT")}
            />
            <s.RadioLabel htmlFor="studentType">학생</s.RadioLabel>
            <s.RadioInput
              type="radio"
              id="professorType"
              name="userType"
              value="PROFESSOR"
              checked={userType === "PROFESSOR"}
              onChange={() => setUserType("PROFESSOR")}
            />
            <s.RadioLabel htmlFor="professorType">교수</s.RadioLabel>
            <s.RadioInput
              type="radio"
              id="employeeType"
              name="userType"
              value="EMPLOYEE"
              checked={userType === "EMPLOYEE"}
              onChange={() => setUserType("EMPLOYEE")}
            />
            <s.RadioLabel htmlFor="employeeType">교직원</s.RadioLabel>
          </s.RadioContainer>
          <s.InputContainer>
            <s.Label htmlFor="name">이름:</s.Label>
            <s.Input
              type="text"
              id="name"
              value={Name}
              onChange={(e) => setName(e.target.value)}
            />
          </s.InputContainer>
          <s.InputContainer>
            <s.Label htmlFor="studentId">학번:</s.Label>
            <s.Input
              type="text"
              id="studentId"
              value={studentId}
              onChange={(e) => setStudentId(e.target.value)}
            />
          </s.InputContainer>
          <s.InputContainer>
            <s.Label htmlFor="password">비밀번호:</s.Label>
            <s.Input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </s.InputContainer>
          <s.InputContainer>
            <s.Label htmlFor="passwordCheck">비밀번호 확인:</s.Label>
            <s.Input
              type="password"
              id="passwordCheck"
              value={passwordCheck}
              onChange={(e) => setPasswordCheck(e.target.value)}
            />
          </s.InputContainer>
        </s.Form>
      </s.Container>
    </s.Wrapper>
  );
};

export default SignUpPage;
