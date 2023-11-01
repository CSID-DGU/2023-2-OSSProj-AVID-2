package com.example.backend.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 부모 클래스 테이블과 조인됨
@Table(name = "schedule")
@DiscriminatorColumn(name = "schedule") // 상속 할 때 인스턴스 식별
public class ScheduleEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    protected UserEntity user;
    protected String write;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected Month startMonth;
    protected Month endMonth;
    protected int startYear;
    protected int endYear;
    protected Timestamp createdAt;
    protected Timestamp updatedAt;
    protected Timestamp deletedAt;

}
