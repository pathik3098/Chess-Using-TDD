package com.tournament.authentication;

import com.tournament.dao.LoginDao;
import com.tournament.model.Users;

import java.sql.SQLException;

public class Login
{
    String message = null;
    public String userAuthentication(String inputUserName, String inputPassword) throws SQLException {
        Users userObject = new Users();
        userObject.setUserId(inputUserName);
        userObject.setPassword(inputPassword);

        if(inputUserName == null || inputPassword == null)
        {
            return "Input strings can't be empty";
        }
        else
        {
            LoginDao daoObject = new LoginDao();
            message = daoObject.validate(userObject);
        }
        return message;
    }
}
