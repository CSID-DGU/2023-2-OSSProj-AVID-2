package com.example.backend.entity;

import com.example.backend.model.Complete;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user_task")
@NoArgsConstructor
public class UserTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private TaskEntity schedule;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private Complete complete;

    public UserTaskEntity(UserEntity user, TaskEntity schedule){
        this.user = user;
        this.schedule = schedule;
        this.complete = Complete.returnType(schedule.getTaskType().name());
    }

    public UserTaskEntity(TaskEntity schedule){
        this.schedule = schedule;
        this.user = schedule.getUser();
        this.complete = Complete.returnType(schedule.getTaskType().name());
    }

    public static UserTaskEntity newAssignmentFromOfficial(UserEntity listener, TaskEntity schedule) {
        return new UserTaskEntity(listener, schedule);
    }

    public void updateCompleteStatus() {
        if(this.complete.name().equals("TRUE")) {
            this.complete = Complete.FALSE;
            return;
        }
        this.complete = Complete.TRUE;
    }
}
