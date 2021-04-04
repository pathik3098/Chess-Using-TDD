package com.tournament.authentication;

import com.tournament.persistence.*;
import com.tournament.model.*;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.SQLException;

public class Register implements IRegister {
    String message = null;
    IValidation iValidation = new Validation();

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

        if (!iValidation.isRegisterFieldEmptyValidation(inputEmail, inputUserId, inputUsername, inputPassword, inputConPassword)) {
            return "Please Fill all Details";
        }

        if (!iValidation.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        } else {
            IRegisterPersistence daoObject = new RegisterPersistence();
            message = daoObject.insertUserDetails(userobj);
        }

        return message;
    }
}
