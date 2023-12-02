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
          <s.UserInfo>
            {userInfo.userName}({userInfo.userID})님
          </s.UserInfo>
          <Link to="/mypage">
            <s.MyPageBtnContainer>마이페이지</s.MyPageBtnContainer>
          </Link>
          <Link to="/logout">
            <s.LogoutBtnContainer>로그아웃</s.LogoutBtnContainer>
          </Link>
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
