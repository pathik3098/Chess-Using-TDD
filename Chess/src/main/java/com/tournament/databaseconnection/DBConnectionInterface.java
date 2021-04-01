package com.tournament.databaseconnection;

import java.sql.Connection;

public interface DBConnectionInterface
{
    String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "sai18";

    Connection establishDBConnection();
}
