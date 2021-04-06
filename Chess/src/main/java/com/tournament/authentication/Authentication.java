package com.tournament.authentication;
import com.tournament.authentication.interfaces.IAuthentication;
import com.tournament.authentication.interfaces.IPasswordEncryption;
import com.tournament.authentication.interfaces.IValidation;
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
    IAuthenticationPersistence authenticatePersistenceObj = new AuthenticationPersistence();
    IUsers userObject = new Users();

    IValidation iValidation = new Validation();

    private void passwordEncryption(IUsers userObj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userObj.setPassword(hashPass);
    }

    private String validateCredentials(String message,String inputUserId,String inputPassword) throws SQLException {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String loginTime = timeFormat.format(currentDate);
        if(message == "User Loaded")
        {
            String messageUpdate = authenticatePersistenceObj.updateUser(inputUserId,inputPassword,loginTime);
            return messageUpdate;
        }
        else
        {
            return "Invalid Credentials";
        }
    }

    public String userAuthentication(String inputUserId, String inputPassword) throws SQLException
    {
        if (iValidation.isLoginFieldEmptyValidation(inputUserId, inputPassword))
        {
            return "Enter User Id or Password !";
        }
        else
        {
            passwordEncryption(userObject, inputPassword);
            String loadUserMessage = authenticatePersistenceObj.loadUser(inputUserId);
            message = validateCredentials(loadUserMessage,inputUserId,inputPassword);
        }
        return message;
    }

    public String userLogOut() throws SQLException {
        String currentActiveUser = userObject.getUserId();
        message = authenticatePersistenceObj.logOut(currentActiveUser);
        return message;
    }

    public void destroyObjects()
    {
        iPasswordEncryption = null;
        authenticatePersistenceObj = null;
        userObject = null;
    }
}
