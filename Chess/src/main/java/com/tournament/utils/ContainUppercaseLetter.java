package com.tournament.utils;

import com.tournament.authentication.IValidation;

public class ContainUppercaseLetter implements IValidation {

    @Override
    public boolean isValid(String password) {

        char tempCharacter;
        for (int i = 0; i < password.length(); i++) {
            tempCharacter = password.charAt(i);
            if (Character.isUpperCase(tempCharacter)) {
                return true;
            }
        }

        return false;
    }
}
