package com.tournament.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBConnectionInterface
{

    public static Connection establishDBConnection()  {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(connectionUrl, username, password);
            System.out.println("Establishing the connection "+ connection);
        }
        catch(Exception E)
        {
            System.out.println("Connection Error !" +E);
        }
        return connection;
    }
}