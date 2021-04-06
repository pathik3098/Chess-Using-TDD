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
    private int activeTournament;

    private String getUserIdQuery = "SELECT * from User WHERE userId=?";
    private String updateSessionLoginTimeQuery= "UPDATE User SET sessionFlag = ?,LoginTime = ? WHERE userId = ?";
    private String updateSessionLogoutQuery= "UPDATE User SET sessionFlag = ? WHERE userId = ?";

    public AuthenticationPersistence()
    {
        updateUserSessionFlag = 0;
        activeTournament = 0;
        message = null;
        resultSet = null;
        statement = null;
    }

    public String loadUser(String inputUserId) throws SQLException
    {
        try
        {
            statement = connection.prepareStatement(getUserIdQuery);
            statement.setString(1,inputUserId);
            resultSet = statement.executeQuery();
            int size = 0;
            if (resultSet != null)
            {
                resultSet.last();
                size = resultSet.getRow();
            }
            if(size >= 1)
            {
                return "User Loaded";
            }
            else
            {
                connection.close();
                return "User Not Loaded";
            }
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
            updateUserSessionFlag = 1;
            userObject.setUserId(inputUserId);
            statement = connection.prepareStatement(updateSessionLoginTimeQuery);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, loginTime);
            statement.setString(3, inputUserId);
            statement.executeUpdate();
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
