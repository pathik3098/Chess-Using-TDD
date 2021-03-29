package com.tournament.PlayerDB;

import com.tournament.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerDB implements IPlayerPersistence {
    // establishing connection
    Connection con;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root","root","");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Class.forName("com.mysql.cj.jdbc.Driver");

    @Override
    public void savePlayer() {

    }

    @Override
    public void loadPlayer(int playerId, Player player)
    {

    }
}
