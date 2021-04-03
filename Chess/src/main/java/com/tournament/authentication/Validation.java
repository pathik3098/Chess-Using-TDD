package com.tournament.authentication;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation implements IValidation {

    private final int MAX_LENGTH = 6;
    Pattern p = Pattern.compile("[^A-Za-z0-9]");

    public boolean isPasswordValid(String password) {
        List<Boolean> conditionList = new ArrayList();

        conditionList.add(isMaxLength(password));
        conditionList.add(isContainsUppercaseLetter(password));
        conditionList.add(isContainsSymbols(password));
        Iterator<Boolean> iter = conditionList.iterator();
        while (iter.hasNext()) {
            Boolean isCondition = iter.next();
            if (!isCondition) {
                return false;
            }
        }
        return true;
    }

    public boolean isMaxLength(String password) {
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }

    public boolean isContainsUppercaseLetter(String password) {

        char tempCharacter;
        for (int i = 0; i < password.length(); i++) {
            tempCharacter = password.charAt(i);
            if (Character.isUpperCase(tempCharacter)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContainsSymbols(String password) {

        if (null == password || password.trim().isEmpty()) {
            return false;
        }
        Matcher m = p.matcher(password);
        boolean result = m.find();
        return result;
    }

}
