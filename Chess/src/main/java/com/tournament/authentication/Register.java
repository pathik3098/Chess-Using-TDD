package com.tournament.authentication;

import com.tournament.persistence.*;
import com.tournament.model.*;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.SQLException;

public class Register implements IRegister {
    String message = null;
    Validation validationPassword = new Validation();

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

        if (!validationPassword.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        }

        else {
            IRegisterPersistence daoObject = new RegisterPersistence();
            message = daoObject.insertUserDetails(userobj);
        }

        return message;
    }
}
