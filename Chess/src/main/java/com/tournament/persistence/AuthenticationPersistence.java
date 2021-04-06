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
    Connection connection = null;

    private String message;
    ResultSet resultSet;
    private PreparedStatement statement;
    private int updateUserSessionFlag;

    private String getUserIdQuery = "SELECT * from User WHERE userId=?";
    private String updateSessionLoginTimeQuery= "UPDATE User SET sessionFlag=?,LoginTime=? WHERE userId=?";
    private String updateSessionLogoutQuery= "UPDATE User SET sessionFlag=? WHERE userId=?";

    public AuthenticationPersistence()
    {
        updateUserSessionFlag = 0;
        message = null;
        resultSet = null;
        statement = null;
    }

    public IUsers loadUser(String inputUserId) throws SQLException
    {
        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(getUserIdQuery);
            statement.setString(1,inputUserId);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                userObject.setUserId(resultSet.getString(2));
                userObject.setPassword(resultSet.getString(5));
            }
            connection.close();
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
        }
        return userObject;
    }

    public String updateUser(String inputUserId,String inputPassword,String loginTime) throws SQLException
    {
        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(updateSessionLoginTimeQuery);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, loginTime);
            statement.setString(3, inputUserId);
            statement.executeUpdate();
            connection.close();
            return "Login Successful";
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
            statement = connection.prepareStatement(updateSessionLogoutQuery);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, activeUser);
            statement.executeUpdate();
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
