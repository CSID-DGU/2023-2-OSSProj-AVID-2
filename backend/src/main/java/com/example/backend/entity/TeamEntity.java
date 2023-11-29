package com.example.backend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "team")
@NoArgsConstructor
@Getter
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Builder
    public TeamEntity(SubjectEntity subject) {
        this.subject = subject;
    }

    public static TeamEntity save(SubjectEntity subject) {
        return new TeamEntity(subject);
    }
}
