package com.tournament.dao;
import com.tournament.databaseconnection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LogOutDao
{
    String message = null;
    public String logOut(String currentActiveUser) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        String activeUser = currentActiveUser;

        int updateUserSessionFlag = 0;

        try {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();

            String update_query = "update User set UserSessionFlag =" + updateUserSessionFlag + " " + "where UserId =" + "'" + activeUser + "'";
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

