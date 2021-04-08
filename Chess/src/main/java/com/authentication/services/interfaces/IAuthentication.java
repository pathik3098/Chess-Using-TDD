package com.authentication.services.interfaces;
import java.sql.SQLException;
public interface IAuthentication
{
    String userAuthentication(String inputUserName, String inputPassword) throws SQLException;
    String userLogOut(String userId) throws SQLException;
}
