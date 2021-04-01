package com.tournament.dao;

import java.sql.*;
import java.util.ArrayList;
import com.tournament.model.*;

public class UsersListDao
{
    public ArrayList<UsersList> getAllUsers()
    {

        Connection local_conn = null;
        Connection remote_conn = null;

        Statement local_stmt1 = null;
        Statement remote_stmt1 = null;

        Time TIME = null;
        ArrayList<UsersList> userList = new ArrayList<>();

        //variables for establishing local connection
        String url_local = "jdbc:mysql://localhost:3306/mydb";
        String username_local = "root";
        String password_local = "sai18";

        try {
            //Initiating Connection
            remote_conn = DriverManager.getConnection(url_local, username_local, password_local);
            local_stmt1 = remote_conn.createStatement();
            ResultSet result_rows = local_stmt1.executeQuery("select userId,playerLevel,LoginTime from user where sessionFlag = 1 order by LoginTime");

            while (result_rows.next())
            {
                //String UserId = result_rows.getString("userId");
                //int PlayerLevel = result_rows.getInt("playerlevel");
                //TIME = result_rows.getTime("LoginTime");
                UsersList user = new UsersList(result_rows.getString("userId"), result_rows.getString("playerLevel"), result_rows.getString("LoginTime"));
                userList.add(user);
            }
        }
        catch (Exception E)
        {
            System.out.println(E);
        }
        return userList;
    }
}
