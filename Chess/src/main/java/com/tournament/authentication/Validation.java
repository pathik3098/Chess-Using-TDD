package com.tournament.authentication;
import com.tournament.authentication.interfaces.IValidation;
import com.tournament.model.Users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation implements IValidation
{
    private String inputEmail;
    private String inputUserId;
    private String inputUsername;
    private String inputPassword;
    private String inputConPassword;
    private int playerLevelValue;
    private String playerLevel;

    public Validation()
    {
        inputEmail = null;
        inputUserId = null;
        inputUsername = null;
        inputPassword = null;
        inputConPassword = null;
        playerLevel = null;
        playerLevelValue = 0;
    }

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
            Boolean isConditionSatisfied = iter.next();
            if (!isConditionSatisfied) {
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
    public boolean isRegisterFieldEmptyValidation(Users userObj)
    {
        inputEmail = userObj.getEmail();
        inputUserId = userObj.getUserId();
        inputUsername = userObj.getUsername();
        inputPassword = userObj.getPassword();
        playerLevelValue = userObj.getPlayerLevel();
        playerLevel = Integer.toString(playerLevelValue);
        inputConPassword = userObj.getConPassword();
        if ("" == inputEmail || "" == inputUserId || "" == inputUsername || "" == inputPassword || "" == inputConPassword || "" == playerLevel) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPasswordAndConfirmPasswordNotSame(Users userObj) {
        inputPassword = userObj.getPassword();
        inputConPassword = userObj.getConPassword();
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
