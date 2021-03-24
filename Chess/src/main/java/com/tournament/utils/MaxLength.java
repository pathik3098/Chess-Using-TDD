package com.tournament.utils;

public class MaxLength implements ValidatePassword {

    private final int MAX_LENGTH = 10;

    @Override
    public boolean isValid(String password) {
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }
}


