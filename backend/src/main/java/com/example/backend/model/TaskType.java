package com.example.backend.model;

public enum TaskType {
    ASSIGNMENT, PRESENTATION, TEST, STUDY;

    public static TaskType returnType(String type){
        if(type.equals("ASSIGNMENT")) return TaskType.ASSIGNMENT;
        if(type.equals("PRESENTATION")) return TaskType.PRESENTATION;
        if(type.equals("STUDY")) return TaskType.STUDY;
        return TEST;
    }
}
