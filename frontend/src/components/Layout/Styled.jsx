import styled, { keyframes } from "styled-components";

// nav
export const Container = styled.nav`
  position: relative;
  top: 0;
  width: 100%;
  height: 30px;
  padding-top: 20px;
  display: flex;
  align-items: center;
  background-color: white;
`;

export const LogoImg = styled.img`
  position: relative;
  /* margin-top: 30px;
  margin-left: 30px;
  left: 100px; */
  width: 200px;
  object-fit: contain;
  cursor: pointer;
`;

export const LoginBtnContainer = styled.button`
  position: relative;
  /* left: 230px; */
  width: 100px;

  font: Noto Sans KR;
  display: block;
  font-size: 14px;
  text-align: center;
  color: #fff;
  padding: 8px 16px;

  border-radius: 2px;
  background: #e72f4b;
`;
export const SignupBtnContainer = styled.button`
  position: relative;
  left: 10px;
  width: 100px;

  font: Noto Sans KR;
  display: block;
  font-size: 14px;
  text-align: center;
  color: #fff;
  padding: 8px 16px;

  border-radius: 2px;
  background: #e72f4b;
`;
