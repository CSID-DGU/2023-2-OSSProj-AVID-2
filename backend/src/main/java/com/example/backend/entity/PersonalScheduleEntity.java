package com.example.backend.entity;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.model.ScheduleType;
import com.example.backend.model.Complete;
import com.example.backend.model.Importance;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personal_calendar")
@NoArgsConstructor
@Getter
@DiscriminatorValue("COMMON")
public class PersonalScheduleEntity extends ScheduleEntity {

    @Enumerated(EnumType.STRING) // 열거형 상수의 문자열 값을 데이터베이스에 저장하고 읽음
    private ScheduleType scheduleType;

    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Enumerated(EnumType.STRING)
    private Complete complete;

    @Builder
    private PersonalScheduleEntity(CreateScheduleRequestDTO requestDTO, UserEntity user){
        super.title = requestDTO.getTitle();
        this.user = user;
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.importance = Importance.returnType(requestDTO.getImportance());
        this.write = requestDTO.getWrite();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
        this.complete = Complete.returnType(requestDTO.getScheduleType());
    }

    public static PersonalScheduleEntity fromPersonalScheduleDTO(CreateScheduleRequestDTO requestDTO, UserEntity user) {
        return new PersonalScheduleEntity(requestDTO, user);
    }

    public void modifySchedule(ModifyScheduleRequestDTO requestDTO, String calendarType) {
        this.title = requestDTO.getTitle();
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.importance = Importance.returnType(requestDTO.getImportance());
        this.write = requestDTO.getWrite();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
        this.complete = Complete.returnType(requestDTO.getScheduleType());
    }

    public void updateUserComplete() {
        if(this.getComplete().name().equals("FALSE")) {
            this.complete = Complete.TRUE;
            return;
        }
        if(this.getComplete().name().equals("TRUE")) {
            this.complete = Complete.FALSE;
        }
    }
}
