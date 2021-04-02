package com.tournament.persistence;

import com.tournament.Player;
import com.tournament.persistence.interfaces.ITournamentPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;
import org.springframework.data.relational.core.sql.In;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TournamentPersistence implements ITournamentPersistence {

    IPersistenceConnection conPersistence = new PersistenceConnection();
    Connection connection = null;
    Statement statement = null;
    Player winner;

    @Override
    public Integer loadPlayer(Player player, int tournamentid) {
        connection=conPersistence.establishDBConnection();
        String name = player.getPlayerName();
        int result=0;
        try {
            statement=connection.createStatement();
            String query = "insert into Tournament "+"values("+"'"+tournamentid+"'"+","+"'"+player.getPlayerName()+"'"+","+"'"+player.getPlayerName()+"'"+")";
             result=statement.executeUpdate(query);
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }
}
