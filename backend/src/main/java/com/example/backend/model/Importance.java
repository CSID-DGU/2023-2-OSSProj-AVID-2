package com.example.backend.model;

public enum Importance {
    EASY, NORMAL, IMPORTANT;

    public static Importance returnType(String importance) {
        if(importance.equals("EASY")) return Importance.EASY;
        if(importance.equals("NORMAL")) return Importance.NORMAL;
        return IMPORTANT;
    }
}
