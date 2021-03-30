package com.tournament.authentication;

import java.sql.SQLException;

public interface IAuthentication
{
    String userAuthentication(String inputUserName, String inputPassword) throws SQLException;
    String userLogOut() throws SQLException;
}
