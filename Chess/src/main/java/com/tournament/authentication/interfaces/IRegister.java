package com.tournament.authentication.interfaces;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IRegister
{
    String userRegistration(Users userobj,String playerLevel) throws SQLException;
}
