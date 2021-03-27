package com.tournament.authentication;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IAuthentication
{
    String userAuthentication(String inputUserName, String inputPassword) throws SQLException;
    String userLogOut() throws SQLException;
}
