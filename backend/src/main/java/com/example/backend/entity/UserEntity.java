package com.example.backend.entity;

import com.example.backend.model.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@Table(name = "TB_USER")
@NoArgsConstructor
public class UserEntity {

    // database table 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userID;
    private String userPwd;
    private String userName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Builder
    public UserEntity(String userID, String userPwd, String userName, UserType userType) {
        this.userID = userID;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userType = userType;
    }

    public static UserEntity save(String userID, String userPwd, String userName, UserType userType) {
        return new UserEntity(userID, userPwd, userName, userType);
    }
}
