package com.tournament.persistence.interfaces;

import com.tournament.model.IUsers;
import com.tournament.model.Users;

import java.sql.SQLException;
import java.util.Map;

public interface IAuthenticationPersistence
{
     String validate(Users userObject) throws SQLException;
     String logOut(String currentActiveUser) throws SQLException;
     Map<Integer, IUsers> getAllUsers();
}
