package com.tournament.persistenceconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class PersistenceConnection implements IPersistenceConnection
{

    public Connection establishDBConnection()  {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(connectionUrl, username, password);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tournament", "root", "Chinky30891$");
            System.out.println("Establishing the connection "+ connection);
        }
        catch(Exception E)
        {
            System.out.println("Connection Error !" +E);
        }
        return connection;
    }
}