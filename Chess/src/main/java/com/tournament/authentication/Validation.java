package com.tournament.authentication;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation implements IValidation {

    private final int MAX_LENGTH = 6;
    Pattern p = Pattern.compile("[^A-Za-z0-9]");

    @Override
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

    @Override
    public boolean isLoginFieldEmptyValidation(String userId, String password) {

        if ("" == password || "" == userId) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isRegisterFieldEmptyValidation(String inputEmail, String inputUserId, String inputUsername, String inputPassword, String inputConPassword, String playerLevel) {

        if ("" == inputEmail || "" == inputUserId || "" == inputUsername || "" == inputPassword || "" == inputConPassword || "" == playerLevel) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPasswordAndConfirmPasswordNotSame(String inputPassword, String inputConPassword) {

        if (inputPassword != inputConPassword) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isMaxLength(String password) {
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }

    @Override
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

    @Override
    public boolean isContainsSymbols(String password) {

        if (null == password || password.trim().isEmpty()) {
            return false;
        }
        Matcher m = p.matcher(password);
        boolean result = m.find();
        return result;
    }

}
