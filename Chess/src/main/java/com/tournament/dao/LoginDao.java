package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import com.tournament.model.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao
{
    public String validate(Users userObject) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String inputUserName = userObject.getUserId();
        String inputPassword = userObject.getPassword();

        String dbUserName = "";
        String dbPassword = "";
        int updateUserSessionFlag = 1;

        try {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()) {
                dbUserName = resultSet.getString(2);
                dbPassword = resultSet.getString(3);
            }

            if (inputUserName.equals(dbUserName) && inputPassword.equals(dbPassword)) {
                String update_query = "update User set UserSessionFlag =" + updateUserSessionFlag + " " + "where UserId =" + "'" + dbUserName + "'";
                statement.executeUpdate(update_query);
                return "LoginSuccessful";
            }

        }
        catch (Exception E)
        {
            System.out.println("Some Error !" + E);
        }
        return "Invalid user credentials";
    }
}
