package com.tournament.persistence;

import com.tournament.model.IUsers;
import com.tournament.model.Match;
import com.tournament.persistenceconnection.PersistenceConnection;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.model.Users;
import com.tournament.persistence.interfaces.IAuthenticationPersistence;
import org.apache.catalina.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationPersistence implements IAuthenticationPersistence
{
    String message = null;
    IPersistenceConnection conObj = new PersistenceConnection();
    private String Q_GETALL = "SELECT * FROM User";
    Connection connection = null;
    private PreparedStatement stmt = null;

    public String validate(Users userObject) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String inputUserId = userObject.getUserId();
        String inputPassword = userObject.getPassword();
        String loginTime = userObject.getLoginTime();

        String dbUserId = "";
        String dbPassword = "";
        int updateUserSessionFlag = 1;

        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();
            String select_Query = "select * from User where userId =" + "'" + inputUserId + "'";
            resultSet = statement.executeQuery(select_Query);

            while (resultSet.next()) {
                dbUserId = resultSet.getString(2);
                dbPassword = resultSet.getString(5);
            }

            if (inputUserId.equals(dbUserId) && inputPassword.equals(dbPassword))
            {
                String update_query = "update User set sessionFlag =" + updateUserSessionFlag + " " + "where userId =" + "'" + dbUserId + "'";
                statement.executeUpdate(update_query);
                String update_query2 = "update User set LoginTime =" + "'" + loginTime + "'" + "where userId =" + "'" + dbUserId + "'";
                statement.executeUpdate(update_query2);
                return "LoginSuccessful";
            }
            connection.close();
        }
        catch (SQLException E)
        {
            connection.close();
            return "Something Went Wrong !";
        }
        return "Invalid user credentials";
    }

    public String logOut(String currentActiveUser) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        String activeUser = currentActiveUser;

        int updateUserSessionFlag = 0;

        try {
            connection = conObj.establishDBConnection();
            statement = connection.createStatement();

            String update_query = "update User set sessionFlag =" + updateUserSessionFlag + " " + "where userId =" + "'" + activeUser + "'";
            statement.executeUpdate(update_query);
            message = "LogOut Successful";
            connection.close();
            return message;
        }
        catch (Exception E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return message;
        }

    }

    public Map<Integer, IUsers> getAllUsers(){
        Map<Integer, IUsers> userMap = new HashMap<Integer,IUsers>();

        try {
            connection = conObj.establishDBConnection();
            stmt = connection.prepareStatement(Q_GETALL);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("ww");
                IUsers user = new Users();
                user.setUserId(resultSet.getString("userId"));
                user.setUsername(resultSet.getString("username"));
                userMap.put(resultSet.getRow(), user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMap;
    }
}
