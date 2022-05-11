package com.example.englishappbackend.enums;

public enum WordCategory {
    ONCE_A_DAY(0) ,
    ONCE_EVERY_THREE_DAY(1),
    ONCE_EVERY_SEVEN_DAY(2),
    ONCE_EVERY_THIRTY_DAY(3);

    private final int value;

    WordCategory(final int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
