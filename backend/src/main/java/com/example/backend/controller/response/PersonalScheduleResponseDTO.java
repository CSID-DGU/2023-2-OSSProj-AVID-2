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
    private String schedule;
    private String scheduleType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;

    @Builder
    public PersonalScheduleResponseDTO(PersonalScheduleEntity schedule){
        this.scheduleId = schedule.getId();
        this.title = schedule.getTitle();
        this.write = schedule.getWrite();
        this.schedule = PersonalScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
        this.scheduleType = schedule.getScheduleType().name();
        this.dDay = LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear();
    }

    public static PersonalScheduleResponseDTO fromSchedule(PersonalScheduleEntity schedule) {
        return new PersonalScheduleResponseDTO(schedule);
    }
}
