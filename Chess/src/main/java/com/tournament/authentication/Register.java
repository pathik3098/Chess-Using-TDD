package com.tournament.authentication;

import com.tournament.authentication.interfaces.IRegister;
import com.tournament.authentication.interfaces.IValidation;
import com.tournament.persistence.*;
import com.tournament.model.*;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.SQLException;

public class Register implements IRegister {
    String message = null;
    IValidation iValidation = new Validation();
    IPasswordEncryption iPasswordEncryption = new PasswordEncryption();

    public String userRegistration(Users userobj) throws SQLException {
        String inputEmail = userobj.getEmail();
        String inputUserId = userobj.getUserId();
        String inputUsername = userobj.getUsername();
        String inputPassword = userobj.getPassword();
        String inputConPassword = userobj.getConPassword();


        int userSessionFlag = 0;
        userobj.setUserSessionFlag(userSessionFlag);

        int activeInTournament = 0;
        userobj.setActiveInTournament(activeInTournament);

        String loginTime = null;
        userobj.setLoginTime(loginTime);

        if (inputEmail == null || inputUserId == null || inputUsername == null || inputPassword == null || inputConPassword == null) {
            return "Input strings can't be empty";
        }

        if (!iValidation.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        }

        else {
            passwordEncryption(userobj, inputPassword);
            IRegisterPersistence daoObject = new RegisterPersistence();
            message = daoObject.insertUserDetails(userobj);
        }

        return message;
    }

    private void passwordEncryption(Users userobj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userobj.setPassword(hashPass);
    }
}
