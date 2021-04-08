package com.tournament.persistence;

import com.tournament.model.IMatch;
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
    private PreparedStatement stmt = null;

    @Override
    public void saveMatch(IMatch iMatch) {
        try {
            String saveQuery = "INSERT into matches (player1id,player2id,startTime,endTime,tournamentId) value (?,?,?,?,?)";
            setFieldValues(iMatch, saveQuery);
            stmt.executeUpdate();

            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void setFieldValues(IMatch iMatch, String save_query) throws SQLException {
        connection = dbConnection.establishDBConnection();
        stmt = connection.prepareStatement(save_query);
        stmt.setString(1, iMatch.getPlayer1id());
        stmt.setString(2, iMatch.getPlayer2id());
        stmt.setString(3, iMatch.getStartTime());
        stmt.setString(4, iMatch.getEndTime());
        stmt.setInt(5, iMatch.getTournamentId());
    }

    @Override
    public List<Match> getAllMatch() {
        List<Match> matchesList = new ArrayList<>();
        try {
            connection = dbConnection.establishDBConnection();
            String getAllMatchesQuery = "SELECT * from matches";
            stmt = connection.prepareStatement(getAllMatchesQuery);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Match match = new Match();
                    setFieldValues(match, rs);
                    matchesList.add(match);
                }
            }

            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return matchesList;
    }

    @Override
    public Match getMatchById(int matchId) {
        Match match = new Match();
        try {
            connection = dbConnection.establishDBConnection();
            String getMatchByIdQuery = "SELECT * from matches where matchId=?";
            stmt = connection.prepareStatement(getMatchByIdQuery);
            stmt.setInt(1, matchId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                setFieldValues(match, rs);
            }
            connection.close();
            return match;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
            String updateMatchByIdQuery = "UPDATE matches SET player1id=?,player2id=?,startTime=?,endTime=?,tournamentId=?,result=? where matchId=?";
            setFieldValues(match, updateMatchByIdQuery);
            stmt.setString(6, match.getMatchWinner());
            stmt.setInt(7, match.getMatchId());
            stmt.executeUpdate();

            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteMatch(int matchId) {
        try {
            connection = dbConnection.establishDBConnection();
            String deleteMatchByIdQuery = "DELETE From matches where matchId=?";
            stmt = connection.prepareStatement(deleteMatchByIdQuery);
            stmt.setInt(1, matchId);
            stmt.executeUpdate();

            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
