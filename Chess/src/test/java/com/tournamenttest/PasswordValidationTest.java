package com.tournamenttest;

import com.tournament.utils.ContainUppercaseLetter;
import com.tournament.utils.ContainsSymbols;
import com.tournament.utils.MaxLength;
import com.tournament.utils.ValidationPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    public void SimplePasswordTest() {
        ValidationPassword validationPassword = new ValidationPassword();
        boolean a = validationPassword.isPasswordValid("Aaa@");
        Assertions.assertEquals(true, a);

    }

    @Test
    public void MaxLengthTest() {
        MaxLength maxLength = new MaxLength();
        boolean b = maxLength.isValid("aaa@");
        Assertions.assertEquals(true, b);

    }

    @Test
    public void ContainsSymbolTest() {
        ContainsSymbols containsSymbols = new ContainsSymbols();
        boolean c = containsSymbols.isValid("aaa@");
        Assertions.assertEquals(true, c);

    }

    @Test
    public void ContainsSymbolFalseTest() {
        ContainsSymbols containsSymbols = new ContainsSymbols();
        boolean c = containsSymbols.isValid("aaa");
        Assertions.assertEquals(false, c);

    }

    @Test
    public void ContainsUppercaseTest() {
        ContainUppercaseLetter containUppercaseLetter = new ContainUppercaseLetter();
        boolean c = containUppercaseLetter.isValid("aAaa");
        Assertions.assertEquals(true, c);

    }

}
