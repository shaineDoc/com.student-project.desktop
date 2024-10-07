package com.course.desktop.domain;

public enum StudentOrderStatus {
    START, CHECKED;
    public static StudentOrderStatus fromValue(int value) {
        for (StudentOrderStatus s : StudentOrderStatus.values()) {
            if (s.ordinal() == value) {
                return s;
            }
        }
        throw new RuntimeException("No enum constant " + StudentOrderStatus.class + " with value " + value);
    }
}
