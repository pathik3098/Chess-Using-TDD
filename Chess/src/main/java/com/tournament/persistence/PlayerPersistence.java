package com.tournament.persistence;
import com.tournament.Player;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerPersistence implements IPlayerPersistence {

    IPersistenceConnection conPersistence = new PersistenceConnection();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;

    @Override
    public void savePlayer(Player player)
    {
        conn = conPersistence.establishDBConnection();
        String query = "Update Player SET Player_Points = ? WHERE Player_ID = ?;";
        try
        {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,player.getPlayerPoints());
            preparedStatement.setString(2,player.getPlayerId());
            preparedStatement.executeUpdate(query);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
            if(preparedStatement != null){
                try
                {
                    preparedStatement.close();
                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<Player> loadAllPlayers()
    {
        String query = "select userId,username,playerLevel,LoginTime from user where sessionFlag = 1 order by LoginTime;";
        ArrayList<Player> playerList = new ArrayList<>();

        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                String UserId = rs.getString("userId");
                String playerName = rs.getString("username");
                int PlayerLevel = rs.getInt("playerLevel");
                String time = rs.getString("LoginTime");
                Player p = new Player();
                p.setPlayerId(UserId);
                p.setPlayerName(playerName);
                p.setLogtime(time);

                playerList.add(p);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return playerList;
    }

    @Override
    public void saveAllPlayers(ArrayList<Player> playerList)
    {
        try
        {
            PreparedStatement st;
            String insertQuery = "INSERT INTO Player ( Player_ID, Player_Name, Player_Level, Player_Points) VALUES (?,?,?,?);";
            st = conn.prepareStatement(insertQuery);
            st.executeUpdate(insertQuery);

            Iterator<Player> iter = playerList.iterator();

            while (iter.hasNext())
            {
                Player p = iter.next();
                st.executeUpdate(insertQuery);
                st.setString(1,p.getPlayerId());
                st.setString(2,p.getPlayerName());
                st.setInt(3,p.getPlayerLevel());
                st.setInt(4,0);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Player> getLeaderboard(int tournamentId) {
        List<Player> leaderBoardList = new ArrayList<>();
        try {
            connection = conPersistence.establishDBConnection();
            String queryGetPlayersPointsByTournamentId = "SELECT PlayerName, PlayerPoints FROM PLAYERS WHERE TounamentId=? ORDER BY PlayerPoints";
            preparedStatement = connection.prepareStatement(queryGetPlayersPointsByTournamentId);
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
