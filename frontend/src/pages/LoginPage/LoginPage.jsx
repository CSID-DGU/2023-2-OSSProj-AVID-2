import React, { useState } from "react";
import * as s from "./Styled.jsx";
import API from "../../api/axios.jsx";
import { useNavigate } from "react-router-dom";

const LoginPage = () => {
  const [ID, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  async function handleSubmit(event) {
    event.preventDefault();
    try {
        // POST 요청 코드
        const response = await API.post('/login', {
            userID: ID,
            userPwd: password
        });
        
        console.log("login Success");
        console.log(response);

        const sessionId = response.data.sessionId; // 서버에서 세션 ID를 받음
        localStorage.setItem("sessionId", sessionId); // 세션 ID를 저장
        console.log("session");
        try{
          console.log(sessionId);
        }catch(error){
          console.log("session Not Found");
          console.error(error);
        }
        console.log(response);
        navigate("/");

    } catch (error) {
        console.log("error");
        console.error(error);
    }
};

  return (
    <s.Wrapper>
      <s.Form onSubmit={handleSubmit}>
        <s.Label>
          <s.Input
            type="text"
            placeholder="아이디를 입력하세요"
            value={ID}
            onChange={handleUsernameChange}
          />
        </s.Label>
        <br />
        <s.Label>
          <s.Input
            type="password"
            placeholder="비밀번호를 입력하세요"
            value={password}
            onChange={handlePasswordChange}
          />
        </s.Label>
        <br />
        <s.SubmitButton type="submit">로그인</s.SubmitButton>
      </s.Form>
    </s.Wrapper>
  );
};

export default LoginPage;