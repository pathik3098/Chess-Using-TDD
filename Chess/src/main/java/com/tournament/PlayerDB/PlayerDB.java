package com.tournament.PlayerDB;

import com.tournament.Player;

import java.sql.*;

public class PlayerDB implements IPlayerPersistence {

    Connection conn = null;
    Statement statement = null;
    Time TIME = null;

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
    public void savePlayer() {

    }

    @Override
    public void loadPlayer(int playerId, Player player)
    {
        try {
            statement = conn.createStatement();
            ResultSet result_rows = statement.executeQuery("select userId,username,playerLevel,LoginTime from user where sessionFlag = 1 AND userId = order by LoginTime");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //String UserId = result_rows.getString("userId");
        //int PlayerLevel = result_rows.getInt("playerlevel");
        //TIME = result_rows.getTime("LoginTime");
        //Users user = new Users(result_rows.getString("userId"), result_rows.getString("playerLevel"), result_rows.getString("LoginTime"));
        //UserList.add(user);
    }
}
