import React from "react";
import { Link } from "react-router-dom";
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
  font-size: 1rem;
  font-weight: 400;
  color: #ffffff;
`;
const PagemodeSel = styled.button`
  width: 110px;
  height: 50px;
  margin: 10px;
  flex-shrink: 0;
  background: #ffe5d3;
  font-size: 1rem;
  font-weight: 400;
  color: #a54d1f;
`;
const MyPage = () => {
  return (
    <WrapperContainer>
      <Pagemode>개인</Pagemode>
      <PagemodeSel>
        <Link to="/teampage">팀 활동</Link>
      </PagemodeSel>
      <AddBtn currentPage="personal" />
      <Calendar />
      <Notice />
    </WrapperContainer>
  );
};

export default MyPage;
