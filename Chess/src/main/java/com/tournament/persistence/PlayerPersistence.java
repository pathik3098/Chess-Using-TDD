package com.tournament.persistence;
import com.tournament.Player;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.persistenceconnection.PersistenceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerPersistence implements IPlayerPersistence {

    IPersistenceConnection conPersistence = new PersistenceConnection();
    Connection conn = null;
    Statement statement = null;

    //CREATE TABLE Player (Player_ID VARCHAR(50) NOT NULL,Player_Name VARCHAR(100),Player_Level INT,Player_Points INT, PRIMARY KEY ( Player_ID ));

    @Override
    public void savePlayer(Player player)
    {
        conn = conPersistence.establishDBConnection();
        String query = "Update Player SET Player_Points = ? WHERE Player_ID = ?;";
        try
        {
            PreparedStatement statement = null;
            statement = conn.prepareStatement(query);
            statement.setInt(1,player.getPlayerPoints());
            statement.setString(2,player.getPlayerId());
            int result = statement.executeUpdate(query);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
            if(statement != null){
                try
                {
                    statement.close();
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
        String createQuery = "create table";
        try
        {
            PreparedStatement st = null;
            String insertQuery = "INSERT INTO Player ( Player_ID, Player_Name, Player_Level, Player_Points) VALUES (?,?,?,?);";
            st = conn.prepareStatement(insertQuery);
            st.executeUpdate(createQuery);

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
}
