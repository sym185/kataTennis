package com.tennis.data.constant;

public enum Point {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    WIN("WIN");

    private String text;

    Point(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return text;
    }
}