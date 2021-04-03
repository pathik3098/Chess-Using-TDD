package com.tournament.persistence;

import com.tournament.model.Match;
import com.tournament.persistence.interfaces.IMatchPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MatchPersistence implements IMatchPersistence {

    IPersistenceConnection dbConnection = new PersistenceConnection();
    Connection connection = null;

    private String Q_SAVE = "INSERT into matches (player1id,player2id,startTime,endTime,tournamentId) value (?,?,?,?,?)";
    private String Q_GETALL = "SELECT * from matches";
    private String Q_GET_BY_ID = "SELECT * from matches where matchId=?";
    private String Q_UPDATE = "UPDATE matches SET player1id=?,player2id=?,startTime=?,endTime=?,tournamentId=?,result=? where matchId=?";
    private String Q_DELETE = "DELETE From matches where matchId=?";
    private PreparedStatement stmt = null;

    @Override
    public void saveMatch(Match match) {

        try {
            connection = dbConnection.establishDBConnection();
            stmt = connection.prepareStatement(Q_SAVE);
            stmt.setString(1, match.getPlayer1id());
            stmt.setString(2, match.getPlayer2id());
            stmt.setString(3, match.getStartTime());
            stmt.setString(4, match.getEndTime());
            stmt.setInt(5, match.getTournamentId());

            int noOfRowAffected = stmt.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Match> getAllMatch() {
        List<Match> matchesList = new ArrayList<>();
        try {

            connection = dbConnection.establishDBConnection();
            stmt = connection.prepareStatement(Q_GETALL);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getFetchSize());
            if (rs != null) {
                while (rs.next()) {
                    Match match = new Match();
                    setFieldValues(match, rs);

                    matchesList.add(match);
                }
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matchesList;
    }

    @Override
    public Match getMatchById(int matchId) {

        Match match = new Match();
        try {
            connection = dbConnection.establishDBConnection();
            stmt = connection.prepareStatement(Q_GET_BY_ID);
            stmt.setInt(1, matchId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                setFieldValues(match, rs);
            }
            connection.close();
            return match;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return match;
    }

    private void setFieldValues(Match match, ResultSet rs) throws SQLException {
        match.setMatchId(rs.getInt("matchId"));
        match.setPlayer1id(rs.getString("player1id"));
        match.setPlayer2id(rs.getString("player2id"));
        match.setStartTime(rs.getString("startTime"));
        match.setEndTime(rs.getString("endTime"));
        match.setTournamentId(rs.getInt("tournamentId"));
        match.setMatchWinner(rs.getString("result"));
    }


    @Override
    public void updateMatch(Match match, int matchId) {

        try {
            connection = dbConnection.establishDBConnection();
            stmt = connection.prepareStatement(Q_UPDATE);
            stmt.setString(1, match.getPlayer1id());
            stmt.setString(2, match.getPlayer2id());
            stmt.setString(3, match.getStartTime());
            stmt.setString(4, match.getEndTime());
            stmt.setInt(5, match.getTournamentId());
            stmt.setString(6, match.getMatchWinner());
            stmt.setInt(7, match.getMatchId());

            int noOfRowAffected = stmt.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteMatch(int matchId) {

        try {
            connection = dbConnection.establishDBConnection();
            stmt = connection.prepareStatement(Q_DELETE);
            stmt.setInt(1, matchId);
            int noOfRowAffected = stmt.executeUpdate();

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
