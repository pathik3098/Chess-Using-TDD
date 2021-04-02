package com.tournament.persistenceconnection;

import java.sql.Connection;

public interface IPersistenceConnection
{
    String connectionUrl = "jdbc:mysql://" + System.getenv("URL_LOCAL") + ":" + System.getenv("PORT") + "/" + System.getenv("DB_LOCAL");
    String username = System.getenv("USERNAME_LOCAL");
    String password = System.getenv("PASSWORD_LOCAL");

    Connection establishDBConnection();
}
