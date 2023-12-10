package com.example.backend.controller.response;

import com.example.backend.entity.TeamScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TeamScheduleResponseDTO {
    private Long scheduleId;
    private String title;
    private String content;
    private String schedule;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;

    @Builder
    public TeamScheduleResponseDTO(TeamScheduleEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.schedule = TeamScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }

    public static TeamScheduleResponseDTO fromSchedule(TeamScheduleEntity schedule) {
        return new TeamScheduleResponseDTO(schedule);
    }
}
