package com.tournament.model;

public class UsersList
{
    private String userId;
    private String playerLevel;
    private String LoginTime;

    public UsersList(String userId, String playerLevel, String loginTime)
    {
        this.userId = userId;
        this.playerLevel = playerLevel;
        this.LoginTime = loginTime;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }


    public String getPlayerLevel() { return playerLevel;}

    public void setPlayerLevel(String playerLevel) { this.playerLevel = playerLevel; }


    public String getLoginTime() { return LoginTime;}

    public void setLoginTime(String LoginTime) { this.LoginTime = LoginTime; }

}
