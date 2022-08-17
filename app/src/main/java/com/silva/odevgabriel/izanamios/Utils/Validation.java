package com.silva.odevgabriel.izanamios.Utils;

public class Validation {

    private Validation() {}

    public static boolean isFieldValid(String field, int minLength) {
        return field.length() >= minLength;
    }

    public static boolean isFieldValid(String field, int minLength, int maxLength) {
        return field.length() >= minLength && field.length() <= maxLength;
    }
}
