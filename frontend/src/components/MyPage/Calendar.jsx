import React from "react";
import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import styled from "styled-components";

const Container = styled.div`
    padding: 20px;
    margin-left: 80px;
    width: 75%;
    height: 75%;
    position: relative;
`;

function Calendar() {
    const events = [
        { title: 'EX1', start: new Date('2023-10-29') },
          { title: 'EX2', start: new Date('2023-10-30') }
    ]
    
    const renderEventContent=(eventInfo)=> {
        return (
          <>
            <i>{eventInfo.event.title}</i>
          </>
        )
    }
    
  return (
    <Container>
      <Fullcalendar
        plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
        initialView={"dayGridMonth"}
        headerToolbar={{
          start: "today prev,next", // will normally be on the left. if RTL, will be on the right
          center: "title",
          end: "dayGridMonth,timeGridWeek,timeGridDay", // will normally be on the right. if RTL, will be on the left
        }}
        events={events}
        eventContent={renderEventContent}
      />
    </Container>
  );
}

export default Calendar;