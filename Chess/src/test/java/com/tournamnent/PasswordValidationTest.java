package com.tournamnent;

import com.tournament.pojo.Users;
import com.tournament.utils.ContainsSymbols;
import com.tournament.utils.MaxLength;
import com.tournament.utils.ValidationPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    public void SimplePasswordTest() {
        ValidationPassword validationPassword = new ValidationPassword();
        boolean a = validationPassword.isPasswordValid("aaa@");
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

}
