package com.tournament.dao;

<<<<<<< HEAD
import com.tournament.utils.ValidatePassword;
import com.tournament.pojo.Users;
import com.tournament.databaseconnection.DBConnection;
import com.tournament.utils.ValidationPassword;
=======
import com.tournament.databaseconnection.DBConnection;
import com.tournament.model.Users;
>>>>>>> 13a93b45c1c7b107c9f344857daf573f2785560d

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
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

=======
public class LoginDao
{
    public String validate(Users userObject) throws SQLException {
>>>>>>> 13a93b45c1c7b107c9f344857daf573f2785560d
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

<<<<<<< HEAD
=======
        String inputUserName = userObject.getUserId();
        String inputPassword = userObject.getPassword();

>>>>>>> 13a93b45c1c7b107c9f344857daf573f2785560d
        String dbUserName = "";
        String dbPassword = "";
        int updateUserSessionFlag = 1;

        try {
            connection = DBConnection.establishDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from User");

            while (resultSet.next()) {
                dbUserName = resultSet.getString(2);
                dbPassword = resultSet.getString(3);
            }

            if (inputUserName.equals(dbUserName) && inputPassword.equals(dbPassword)) {
<<<<<<< HEAD
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
=======
                String update_query = "update User set UserSessionFlag =" + updateUserSessionFlag + " " + "where UserId =" + "'" + dbUserName + "'";
                statement.executeUpdate(update_query);
                return "LoginSuccessful";
            }
            connection.close();
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
>>>>>>> 13a93b45c1c7b107c9f344857daf573f2785560d
        }
        return "Invalid user credentials";
    }


}
