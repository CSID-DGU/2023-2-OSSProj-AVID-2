import React, { useState, useEffect } from "react";
import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import * as s from "./Styled.jsx";
import API from "../../api/axios.jsx";

function Calendar() {
  const [selectedDate, setSelectedDate] = useState(new Date());
  const [allevents, setAllEvents] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const formattedMonth = selectedDate.toISOString().split("T")[0].split("-").slice(0, 2).join("-");
        const response = await API.get("/api/schedule/personal", { params: { month: formattedMonth } });
  
        if (response.data.resultCode === "SUCCESS") {
          const allEvents = response.data.result.personalSchedule.concat(response.data.result.task);
          console.log("All Events:", allEvents);
          setAllEvents(allEvents);
        }
      } catch (error) {
        console.error("Error fetching events:", error);
      }
    };
  
    fetchEvents();
  }, [selectedDate]);

  const renderEventContent = (eventInfo) => {
    return (
      <>
        <i>{eventInfo.event.title}</i>
      </>
    );
  };

  const handleDateClick = (info) => {
    setSelectedDate(info.date);
  };

  const eventsForFullCalendar = allevents.map((event) => ({
    title: event.title,
    start: new Date(event.startDate),
    end: new Date(event.endDate),
    backgroundColor: event.scheduleType === "SCHEDULE" ? "#e61919" : "#006cb7",
    allDay: true,
  }));

  const dayRender = (info) => {
    const dayOfWeek = info.day.getDate(); // 현재 날짜의 요일을 가져옴 (0: 일요일, 1: 월요일, ..., 6: 토요일)
    console.log("Day of week:", dayOfWeek);
    // 날짜에 따라 스타일을 지정
    if (dayOfWeek === 0) {
      info.el.style.backgroundColor = 'red'; // 일요일
    } else if (dayOfWeek === 6) {
      info.el.style.backgroundColor = 'blue'; // 토요일
    } else {
      info.el.style.backgroundColor = 'black'; // 평일
    }
  };

  return (
    <s.CalendarContainer>
      <Fullcalendar
        plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
        initialView={"dayGridMonth"}
        headerToolbar={{
          start: "today prev,next", // will normally be on the left. if RTL, will be on the right
          center: "title",
          end: "",
        }}
        events={eventsForFullCalendar}
        eventContent={renderEventContent}
        height={"85vh"}
        width={"85vh"}
        locale={"ko"}
        dateClick={handleDateClick} // Add dateClick handler
        dayRender={dayRender}
      />
    </s.CalendarContainer>
  );
}

export default Calendar;
