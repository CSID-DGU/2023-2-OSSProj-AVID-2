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

export const MyPageBtnContainer = styled.button`
  position: relative;
  left: 10px;
  width: 100px;

  font: Noto Sans KR;
  display: block;
  font-size: 14px;
  text-align: center;
  color: #fff;
  padding: 8px 8px;

  border-radius: 2px;
  background: #e72f4b;
`;

export const LogoutBtnContainer = styled.button`
  position: relative;
  left: 20px;
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

export const User = styled.text`
  position: relative;
  color: grey;
  font-size: 20px;
`;

export const Language = styled.text`
  margin-left: 150px;
  color: var(--colors-black-100, #000);
  font-family: DM Sans;
  font-size: 22px;
  font-style: bold;
  font-weight: 400;
  opacity: 0.4;
`;

export const LoginedBtn = styled.button`
  position: relative;
  /* left: 230px; */

  margin-left: 20px;

  font: Noto Sans KR;
  display: block;
  font-size: 20px;
  font-weight: bold;
  text-align: center;
  color: #fff;
  padding: 4px 8px;

  border-radius: 2px;
  background: #662784;
`;

export const LectureBtn = styled.button`
  position: relative;
  /* left: 230px; */

  margin-left: 20px;

  font: Noto Sans KR;
  display: block;
  font-size: 15px;
  font-weight: bold;
  text-align: center;
  color: #8b6666;
  padding: 4px 8px;

  border-radius: 15px;
  background: #dad7fe;
`;
export const Input = styled.input`
  flex: 1;
  font-size: 1.2rem;
  padding: 20px;
  border-radius: 0.5rem;
  border: 0.125rem solid white;
  width: 100%;
  background-color: #e2e1e1;
  box-sizing: border-box;
  color: grey;
  height: 20px;
`;
