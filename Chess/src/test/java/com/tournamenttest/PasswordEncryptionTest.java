package com.tournamenttest;

import com.tournament.authentication.IPasswordEncryption;
import com.tournament.authentication.PasswordEncryption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordEncryptionTest {

    String samplePassword = "Hello@123";
    Boolean isTrue = false;

    @Test
    public void passwordEncryptionTest() {
        IPasswordEncryption iPasswordEncryption = new PasswordEncryption();
        String encryptedPassword = iPasswordEncryption.encryptPassword(samplePassword);
        Assertions.assertEquals("e20f517179e9cd52ae29dae43c121b95", encryptedPassword);
    }

    @Test
    public void passwordEncryptionFalseTest() {
        IPasswordEncryption iPasswordEncryption = new PasswordEncryption();
        String encryptedPassword = iPasswordEncryption.encryptPassword(samplePassword);

        if (samplePassword != encryptedPassword) {
            isTrue = true;
        }
        Assertions.assertEquals(true, isTrue);
    }

    @Test
    public void passwordEncryptionTrueTest() {
        IPasswordEncryption iPasswordEncryption = new PasswordEncryption();
        String encryptedPassword = iPasswordEncryption.encryptPassword(samplePassword);

        if (samplePassword == encryptedPassword) {
            isTrue = true;
        }
        Assertions.assertEquals(false, isTrue);
    }

}
