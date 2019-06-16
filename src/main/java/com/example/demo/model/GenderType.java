package com.example.demo.model;

public enum GenderType {
    MALE ("male"), 
    FEMALE ("female");

    private String text;

    GenderType(String text) {
        this.text=text;
    }
    public String getText() {
        return text;
    }
}
