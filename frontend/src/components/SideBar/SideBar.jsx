import React from "react";
import * as s from "./Styled.jsx";

const SideBar = () => {
  return (
    <s.SideBarContainer>
      <s.SidebarLogo src="img/CyberCampus.png" alt="CyberCampus" />

      <s.MenuList>
        <br />
        <s.ListLine />
        <s.MenuItem>내 강의실 홈</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>수강 과목</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>조교과목</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>쪽지</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>강의 시간표</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>청강신청</s.MenuItem>
        <s.ListLine />
        <s.MenuItem>대표권한설정</s.MenuItem>
        <s.ListLine />
      </s.MenuList>
    </s.SideBarContainer>
  );
};

export default SideBar;
