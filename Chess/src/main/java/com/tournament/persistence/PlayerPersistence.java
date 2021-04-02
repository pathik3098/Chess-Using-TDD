package com.tournament.persistence;
import com.tournament.Player;
import com.tournament.persistence.interfaces.IPlayerPersistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerPersistence implements IPlayerPersistence {

    Connection conn = null;
    Statement statement = null;

    // establishing connection
    Connection con;

    String url_local = " ";
    String username_local = " ";
    String password_local = " ";

    {
        try {
            //Initiating Connection
            conn = DriverManager.getConnection(url_local, username_local, password_local);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    //Class.forName("com.mysql.cj.jdbc.Driver");

    @Override
    public void savePlayer()
    {

    }

    @Override
    public void loadPlayer(int playerId, Player player)
    {
        try
        {
            statement = conn.createStatement();
            ResultSet result_rows = statement.executeQuery(" select * from Player where playerId =" + playerId);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Player> loadAllPlayers()
    {
        String query = "select userId,username,playerLevel,LoginTime from user where sessionFlag = 1 order by LoginTime";
        ArrayList<Player> playerList = new ArrayList<>();

        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int UserId = rs.getInt("userId");
                String playerName = rs.getString("username");
                int PlayerLevel = rs.getInt("playerLevel");
                Time time = rs.getTime("LoginTime");
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
        String createQuery = "";

        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(createQuery);

            Iterator<Player> iter = playerList.iterator();

            while (iter.hasNext())
            {
                Player p = iter.next();
                String playerName = p.getPlayerName();
                int playerId = p.getPlayerId();
                int playerLevel = p.getPlayerLevel();
                Time logtime = p.getLogtime();
                int playerPoints = 0;

                String insertQuery = "";
                st.executeUpdate(insertQuery);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
