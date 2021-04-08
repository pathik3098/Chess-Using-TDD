package com.tournament.persistence;

import com.tournament.Player;
import com.tournament.persistence.interfaces.ITournamentPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;

import java.sql.*;
import java.text.SimpleDateFormat;

public class TournamentPersistence implements ITournamentPersistence{

    @Override
    public Integer loadPlayer(Player player, int tournamentid)
    {
        IPersistenceConnection conPersistence = new PersistenceConnection();
        Connection connection = null;
        Statement statement = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int result=0;

        try {
            statement=connection.createStatement();
            String query = "insert into Tournament "+"values("+"'"+tournamentid+"'"+","+"'"+dateFormat.format(timestamp)+"'"+","+"'"+player.getPlayerName()+"'"+")";
            result=statement.executeUpdate(query);
            connection.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
