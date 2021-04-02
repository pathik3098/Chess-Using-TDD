package com.tournament.persistence;

import com.tournament.persistenceconnection.PersistenceConnection;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.model.Users;
import com.tournament.persistence.interfaces.IRegisterPersistence;

import java.sql.Connection;
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
