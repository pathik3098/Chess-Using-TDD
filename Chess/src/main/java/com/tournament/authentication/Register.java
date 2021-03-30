package com.tournament.authentication;

import com.tournament.dao.*;
import com.tournament.model.*;
import com.tournament.utils.ValidationPassword;

import java.sql.SQLException;

public class Register implements IRegister {
    String message = null;
    ValidationPassword validationPassword = null;

    public String userRegistration(Users userobj) throws SQLException {
        String inputEmail = userobj.getEmail();
        String inputUserId = userobj.getUserId();
        String inputUsername = userobj.getUsername();
        String inputPlayerLevel = userobj.getPlayerLevel();
        String inputPassword = userobj.getPassword();
        String inputConPassword = userobj.getConPassword();

        int userSessionFlag = 0;
        userobj.setUserSessionFlag(userSessionFlag);

        int activeInTournament = 0;
        userobj.setActiveInTournament(activeInTournament);

        if (inputEmail == null || inputUserId == null || inputUsername == null || inputPlayerLevel == null || inputPassword == null || inputConPassword == null) {
            return "Input strings can't be empty";
        }

        if (!validationPassword.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        }

        else {
            IRegisterDao daoObject = new RegisterDao();
            message = daoObject.insertUserDetails(userobj);
        }

        return message;
    }
}
