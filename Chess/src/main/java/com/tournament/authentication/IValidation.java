package com.tournament.authentication;

public interface IValidation {
    boolean isPasswordValid(String password);

    boolean isMaxLength(String password);
    boolean isContainsUppercaseLetter(String password);
    boolean isContainsSymbols(String password);

}

