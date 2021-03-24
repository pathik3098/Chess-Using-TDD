package com.tournament.authentication;

import com.tournament.dao.LogOutDao;
import com.tournament.model.Users;

import java.sql.SQLException;


public class LogOut
{
    String message = null;
    public String userLogOut() throws SQLException {
        Users obj = new Users();
        String currentActiveUser = obj.getUserId();

        LogOutDao daoObject = new LogOutDao();
        message = daoObject.logOut(currentActiveUser);

        return message;
    }
}
