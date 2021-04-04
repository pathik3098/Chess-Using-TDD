package com.tournament.persistenceconnection;

import java.sql.Connection;

public interface IPersistenceConnection
{
    String connectionUrl = "jdbc:mysql://" + System.getenv("URL") + ":" + System.getenv("PORT") + "/" + System.getenv("DB");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    Connection establishDBConnection();
}
