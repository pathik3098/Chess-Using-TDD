package com.tournament.model;

public interface IUsers
{
    String getEmail();
    void setEmail(String email);

    String getUserId();
    void setUserId(String userId);

    String getUsername();
    void setUsername(String username);

    String getPlayerLevel();
    void setPlayerLevel(String playerLevel);

    String getPassword();
    void setPassword(String password);

    String getConPassword();
    void setConPassword(String conPassword);

    int getUserSessionFlag();
    void setUserSessionFlag(int userSessionFlag);

    int getActiveInTournament();
    void setActiveInTournament(int activeInTournament);
}
