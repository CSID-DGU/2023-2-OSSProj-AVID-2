import React, { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import * as s from "./Styled.jsx"



export default function Nav() {

  return(
    <s.Container>
        <s.LogoImg 
        alt = "DGU-Eclass-Logo"
        src ="img/logo.png">
        </s.LogoImg>

          <Link to ="/login">
            <s.LoginBtnContainer>
              로그인
            </s.LoginBtnContainer>
          </Link>
          <Link to ="/signup">
            <s.SignupBtnContainer>
              회원가입
            </s.SignupBtnContainer>
          </Link>

    </s.Container>
  )
}