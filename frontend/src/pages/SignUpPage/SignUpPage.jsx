import React, { useState } from "react";
import API from "../../api/axios.jsx";
import { useNavigate } from "react-router-dom";
import * as s from "./Styled.jsx";

const SignUpPage = () => {
  const [Name, setName] = useState("");
  const [userType, setUserType] = useState(""); // 유저 타입 추가
  const [studentId, setStudentId] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const navigate = useNavigate();

  const [major, setMajor] = useState("");
  const majorOptions = [
    "과학수사",
    "그래픽커뮤니케이션사이언스",
    "데이터사이언스소프트웨어",
    "문화공학",
    "문화예술소프트웨어",
    "문화학",
    "범죄수사소프트웨어",
    "생명정보소프트웨어",
    "서베이리서치",
    "예술융복합",
    "융합소프트웨어",
  ];

  const handleMajorChange = (e) => {
    setMajor(e.target.value);
  };

  async function SignUp(e) {
    e.preventDefault(); // 기본 동작 중지
    // 입력 필드 중 하나라도 비어있으면 alert 띄우기
    if (
      !Name ||
      !userType ||
      !studentId ||
      !password ||
      !passwordCheck ||
      !major
    ) {
      alert("모든 항목을 입력하세요.");
      return;
    }
    if (password !== passwordCheck) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    try {
      // POST 요청 코드
      const response = await API.post("/signup", {
        name: Name,
        userID: studentId,
        userPwd: password,
        userName: Name,
        userType: userType,
        userMajor: major,
      });
      console.log(response.result);
      navigate("/login");
    } catch (error) {
      console.log("error");
      console.error(error);
    }
  }
  return (
    <s.Wrapper>
      <s.Container>
        <s.Form onSubmit={SignUp}>
          <s.HeaderContainer>
            <s.SubmitButton type="submit">회원가입</s.SubmitButton>
          </s.HeaderContainer>
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
          <s.InputContainer>
            <s.Label htmlFor="major">전공:</s.Label>
            <s.SelectBox id="major" value={major} onChange={handleMajorChange}>
              <option value="">전공을 선택하세요</option>
              {majorOptions.map((option) => (
                <option key={option} value={option}>
                  {option}
                </option>
              ))}
            </s.SelectBox>
          </s.InputContainer>
        </s.Form>
      </s.Container>
    </s.Wrapper>
  );
};

export default SignUpPage;
