package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import com.tournament.databaseconnection.DBConnectionInterface;
import com.tournament.model.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class RegisterDao implements IRegisterDao {
    public String insertUserDetails(Users userObj) throws SQLException {
        String inputEmail = userObj.getEmail();
        String inputUserId = userObj.getUserId();
        String inputUsername = userObj.getUsername();
        int inputPlayerLevel = userObj.getPlayerLevel();
        String inputPassword = userObj.getPassword();
        int userSessionFlag = userObj.getUserSessionFlag();
        int activeInTournament = userObj.getActiveInTournament();
        String loginTime = userObj.getLoginTime();

        DBConnectionInterface conObj = new DBConnection();

        Connection connection = null;
        Statement statement = null;

        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();
            String insert_query = "insert into User values(" + "'" +inputEmail+ "'" + "," + "'" +inputUserId+ "'"+ ","
                    + "'" +inputUsername+ "'"+ "," +inputPlayerLevel+ "," + "'" +inputPassword+ "'"+ "," +userSessionFlag+ "," +activeInTournament+ "'" +loginTime+ "'" + ")";

            statement.executeUpdate(insert_query);

            connection.close();
            return "RegisterSuccess";
        }
        catch(Exception E)
        {
            System.out.println("Some Error !" +E);
            connection.close();
            return "InsertionFailed";
        }

    }
}
