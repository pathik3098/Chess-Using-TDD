package com.tournament.pojo;

public class Users
{
    private String Email;
    private String UserId;
    private String password;
    private String conPassword;
    private int UserSessionFlag;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId){
        this.UserId = UserId;
    }

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
        return UserSessionFlag;
    }

    public void setUserSessionFlag(int UserSessionFlag){
        this.UserSessionFlag = UserSessionFlag;
    }

}
