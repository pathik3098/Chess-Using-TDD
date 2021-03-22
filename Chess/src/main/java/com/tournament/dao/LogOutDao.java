package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogOutDao {
    public String userLoggingOut() {

        int UserSessionFlag = 0;
        String dbUserName = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Users");

            while(resultSet.next()) {
                dbUserName = resultSet.getString(2);
            }
            String update_query = "update User set UserSessionFlag =" +UserSessionFlag+ " " + "where UserId =" + "'" +dbUserName+ "'";
            statement.executeUpdate(update_query);
        }
        catch(SQLException Err)
        {
            System.out.println("Sql Error !" +Err);
        }

        return "Invalid user credentials";
    }
}