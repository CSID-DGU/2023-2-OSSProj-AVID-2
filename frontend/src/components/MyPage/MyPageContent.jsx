import React from "react";
import Calendar from "../Calendar/Calendar";
import Notice from "./Notice";
import styled from "styled-components";
import AddBtn from "../Calendar/AddTodo";

const WrapperContainer = styled.div`
  position: relative;
  flex: 1;
`;

const Pagemode = styled.button`
  width: 110px;
  height: 50px;
  margin: 10px;
  flex-shrink: 0;
  background: #a54d1f;
  font-size: 20px;
  font-weight: 400;
  font-familiy: DMSans;
  color: #ffffff;
`;
const PagemodeSel = styled.button`
  width: 110px;
  height: 50px;
  margin: 10px;
  flex-shrink: 0;
  background: #ffe5d3;
  font-size: 20px;
  font-weight: 400;
  font-familiy: DMSans;
  color: #a54d1f;
`;
const MyPage = () => {
  return (
    <WrapperContainer>
      <Pagemode>개인</Pagemode>
      <PagemodeSel>팀 활동</PagemodeSel>
      <AddBtn />
      <Calendar />
      <Notice />
    </WrapperContainer>
  );
};

export default MyPage;
