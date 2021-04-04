package com.tournament.persistence;

import com.tournament.Player;
import com.tournament.model.LeaderBoard;
import com.tournament.persistence.interfaces.ILeaderBoardPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardPersistence implements ILeaderBoardPersistence{

    IPersistenceConnection dbConnection = new PersistenceConnection();
    Connection connection = null;

    private String QUERY_GET_PLAYERS_POINTS_BY_TOUNAMENTID = "SELECT PlayerName, PlayerPoints FROM PLAYERS WHERE TounamentId=? ORDER BY PlayerPoints";
    private PreparedStatement preparedStatement = null;


    @Override
    public List<Player> getLeaderboard(int tournamentId) {
        List<Player> leaderBoardList = new ArrayList<>();
        try {
            connection = dbConnection.establishDBConnection();
            preparedStatement = connection.prepareStatement(QUERY_GET_PLAYERS_POINTS_BY_TOUNAMENTID);
            preparedStatement.setInt(1, tournamentId);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println(rs.getFetchSize());
            if (rs != null) {
                while (rs.next()) {
                    Player newPlayer = new Player();
                    newPlayer = setFieldValues(newPlayer, rs);
                    leaderBoardList.add(newPlayer);
                }
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return leaderBoardList;
    }

    public Player setFieldValues(Player player, ResultSet rs) throws SQLException {
        player.setPlayerName(rs.getString("PlayerName"));
        player.setPlayerPoints(rs.getInt("PlayerPoints"));
        return player;
    }

}
