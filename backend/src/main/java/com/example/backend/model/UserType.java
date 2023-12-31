package com.example.backend.model;

public enum UserType { // 열거형 상수

    STUDENT, PROFESSOR, EMPLOYEE;

    public static UserType returnUserType(String userType) {
        if(userType.equals("STUDENT")) return UserType.STUDENT;
        if(userType.equals("EMPLOYEE")) return UserType.EMPLOYEE;
        return UserType.PROFESSOR;
    }
}
