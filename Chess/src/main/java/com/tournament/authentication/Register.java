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

    public String userRegistration(Users userObj, String playerLevel) throws SQLException {
        String inputEmail = userObj.getEmail();
        String inputUserId = userObj.getUserId();
        String inputUsername = userObj.getUsername();
        String inputPassword = userObj.getPassword();
        String inputConPassword = userObj.getConPassword();


        int userSessionFlag = 0;
        userObj.setUserSessionFlag(userSessionFlag);

        int activeInTournament = 0;
        userObj.setActiveInTournament(activeInTournament);

        String loginTime = null;
        userObj.setLoginTime(loginTime);

        if (iValidation.isRegisterFieldEmptyValidation(inputEmail, inputUserId, inputUsername, inputPassword, inputConPassword, playerLevel)) {
            return "Please Fill all Details";
        }

        if (iValidation.isPasswordAndConfirmPasswordNotSame( inputPassword, inputConPassword)) {
            return "Password and Confirm Password doesn't match !";
        }

        if (!iValidation.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        }
        else {
            passwordEncryption(userobj, inputPassword);
            int playerLevelValue = Integer.parseInt(playerLevel);
            userObj.setPlayerLevel(playerLevelValue);
            IRegisterPersistence daoObject = new RegisterPersistence();
            message = daoObject.insertUserDetails(userObj);
        }

        return message;
    }

    private void passwordEncryption(Users userobj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userobj.setPassword(hashPass);
    }
}
