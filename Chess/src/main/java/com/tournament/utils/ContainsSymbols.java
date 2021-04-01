package com.tournament.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsSymbols implements IValidatePassword {

    Pattern p = Pattern.compile("[^A-Za-z0-9]");

    @Override
    public boolean isValid(String password) {

        if (null == password || password.trim().isEmpty()) {
            return false;
        }
        Matcher m = p.matcher(password);

        boolean result = m.find();
        return result;
    }
}