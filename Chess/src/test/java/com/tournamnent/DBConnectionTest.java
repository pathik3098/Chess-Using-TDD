package com.tournamnent;

import com.tournament.databaseconnection.DBConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DBConnectionTest
{
    DBConnection DBObj = new DBConnection();
    @Test
    public static void connectionTest() {
        String connectionUrl = "jdbc:mysql://localhost:3306/CSCI5308_12_DEVINT";
        String username = "CSCI5308_12_DEVINT_USER";
        String password = "z87wH6WGXqQTS42x";
        Connection conObj = null;

        DBConnection DBObj = new DBConnection();
        DriverManager driverObj = mock(DriverManager.class);
        try
        {
            when(driverObj.getConnection(connectionUrl, username, password)).thenReturn(conObj);
        }
        catch (SQLException E)
        {

        }
        Assertions.assertSame(conObj,DBObj.establishDBConnection());
    }
}
