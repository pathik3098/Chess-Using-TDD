package com.tournament.utils;

public class MaxLength implements IValidatePassword {

    private final int MAX_LENGTH = 6;

    @Override
    public boolean isValid(String password) {
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }
}


