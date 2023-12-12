import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import TeamCalendar from "../Calendar/TeamCalendar";
import styled from "styled-components";
import AddBtn from "../Calendar/AddTodo";
import API from "../../api/axios";

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
  const [teamList, setTeamList] = useState([]);
  const [selectedTeam, setSelectedTeam] = useState({});

  useEffect(() => {
    const fetchTeamList = async () => {
      try {
        const response = await API.get("/api/team/list");
        setTeamList(response.data.result);
        // Set the default selected team (you can modify this based on your requirements)
        if (response.data.result.length > 0) {
          setSelectedTeam(response.data.result[0]);
        }
      } catch (error) {
        console.error("Error fetching team list:", error);
      }
    };

    fetchTeamList();
  }, []);

  const handleDropdownChange = (e) => {
    // 드롭다운에서 선택된 팀의 정보 객체를 가져와서 설정
    const selectedTeamInfo = teamList.find(
      (team) => team.subjectName === e.target.value
    );
    setSelectedTeam(selectedTeamInfo);
    console.log(selectedTeamInfo);
  };

  return (
    <WrapperContainer>
      <PagemodeSel>
        <Link to="/mypage">개인</Link>
      </PagemodeSel>
      <Pagemode>팀 활동</Pagemode>
      <TodoContainer>
        <Dropdown
          value={selectedTeam.subjectName || ""} // 팀 이름으로 초기화
          onChange={handleDropdownChange}
        >
          {teamList.map((team, index) => (
            <option key={index} value={team.subjectName}>
              {team.subjectName}
            </option>
          ))}
        </Dropdown>
        <AddBtn currentPage="team" currentTeam={selectedTeam} />
      </TodoContainer>
      <TeamCalendar selectedTeam={selectedTeam} />
    </WrapperContainer>
  );
};

export default TeamPage;
