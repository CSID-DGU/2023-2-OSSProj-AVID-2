import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import * as s from "./Styled.jsx";
import API from "../../api/axios.jsx";

export default function Nav() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState({});

  useEffect(() => {
    const checkLoginStatus = async () => {
      try {
        const response = await API.get("/home");

        if (response.data.resultCode === "SUCCESS") {
          setIsLoggedIn(true);
          setUserInfo(response.data.result);
        } else {
          setIsLoggedIn(false);
        }
      } catch (error) {
        console.error("Error checking login status:", error);
      }
    };

    checkLoginStatus();
  }, []);

  return (
    <s.Container>
      <Link to="/">
        <s.LogoImg alt="DGU-Eclass-Logo" src="img/logo.png"></s.LogoImg>
      </Link>

      {isLoggedIn ? (
        <>
          <s.User>
            {userInfo.userName}({userInfo.userID})님
          </s.User>

          <Link to="/logout">
            <s.LoginedBtn>로그아웃</s.LoginedBtn>
          </Link>
          <s.LoginedBtn> 대표권한설정</s.LoginedBtn>
          <s.LoginedBtn>Webex 비밀번호 변경</s.LoginedBtn>
          <s.LectureBtn>강의실 선택</s.LectureBtn>
          <s.Language>HOME | ENG | CHN | JPN </s.Language>
        </>
      ) : (
        <>
          <Link to="/login">
            <s.LoginBtnContainer>로그인</s.LoginBtnContainer>
          </Link>

          <Link to="/signup">
            <s.SignupBtnContainer>회원가입</s.SignupBtnContainer>
          </Link>
        </>
      )}
    </s.Container>
  );
}
