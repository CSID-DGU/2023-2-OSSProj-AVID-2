import React from "react";
import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import * as s from "./Styled.jsx";

function Calendar() {
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
    <s.CalendarContainer>
      <Fullcalendar
        plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
        initialView={"dayGridMonth"}
        headerToolbar={{
          start: "today prev,next", // will normally be on the left. if RTL, will be on the right
          center: "title",
          end: "",
        }}
        events={events}
        eventContent={renderEventContent}
        height={"85vh"}
        width={"85vh"}
        locale={"ko"}
      />
    </s.CalendarContainer>
  );
}

export default Calendar;
