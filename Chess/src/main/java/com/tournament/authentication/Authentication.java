package com.tournament.authentication;

import com.tournament.authentication.interfaces.IAuthentication;
import com.tournament.model.*;
import com.tournament.persistence.*;
import com.tournament.persistence.interfaces.IAuthenticationPersistence;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Authentication implements IAuthentication
{
    String message = null;
    IPasswordEncryption iPasswordEncryption = new PasswordEncryption();

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
            passwordEncryption(userObject, inputPassword);
            IAuthenticationPersistence loginObj = new AuthenticationPersistence();
            message = loginObj.validate((Users) userObject);
        }
        return message;
    }

    private void passwordEncryption(IUsers userObj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userObj.setPassword(hashPass);
    }

    public String userLogOut() throws SQLException {
        Users obj = new Users();
        String currentActiveUser = obj.getUserId();

        IAuthenticationPersistence daoObject = new AuthenticationPersistence();
        message = daoObject.logOut(currentActiveUser);

        return message;
    }
}
