package com.tournament.authentication;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IRegister
{
    String userRegistration(Users userobj) throws SQLException;
}
