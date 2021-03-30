package com.tournament.dao;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IAuthenticationDao
{
     String validate(Users userObject) throws SQLException;
     String logOut(String currentActiveUser) throws SQLException;
}
