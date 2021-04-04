package com.tournament.authentication;

public interface IValidation {
    boolean isPasswordValid(String password);

    boolean isLoginFieldEmptyValidation(String userId, String password);
    boolean isRegisterFieldEmptyValidation(String inputEmail,String inputUserId,String inputUsername,String inputPassword,String inputConPassword);
    boolean isMaxLength(String password);
    boolean isContainsUppercaseLetter(String password);
    boolean isContainsSymbols(String password);

}

