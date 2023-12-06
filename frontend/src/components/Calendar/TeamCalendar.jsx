import React from "react";
import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import * as s from "./Styled.jsx";
import AddTeam from "./AddTeam.jsx";

function TeamCalendar() {
  const events = [
    { title: "EX1", start: new Date("2023-10-29") },
    { title: "EX2", start: new Date("2023-10-30") },
  ];

  const renderEventContent = (eventInfo) => {
    return (
      <>
        <i>{eventInfo.event.title}</i>
      </>
    );
  };

  return (
    <s.TeamWrapper>
      <s.TeamCalendarContainer>
        <Fullcalendar
          plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
          initialView={"dayGridMonth"}
          headerToolbar={{
            start: "today prev,next",
            center: "title",
            end: "",
          }}
          events={events}
          eventContent={renderEventContent}
          height={"85vh"}
          width={"85vh"}
          locale={"ko"}
        />
      </s.TeamCalendarContainer>
      <s.ListContainer>
        <s.ListItemContainer value="팀과제">
          <s.Checkbox type="checkbox" />
          <s.AttributeLabel>활동 명</s.AttributeLabel>
          <s.ProgressLabel>진행중</s.ProgressLabel>
          <s.CategoryLabel>팀 과제</s.CategoryLabel>
          <s.EnddateLabel>마감일</s.EnddateLabel>
        </s.ListItemContainer>
        <s.ListItemContainer value="팀플">
          <s.Checkbox type="checkbox" />
          <s.AttributeLabel>프로젝트 진행</s.AttributeLabel>
          <s.ProgressLabel>진행중</s.ProgressLabel>
          <s.CategoryLabel>과제</s.CategoryLabel>
          <s.EnddateLabel>23-12-25</s.EnddateLabel>
        </s.ListItemContainer>
        <s.ListItemContainer value="과제">
          <s.Checkbox type="checkbox" />
          <s.AttributeLabel>과제</s.AttributeLabel>
          <s.ProgressLabel>진행중</s.ProgressLabel>
          <s.CategoryLabel>과제</s.CategoryLabel>
          <s.EnddateLabel>23-12-25</s.EnddateLabel>
        </s.ListItemContainer>
        <s.ListItemContainer value="발표">
          <s.Checkbox type="checkbox" />
          <s.AttributeLabel>프로젝트 발표</s.AttributeLabel>
          <s.ProgressLabel>진행중</s.ProgressLabel>
          <s.CategoryLabel>발표</s.CategoryLabel>
          <s.EnddateLabel>23-12-25</s.EnddateLabel>
        </s.ListItemContainer>
        <s.ListItemContainer value="팀플">
          <s.Checkbox type="checkbox" />
          <s.AttributeLabel>프로젝트 시연</s.AttributeLabel>
          <s.ProgressLabel>진행중</s.ProgressLabel>
          <s.CategoryLabel>팀플</s.CategoryLabel>
          <s.EnddateLabel>23-12-25</s.EnddateLabel>
        </s.ListItemContainer>
        <AddTeam />
      </s.ListContainer>
    </s.TeamWrapper>
  );
}

export default TeamCalendar;
