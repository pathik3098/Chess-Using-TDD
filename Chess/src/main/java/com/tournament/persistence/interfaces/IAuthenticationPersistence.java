package com.tournament.persistence.interfaces;
import java.sql.SQLException;
public interface IAuthenticationPersistence
{
     String loadUser(String inputUserId) throws SQLException;
     String updateUser(String inputUserId,String inputPassword,String loginTime) throws SQLException;
     String logOut(String currentActiveUser) throws SQLException;
}
