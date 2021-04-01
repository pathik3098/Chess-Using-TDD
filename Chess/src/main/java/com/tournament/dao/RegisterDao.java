package com.tournament.dao;

import com.tournament.databaseconnection.DBConnection;
import com.tournament.databaseconnection.DBConnectionInterface;
import com.tournament.model.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao implements IRegisterDao {
    public String insertUserDetails(Users userObj) throws SQLException {
        String inputEmail = userObj.getEmail();
        String inputUserId = userObj.getUserId();
        String inputUsername = userObj.getUsername();
        int inputPlayerLevel = userObj.getPlayerLevel();
        String inputPassword = userObj.getPassword();
        int userSessionFlag = userObj.getUserSessionFlag();
        int activeInTournament = userObj.getActiveInTournament();

        DBConnectionInterface conObj = new DBConnection();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String dbUserId= "";
        String dbPassword = "";

        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();
            String select_Query = "select * from User where UserId =" + "'" +inputUserId+ "')";
            resultSet = statement.executeQuery(select_Query);
            String userIdPresent = resultSet.getString("UserId");
            if (userIdPresent == null)
            {
                String insert_query = "insert into User values(" + "'" +inputEmail+ "'" + "," + "'" +inputUserId+ "'"+ ","
                        + "'" +inputUsername+ "'"+ "," +inputPlayerLevel+ "," + "'" +inputPassword+ "'"+ "," +userSessionFlag+ "," +activeInTournament+ ")";

                statement.executeUpdate(insert_query);

                connection.close();
                return "RegisterSuccess";
            }
            else
            {
                return "UserId is already taken: Try Again!";
            }


        }
        catch(Exception E)
        {
            System.out.println("Some Error !" +E);
            connection.close();
            return "InsertionFailed";
        }

    }
}
