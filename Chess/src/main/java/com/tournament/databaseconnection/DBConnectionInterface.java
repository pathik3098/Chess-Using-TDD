package com.tournament.databaseconnection;

import java.sql.Connection;

public interface DBConnectionInterface
{
    String connectionUrl = "jdbc:mysql://localhost:3306/authentication";
    String username = "root";
    String password = "Darshil@12345";

    Connection establishDBConnection();
}
