package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import com.tournament.databaseconnection.DBConnectionInterface;
import com.tournament.model.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationDao implements IAuthenticationDao
{
    String message = null;
    DBConnectionInterface conObj = new DBConnection();
    public String validate(Users userObject) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String inputUserId = userObject.getUserId();
        String inputPassword = userObject.getPassword();

        String dbUserId= "";
        String dbPassword = "";
        int updateUserSessionFlag = 1;

        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();
            String select_Query = "select * from User where UserId =" + "'" +inputUserId+ "')";
            resultSet = statement.executeQuery(select_Query);

            while (resultSet.next())
            {
                dbUserId = resultSet.getString(2);
                dbPassword = resultSet.getString(3);
            }

            if (inputUserId.equals(dbUserId) && inputPassword.equals(dbPassword)) {
                String update_query = "update User set sessionFlag =" + updateUserSessionFlag + " " + "where userId =" + "'" + dbUserId + "'";
                statement.executeUpdate(update_query);
                return "LoginSuccessful";
            }
            connection.close();
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
        }
        return "Invalid user credentials";
    }

    public String logOut(String currentActiveUser) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        String activeUser = currentActiveUser;

        int updateUserSessionFlag = 0;

        try {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();

            String update_query = "update User set sessionFlag =" + updateUserSessionFlag + " " + "where userId =" + "'" + activeUser + "'";
            statement.executeUpdate(update_query);
            message = "LogOutSucessful";
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
