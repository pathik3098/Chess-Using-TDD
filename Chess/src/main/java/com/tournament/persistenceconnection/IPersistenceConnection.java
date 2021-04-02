package com.tournament.persistenceconnection;

import java.sql.Connection;

public interface IPersistenceConnection
{
    String connectionUrl = "jdbc:mysql://localhost:3306/authentication";
    String username = "root";
    String password = "Darshil@12345";

    Connection establishDBConnection();
}
