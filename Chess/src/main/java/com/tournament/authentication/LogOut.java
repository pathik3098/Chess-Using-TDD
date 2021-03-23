package com.tournament.authentication;

import com.tournament.dao.LogOutDao;
import com.tournament.model.Users;


public class LogOut
{
    String message = null;
    public String userLogOut()
    {
        Users obj = new Users();
        String currentActiveUser = obj.getUserId();

        LogOutDao daoObject = new LogOutDao();
        message = daoObject.logOut(currentActiveUser);

        return message;
    }
}
