import React, { useState } from "react";
import Nav from "../../components/Layout/Nav";
import { Container } from "../SignUpPage/Styled";
import * as s from "./Styled.jsx";

const LoginPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(`Username: ${username}, Password: ${password}`);
    // Add logic to submit form data to server here
  };

  return (
    <s.Wrapper>
      <Nav />
      <s.Form onSubmit={handleSubmit}>
        <s.Label>
          <s.Input
            type="text"
            placeholder="아이디를 입력하세요"
            value={username}
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
