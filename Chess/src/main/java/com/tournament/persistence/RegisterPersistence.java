package com.tournament.persistence;

import com.tournament.persistenceconnection.PersistenceConnection;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.model.Users;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterPersistence implements IRegisterPersistence {
    public String insertUserDetails(Users userObj) throws SQLException {
        String inputEmail = userObj.getEmail();
        String inputUserId = userObj.getUserId();
        String inputUsername = userObj.getUsername();
        int inputPlayerLevel = userObj.getPlayerLevel();
        String inputPassword = userObj.getPassword();
        int userSessionFlag = userObj.getUserSessionFlag();
        int activeInTournament = userObj.getActiveInTournament();
        String loginTime = userObj.getLoginTime();

        IPersistenceConnection conObj = new PersistenceConnection();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String dbUserId= "";
        String dbPassword = "";
        int size =0;

        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();
            String select_Query = "SELECT * from User where userId =" + "'" +inputUserId+ "'";
            System.out.println(select_Query);
            resultSet = statement.executeQuery(select_Query);
            System.out.println(resultSet.next());
            if (resultSet != null)
            {
                resultSet.last();    // moves cursor to the last row
                size = resultSet.getRow(); // get row id
            }
            if (size < 1)
            {
                String insert_query = "insert into User values(" + "'" +inputEmail+ "'" + "," + "'" +inputUserId+ "'"+ ","
                        + "'" +inputUsername+ "'"+ "," +inputPlayerLevel+ "," + "'" +inputPassword+ "'"+ "," +userSessionFlag+ "," +activeInTournament+ "," +loginTime+ ")";

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
            System.out.println("Something Went Wrong !" +E);
            connection.close();
            return "Registration Failed";
        }

    }
}
