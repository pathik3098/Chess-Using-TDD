package com.tournament.persistence;

import com.tournament.model.IUsers;
import com.tournament.persistenceconnection.PersistenceConnection;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.model.Users;
import com.tournament.persistence.interfaces.IAuthenticationPersistence;

import java.sql.*;

public class AuthenticationPersistence implements IAuthenticationPersistence
{
    IPersistenceConnection conObj = new PersistenceConnection();
    IUsers userObject = new Users();
    Connection connection = conObj.establishDBConnection();

    private String message;
    ResultSet resultSet;
    private PreparedStatement statement;
    private int updateUserSessionFlag;

    private String Q_GET_USER_BY_ID = "SELECT * from User WHERE userId=?";
    private String Q_UPDATE_SESSION_LOGINTIME= "UPDATE User SET sessionFlag=?,LoginTime=? WHERE userId=?";
    private String Q_UPDATE_SESSION_LOGOUT= "UPDATE User SET sessionFlag=? WHERE userId=?";

    public AuthenticationPersistence()
    {
        updateUserSessionFlag = 0;
        message = null;
        resultSet = null;
        statement = null;
    }

    public String loadUser(String inputUserId) throws SQLException
    {
        try
        {
            statement = connection.prepareStatement(Q_GET_USER_BY_ID);
            statement.setString(1,inputUserId);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                userObject.setUserId(resultSet.getString(2));
                userObject.setPassword(resultSet.getString(5));
            }
            connection.close();
            return "User Loaded";
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return "Loading Error";
        }
    }

    public String updateUser(String inputUserId,String inputPassword,String loginTime) throws SQLException
    {
        try
        {
            statement = connection.prepareStatement(Q_UPDATE_SESSION_LOGINTIME);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, loginTime);
            statement.setString(3, inputUserId);
            statement.executeUpdate(Q_UPDATE_SESSION_LOGINTIME);
            connection.close();
            return "LoginSuccessful";
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return "Update Error";
        }
    }

    public String logOut(String currentActiveUser) throws SQLException
    {
        String activeUser = currentActiveUser;

        int updateUserSessionFlag = 0;

        try {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(Q_UPDATE_SESSION_LOGOUT);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, activeUser);
            statement.executeUpdate(Q_UPDATE_SESSION_LOGOUT);
            message = "LogoutSuccessful";
            connection.close();
            return message;
        }
        catch (Exception E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return message;
        }
    }
}
