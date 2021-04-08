package com.tournament.persistence;
import com.tournament.persistenceconnection.PersistenceConnection;
import com.tournament.persistenceconnection.IPersistenceConnection;
import com.tournament.model.Users;
import com.tournament.persistence.interfaces.IRegisterPersistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterPersistence implements IRegisterPersistence
{
    IPersistenceConnection conObj = new PersistenceConnection();
    Connection connection;
    private PreparedStatement statement;

    public RegisterPersistence()
    {
        statement = null;
        connection = null;
    }

    private String saveUserQuery = "INSERT INTO User(email,userId,username,playerLevel,password,sessionFlag,activeTournament,LoginTime) VALUES (?,?,?,?,?,?,?,?)";

    public String saveUserDetails(Users userObj) throws SQLException
    {
        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(saveUserQuery);
            statement.setString(1,userObj.getEmail());
            statement.setString(2, userObj.getUserId());
            statement.setString(3, userObj.getUsername());
            statement.setInt(4, userObj.getPlayerLevel());
            statement.setString(5, userObj.getPassword());
            statement.setInt(6, userObj.getUserSessionFlag());
            statement.setInt(7, userObj.getActiveInTournament());
            statement.setString(8, userObj.getLoginTime());
            statement.executeUpdate();
            connection.close();
            return "RegisterSuccess";
        }
        catch(Exception E)
        {
            System.out.println("Something Went Wrong !" +E);
            connection.close();
            return "Registration Failed";
        }

    }
}
