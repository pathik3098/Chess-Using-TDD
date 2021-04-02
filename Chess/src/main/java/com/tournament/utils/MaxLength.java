package com.tournament.utils;

import com.tournament.authentication.IValidation;

public class MaxLength implements IValidation {

    private final int MAX_LENGTH = 6;

    @Override
    public boolean isValid(String password) {
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }
}


