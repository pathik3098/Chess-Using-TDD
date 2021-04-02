package com.tournament.persistence.interfaces;

import com.tournament.model.Users;

import java.sql.SQLException;

public interface IAuthenticationPersistence
{
     String validate(Users userObject) throws SQLException;
     String logOut(String currentActiveUser) throws SQLException;
}
