package com.tournamenttest;

import com.tournament.authentication.IValidation;
import com.tournament.authentication.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    public void SimplePasswordTest() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@");
        Assertions.assertEquals(true, a);

    }

    @Test
    public void SimplePasswordTestMaxLength() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@aaa");
        Assertions.assertEquals(false, a);

    }

    @Test
    public void SimplePasswordTestContainSymbol() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@aa");
        Assertions.assertEquals(true, a);

    }

    @Test
    public void SimplePasswordTestWithoutContainSymbol() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaaaa");
        Assertions.assertEquals(false, a);

    }

    @Test
    public void MaxLengthTest() {
        IValidation iValidation = new Validation();
        boolean b = iValidation.isMaxLength("aaa@");
        Assertions.assertEquals(true, b);

    }

    @Test
    public void ContainsSymbolTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsSymbols("aaa@");
        Assertions.assertEquals(true, c);

    }

    @Test
    public void ContainsSymbolFalseTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsSymbols("aaa");
        Assertions.assertEquals(false, c);

    }

    @Test
    public void ContainsUppercaseTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsUppercaseLetter("aAaa");
        Assertions.assertEquals(true, c);

    }

}
