package com.example.backend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "user_subject")
public class UserSubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Builder
    public UserSubjectEntity(UserEntity user, SubjectEntity subject){
        this.user = user;
        this.subject = subject;
    }

    public static UserSubjectEntity fromUserSubject(UserEntity user, SubjectEntity subject){
        return new UserSubjectEntity(user, subject);
    }
}
