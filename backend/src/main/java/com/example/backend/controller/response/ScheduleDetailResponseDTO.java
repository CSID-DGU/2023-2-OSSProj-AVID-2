package com.example.backend.controller.response;

import com.example.backend.entity.PersonalScheduleEntity;
import com.example.backend.entity.TeamScheduleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleDetailResponseDTO {
    private Long scheduleId;
    private String title;
    private String subjectName;
    private String content;
    private String schedule;
    private String taskType;
    private String scheduleType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;

    // 개인 스케줄 디테일
    @Builder
    private ScheduleDetailResponseDTO(PersonalScheduleEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.schedule = PersonalScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
        this.scheduleType = schedule.getScheduleType().name();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }
    public static ScheduleDetailResponseDTO fromPersonalSchedule(PersonalScheduleEntity schedule) {
        return new ScheduleDetailResponseDTO(schedule);
    }

    // 팀 스케줄 디테일
    @Builder
    private ScheduleDetailResponseDTO(TeamScheduleEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.schedule = TeamScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }
    public static ScheduleDetailResponseDTO fromTeamSchedule(TeamScheduleEntity schedule) {
        return new ScheduleDetailResponseDTO(schedule);
    }
}
