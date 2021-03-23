package com.tournament.model;

public class Users
{
    private String email;
    private String userId;
    private String username;
    private String playerLevel;
    private String password;
    private String conPassword;
    private int userSessionFlag;
    private int activeInTournament;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUsername() { return username;}

    public void setUsername(String username) { this.username = username; }

    public String getPlayerLevel() { return playerLevel;}

    public void setPlayerLevel(String playerLevel) { this.playerLevel = playerLevel; }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getConPassword(){
        return conPassword;
    }

    public void setConPassword(String conPassword){
        this.conPassword = conPassword;
    }

    public int getUserSessionFlag(){
        return userSessionFlag;
    }

    public void setUserSessionFlag(int userSessionFlag){
        this.userSessionFlag = userSessionFlag;
    }

    public int getActiveInTournament(){
        return activeInTournament;
    }

    public void setActiveInTournament(int activeInTournament){
        this.activeInTournament = activeInTournament;
    }

}
