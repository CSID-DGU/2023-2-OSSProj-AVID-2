package com.example.backend.model;

public enum TaskType {
    INDIVIDUAL, TEAM; // 개인과제랑 팀과제를 나누는 용도

    public static TaskType returnType(String type){
        if(type.equals("INDIVIDUAL")) return TaskType.INDIVIDUAL;
        if(type.equals("TEAM")) return TaskType.TEAM;
        return null;
    }
}
