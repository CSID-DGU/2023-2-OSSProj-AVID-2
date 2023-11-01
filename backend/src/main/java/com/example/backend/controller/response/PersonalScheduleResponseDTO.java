package com.example.backend.controller.response;

import com.example.backend.entity.PersonalScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PersonalScheduleResponseDTO {
    private Long scheduleId;
    private String title;
    private String write;
    private String importance;
    private String schedule;
    private String scheduleType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String complete;
    private int dDay;

    @Builder
    public PersonalScheduleResponseDTO(PersonalScheduleEntity schedule){
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

    public static PersonalScheduleResponseDTO fromSchedule(PersonalScheduleEntity schedule) {
        return new PersonalScheduleResponseDTO(schedule);
    }
}
