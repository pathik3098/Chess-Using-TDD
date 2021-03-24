package com.tournament.dao;

import com.tournament.model.Users;
import com.tournament.databaseconnection.DBConnection;
import com.tournament.utils.ValidationPassword;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    ValidationPassword validationPassword;

    public String userAuthentication(Users userObj) {
        String inputUserName = userObj.getUserId();
        String inputPassword = userObj.getPassword();

        if (inputUserName == null || inputPassword == null) {
            return "Input strings can't be empty";
        }

        if (!validationPassword.isPasswordValid(inputPassword)) {
            return "Invalid Password Format";
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String dbUserName = "";
        String dbPassword = "";
        int updateUserSessionFlag = 1;

        try {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Users");

            while (resultSet.next()) {
                dbUserName = resultSet.getString(2);
                dbPassword = resultSet.getString(3);
            }

            if (inputUserName.equals(dbUserName) && inputPassword.equals(dbPassword)) {
                return "SUCCESS";
            }

            try {
                String update_query = "update User set UserSessionFlag =" + updateUserSessionFlag + " " + "where UserId =" + "'" + dbUserName + "'";
                statement.executeUpdate(update_query);
            } catch (SQLException Err) {
                System.out.println("Sql Error !" + Err);
            }

        } catch (Exception E) {
            System.out.println("Some Error !" + E);
        }
        return "Invalid user credentials";
    }


}
