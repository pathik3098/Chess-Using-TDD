package com.tournament.authentication;

import com.tournament.utils.ContainUppercaseLetter;
import com.tournament.utils.ContainsSymbols;
import com.tournament.utils.MaxLength;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private final int MAX_LENGTH = 6;
    Pattern p = Pattern.compile("[^A-Za-z0-9]");

    private List<IValidation> IValidationPasswordList = new ArrayList();
    private List<Boolean> conditionList = new ArrayList();

    public Validation() {
        IValidationPasswordList.add(new MaxLength());
        IValidationPasswordList.add((new ContainsSymbols()));
        IValidationPasswordList.add((new ContainUppercaseLetter()));
    }

    public boolean isPasswordValid(String password) {
        conditionList.add(isMaxLength(password));
        conditionList.add(isContainsUppercaseLetter(password));
        conditionList.add(isContainsSymbols(password));
        Iterator<Boolean> iter = conditionList.iterator();
        while (iter.hasNext()) {
            Boolean v = iter.next();
            if (!v) {
                return false;
            }
        }
        return true;
//        Iterator<IValidatePassword> iter = IValidatePasswordList.iterator();
//        while (iter.hasNext()) {
//            IValidatePassword v = iter.next();
//            if (!v.isValid(password)) {
//                return false;
//            }
//        }
//        return true;
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