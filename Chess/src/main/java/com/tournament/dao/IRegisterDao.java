package com.tournament.dao;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IRegisterDao
{
    String insertUserDetails(Users userObj) throws SQLException;
}
