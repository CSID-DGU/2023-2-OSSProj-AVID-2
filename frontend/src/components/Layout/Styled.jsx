import styled, { keyframes } from "styled-components";

// nav
export const Container = styled.nav`
  position: absolute;
  top: 0;

  width: 100%;
  height: 30px;
  padding-top: 20px;
  padding-bottom: 20px;
  padding-left: 20px;
  display: flex;
  flex-wrap: wrap;
  align-content: flex-start;
  gap: 20px;
  background-color: white;
`;

export const LogoImg = styled.img`
  //position: absolute;
  /* margin-top: 30px;
  margin-left: 30px;
  left: 100px; */
  width: 200px;
  object-fit: contain;
  cursor: pointer;
`;

export const LoginBtnContainer = styled.button`
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
  width: 100px;
  margin left: 1000px;
  font: Noto Sans KR;
  display: block;
  font-size: 14px;
  text-align: center;
  color: #fff;
  padding: 8px 16px;

  border-radius: 2px;
  background: #e72f4b;
`;

// nav
// export const Container = styled.nav`
//   position: relative;
//   top: 0;
//   width: 100%;
//   height: 30px;
//   padding-top: 20px;
//   padding-bottom: 20px;
//   padding-right: 20px;
//   display: flex;
//   align-items: center;
//   transition-timing-function: ease-in;
//   transition: all 0.5s;
//   background-color: white;
// `;

// export const LogoImg = styled.img`
//   position: relative;
//   /* margin-top: 30px;
//   margin-left: 30px;
//   left: 100px; */
//   width: 200px;
//   object-fit: contain;
//   cursor: pointer;
// `;

// export const LoginBtnContainer = styled.button`
//   position: relative;
//   /* left: 230px; */
//   width: 100px;

//   font: Noto Sans KR;
//   display: block;
//   font-size: 14px;
//   text-align: center;
//   color: #fff;
//   padding: 8px 16px;

//   border-radius: 2px;
//   background: #e72f4b;
// `;
// export const SignupBtnContainer = styled.button`
//   position: relative;
//   left: 10px;
//   width: 100px;

//   font: Noto Sans KR;
//   display: block;
//   font-size: 14px;
//   text-align: center;
//   color: #fff;
//   padding: 8px 16px;

//   border-radius: 2px;
//   background: #e72f4b;
// `;
