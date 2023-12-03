import React from "react";
import { Link } from "react-router-dom";
import TeamCalendar from "../Calendar/TeamCalendar";
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
const TodoContainer = styled.div`
  position: relative;
  flex: 1;
  display: flex;
  flex-direction: row;
  align-items: center;
`;
const Dropdown = styled.select`
  height: 30px;
  width: 130px;
  margin-left: 72%;
  margin-top: 40px;
`;
const TeamPage = () => {
  return (
    <WrapperContainer>
      <PagemodeSel>
        <Link to="/mypage">개인</Link>
      </PagemodeSel>
      <Pagemode>팀 활동</Pagemode>
      <TodoContainer>
        <Dropdown>
          <option value="option1">오픈소스 소프트웨어</option>
          <option value="option2">자료구조와 알고리즘 1</option>
          <option value="option3">융합소프트웨어</option>
        </Dropdown>
        <AddBtn />
      </TodoContainer>
      <TeamCalendar />
    </WrapperContainer>
  );
};

export default TeamPage;
