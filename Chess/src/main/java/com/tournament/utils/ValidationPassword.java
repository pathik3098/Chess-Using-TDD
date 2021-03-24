package com.tournament.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidationPassword {

    private List<ValidatePassword> validatePasswordList = new ArrayList();

    public ValidationPassword() {
        validatePasswordList.add(new MaxLength());
        validatePasswordList.add((new ContainsSymbols()));
    }

    public boolean isPasswordValid(String password) {
        Iterator<ValidatePassword> iter = validatePasswordList.iterator();
        while (iter.hasNext()) {
            ValidatePassword v = iter.next();
            if (!v.isValid(password)) {
                return false;
            }
        }
        return true;
    }

}
