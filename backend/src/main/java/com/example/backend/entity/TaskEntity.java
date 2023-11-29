package com.example.backend.entity;

import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.model.TaskType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subject_schedule")
@NoArgsConstructor
@Getter
@DiscriminatorValue("TASK")
public class TaskEntity extends ScheduleEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Builder
    private TaskEntity(TaskRequestDTO requestDTO, SubjectEntity subject, UserEntity user) {
        this.subject = subject;
        this.title = requestDTO.getTitle();
        this.user = user;
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.content = requestDTO.getContent();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.taskType = TaskType.returnType(requestDTO.getTaskType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
    }

    public static TaskEntity fromTaskDTO(TaskRequestDTO requestDTO, SubjectEntity subject, UserEntity user){
        return new TaskEntity(requestDTO, subject, user);
    }


}
