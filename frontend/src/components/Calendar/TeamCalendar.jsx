import React, { useState, useEffect } from "react";
import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import * as s from "./Styled.jsx";
import AddTeam from "../TeamPage/AddTeam.jsx";
import API from "../../api/axios.jsx";

function TeamCalendar({ selectedTeam }) {
  const [events, setEvents] = useState([]);
  const [selectedDate, setSelectedDate] = useState(new Date());

  const [todoList, setTodoList] = useState([]);

  const convertToKST = (isoString) => {
    const date = new Date(isoString);
    const kst = new Date(date.getTime() + 9 * 60 * 60 * 1000); // UTC+9
    return kst.toISOString();
  };

  useEffect(() => {
    const fetchTeamEvents = async () => {
      console.log(selectedTeam)
      try {
        if (!selectedTeam || !selectedTeam.teamId) {
          setEvents([]);
          return;
        }
        const formattedMonth = selectedDate.toISOString().split("T")[0].split("-").slice(0, 2).join("-");
        const response = await API.get(`/api/schedule/team/${selectedTeam.teamId}/list`,{ params: { month: formattedMonth } });
        console.log("Team Events:", response.data);

        if (response.data.resultCode === "SUCCESS") {
          const events = response.data.result.teamSchedule
          console.log("All Events:", events);
          setEvents(events);
          
        }
        const currentDate = new Date().toISOString();
        console.log("Current Date:", currentDate);
        const todoResponse = await API.get("/api/schedule/team/Todolist",{
          params: {
            date: currentDate,
          },
        });
        if (todoResponse.data.resultCode === "SUCCESS") {
          const todoList = todoResponse.data.result;
          console.log("Todo List:", todoList);
          setTodoList(todoList);
        }


      } catch (error) {
        console.error("Error fetching team events:", error);
      }
    };

    fetchTeamEvents();
  }, [selectedTeam, selectedDate]);

  const handleDateClick = (info) => {
    setSelectedDate(info.date);
  };

  const renderEventContent = (eventInfo) => {
    return (
      <>
        <i>{eventInfo.event.title}</i>
      </>
    );
  };

  const eventsForFullCalendar = events.map((event) => ({
    title: event.title,
    start: convertToKST(event.startDate),
    end: convertToKST(event.endDate),
    backgroundColor: event.scheduleType === "SCHEDULE" ? "#e61919" : "#006cb7",
    allDay: true,
  }));

  eventsForFullCalendar.forEach(event => {
    const endDate = new Date(event.end);
    endDate.setDate(endDate.getDate() + 1);
    event.end = endDate.toISOString();
  });

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
          events={eventsForFullCalendar}
          eventContent={renderEventContent}
          height={"85vh"}
          width={"85vh"}
          locale={"ko"}
          dateClick={handleDateClick} // Add dateClick handler
        />
      </s.TeamCalendarContainer>
      <s.ListContainer>
      {todoList.map((todo) => (
          <s.ListItemContainer key={todo.id} value={todo.category}>
            <s.Checkbox type="checkbox" />
            <s.AttributeLabel>{todo.activityName}</s.AttributeLabel>
            <s.ProgressLabel>{todo.progress}</s.ProgressLabel>
            <s.CategoryLabel>{todo.category}</s.CategoryLabel>
            <s.EnddateLabel>{todo.endDate}</s.EnddateLabel>
          </s.ListItemContainer>
        ))}
        <AddTeam />
      </s.ListContainer>
    </s.TeamWrapper>
  );
}

export default TeamCalendar;
