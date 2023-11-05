package com.example.backend.entity;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.model.ScheduleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personal_schedule")
@NoArgsConstructor
@Getter
@DiscriminatorValue("COMMON")
public class PersonalScheduleEntity extends ScheduleEntity {

    @Enumerated(EnumType.STRING) // 열거형 상수의 문자열 값을 데이터베이스에 저장하고 읽음
    private ScheduleType scheduleType;


    @Builder
    private PersonalScheduleEntity(CreateScheduleRequestDTO requestDTO, UserEntity user){
        super.title = requestDTO.getTitle();
        this.user = user;
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.content = requestDTO.getContent();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
    }

    public static PersonalScheduleEntity fromPersonalScheduleDTO(CreateScheduleRequestDTO requestDTO, UserEntity user) {
        return new PersonalScheduleEntity(requestDTO, user);
    }

    public void modifySchedule(ModifyScheduleRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.content = requestDTO.getContent();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
    }

}
