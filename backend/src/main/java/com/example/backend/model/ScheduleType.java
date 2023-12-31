package com.example.backend.model;

public enum ScheduleType {
    TASK, SCHEDULE;

    public static ScheduleType returnType(String type) {
        if(type.equals("TASK")) return ScheduleType.TASK;
        if(type.equals("SCHEDULE")) return ScheduleType.SCHEDULE;
        return null;
    }
}
