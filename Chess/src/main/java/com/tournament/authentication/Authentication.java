package com.tournament.authentication;

import com.tournament.model.*;
import com.tournament.dao.*;
import java.sql.SQLException;

public class Authentication implements IAuthentication
{
    String message = null;
    public String userAuthentication(String inputUserName, String inputPassword) throws SQLException {
        IUsers userObject = new Users();
        userObject.setUserId(inputUserName);
        userObject.setPassword(inputPassword);

        if(inputUserName == null || inputPassword == null)
        {
            return "Input strings can't be empty";
        }
        else
        {
            IAuthenticationDao loginObj = new AuthenticationDao();
            message = loginObj.validate((Users) userObject);
        }
        return message;
    }

    public String userLogOut() throws SQLException {
        Users obj = new Users();
        String currentActiveUser = obj.getUserId();

        IAuthenticationDao daoObject = new AuthenticationDao();
        message = daoObject.logOut(currentActiveUser);

        return message;
    }
}
