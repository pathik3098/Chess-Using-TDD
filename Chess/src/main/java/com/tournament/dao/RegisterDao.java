package com.tournament.dao;

import com.tournament.pojo.Users;
import com.tournament.databaseconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterDao {
    public String userRegistration(Users userObj)
    {
        String inputEmail = userObj.getEmail();
        String inputUserName = userObj.getUserId();
        String inputPassword = userObj.getPassword();
        String inputConPassword = userObj.getConPassword();
        int UserSessionFlag = 0;

        if(inputUserName == null || inputPassword == null || inputEmail == null || inputConPassword == null )
        {
            return "Input strings can't be empty";
        }

        if (inputPassword != inputConPassword)
        {
            return "Passwords are not matching: Enter the correct one";
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            String insert_query = "insert into Users values(" +inputEmail+ "," +inputUserName+ "," + "'" +inputPassword+ "'" +  "," +UserSessionFlag+")";
            statement.executeUpdate(insert_query);

            return "RegisterSuccess";
        }
        catch(Exception E)
        {
            System.out.println("Some Error !" +E);
        }
        return "Invalid user credentials";
    }
}
