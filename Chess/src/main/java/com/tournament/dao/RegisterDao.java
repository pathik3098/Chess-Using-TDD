package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import com.tournament.model.Users;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterDao {
    public String insertUserDetails(Users userObj)
    {
        String inputEmail = userObj.getEmail();
        String inputUserId = userObj.getUserId();
        String inputUsername = userObj.getUsername();
        String inputPlayerLevel = userObj.getPlayerLevel();
        String inputPassword = userObj.getPassword();
        int userSessionFlag = userObj.getUserSessionFlag();
        int activeInTournament = userObj.getActiveInTournament();


        Connection connection = null;
        Statement statement = null;

        try
        {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            String insert_query = "insert into User values(" + "'" +inputEmail+ "'" + "," + "'" +inputUserId+ "'"+ ","
                    + "'" +inputUsername+ "'"+ "," +inputPlayerLevel+ "," + "'" +inputPassword+ "'"+ "," +userSessionFlag+ "," +activeInTournament+ ")";

            statement.executeUpdate(insert_query);

            return "RegisterSuccess";
        }
        catch(Exception E)
        {
            System.out.println("Some Error !" +E);
        }
        return "InsertionFailed";
    }
}
