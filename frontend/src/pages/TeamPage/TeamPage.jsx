import React from "react";
import styled from "styled-components";

import TeamPageContent from "../../components/TeamPage/TeamPageContent";
import SideBar from "../../components/SideBar/SideBar";

const Container = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  position: relative;
`;

const TeamPage = () => {
  return (
    <Container>
      <SideBar />
      <TeamPageContent />
    </Container>
  );
};

export default TeamPage;
