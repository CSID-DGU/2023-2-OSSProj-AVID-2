package com.example.backend.controller.response;

import com.example.backend.entity.PersonalScheduleEntity;
import com.example.backend.entity.TaskEntity;
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
    private String write;
    private String schedule;
    private String subjectScheduleType;
    private String scheduleType;
    private String importance;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;
    private String complete;

    @Builder
    private ScheduleDetailResponseDTO(PersonalScheduleEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.write = schedule.getWrite();
        this.importance = schedule.getImportance().name();
        this.schedule = PersonalScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.scheduleType = schedule.getScheduleType().name();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
        this.complete = schedule.getComplete().name();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }
    public static ScheduleDetailResponseDTO fromPersonalSchedule(PersonalScheduleEntity schedule) {
        return new ScheduleDetailResponseDTO(schedule);
    }

    @Builder
    private ScheduleDetailResponseDTO(TaskEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.write = schedule.getWrite();
        this.importance = schedule.getImportance().name();
        this.schedule = TaskEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.scheduleType = schedule.getScheduleType().name();
        this.startDate = schedule.getStartDate();
        this.subjectScheduleType = schedule.getScheduleType().name();
        this.subjectName = schedule.getSubject().getSubjectName();
        this.endDate = schedule.getEndDate();
        this.complete = schedule.getComplete().name();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }

    public static ScheduleDetailResponseDTO fromTask(TaskEntity schedule){
        return new ScheduleDetailResponseDTO(schedule);
    }
}
