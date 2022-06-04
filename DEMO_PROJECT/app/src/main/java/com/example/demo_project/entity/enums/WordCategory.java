package com.example.demo_project.entity.enums;

public enum WordCategory {
    ONCE_A_DAY(1) ,
    ONCE_EVERY_THREE_DAY(3),
    ONCE_EVERY_SEVEN_DAY(7),
    ONCE_EVERY_THIRTY_DAY(30);

    private final int value;

    WordCategory(final int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
