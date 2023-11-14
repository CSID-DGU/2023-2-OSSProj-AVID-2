package com.example.backend.entity;

import com.example.backend.controller.request.TeamRequestDTO;
import com.example.backend.model.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
@NoArgsConstructor
@Getter
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Builder
    public TeamEntity(String teamName) {
        this.teamName = teamName;
    }

    public static TeamEntity save(String teamName) {
        return new TeamEntity(teamName);
    }
}
