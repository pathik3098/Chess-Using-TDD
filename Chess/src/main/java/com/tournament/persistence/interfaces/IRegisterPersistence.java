package com.tournament.persistence.interfaces;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IRegisterPersistence
{
    String insertUserDetails(Users userObj) throws SQLException;
}
