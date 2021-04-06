package com.tournament.authentication.interfaces;

import com.tournament.model.Users;
public interface IValidation {
    boolean isPasswordValid(String password);

    boolean isLoginFieldEmptyValidation(String userId, String password);
    boolean isPasswordAndConfirmPasswordNotSame(Users userobj);
    boolean isRegisterFieldEmptyValidation(Users userobj);
    boolean isMaxLength(String password);
    boolean isContainsUppercaseLetter(String password);
    boolean isContainsSymbols(String password);

}

