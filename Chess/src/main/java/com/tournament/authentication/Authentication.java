package com.tournament.authentication;

import com.tournament.model.*;
import com.tournament.dao.*;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Authentication implements IAuthentication
{
    String message = null;
    public String userAuthentication(String inputUserName, String inputPassword) throws SQLException {
        IUsers userObject = new Users();

        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String loginTime = timeFormat.format(currentDate);

        userObject.setUserId(inputUserName);
        userObject.setPassword(inputPassword);
        userObject.setLoginTime(loginTime);

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
