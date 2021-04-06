package com.tournament.authentication.interfaces;
import java.sql.SQLException;
public interface IAuthentication
{
    String userAuthentication(String inputUserName, String inputPassword) throws SQLException;
    String userLogOut() throws SQLException;
}
