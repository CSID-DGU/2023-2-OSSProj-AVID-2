package com.example.backend.entity;

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

    public UserTaskEntity(UserEntity user, TaskEntity schedule){
        this.user = user;
        this.schedule = schedule;
    }

    public UserTaskEntity(TaskEntity schedule){
        this.schedule = schedule;
        this.user = schedule.getUser();
    }

    public static UserTaskEntity newAssignmentFromOfficial(UserEntity listener, TaskEntity schedule) {
        return new UserTaskEntity(listener, schedule);
    }
}
