package com.tournament.authentication;

import com.tournament.authentication.interfaces.IPasswordEncryption;
import com.tournament.authentication.interfaces.IRegister;
import com.tournament.authentication.interfaces.IValidation;
import com.tournament.persistence.*;
import com.tournament.model.*;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.SQLException;

public class Register implements IRegister
{
    IValidation iValidation = new Validation();
    IPasswordEncryption iPasswordEncryption = new PasswordEncryption();
    private String message;
    private String inputPassword;
    private int userSessionFlag;
    private int activeInTournament;
    private String loginTime;

    public Register()
    {
        message = null;
        inputPassword = null;
        userSessionFlag = 0;
        activeInTournament = 0;
        loginTime = null;
    }

    public String userRegistration(Users userObj) throws SQLException {

        inputPassword = userObj.getPassword();
        userObj.setUserSessionFlag(userSessionFlag);
        userObj.setActiveInTournament(activeInTournament);
        userObj.setLoginTime(loginTime);

        if (iValidation.isRegisterFieldEmptyValidation(userObj)) {
            return "Please Fill all Details";
        }

        if (iValidation.isPasswordAndConfirmPasswordNotSame(userObj)) {
            return "Password and Confirm Password doesn't match !";
        }

        if (!iValidation.isPasswordValid(inputPassword))
        {
            return "Invalid Password Format";
        }
        else
        {
            passwordEncryption(userObj, inputPassword);
            IRegisterPersistence registerPersistenceObject = new RegisterPersistence();
            message = registerPersistenceObject.saveUserDetails(userObj);
        }

        return message;
    }

    private void passwordEncryption(Users userObj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userObj.setPassword(hashPass);
    }
}
