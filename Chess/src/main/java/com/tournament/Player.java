package com.tournament;

import com.tournament.PlayerDB.IPlayerPersistence;

import java.sql.Time;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private int playerId;
    private int playerLevel;
    private Time logtime;
    private int playerPoints;
    private Alliance alliance;

    public Player(int id, IPlayerPersistence p){
        this.playerId = id;
        p.loadPlayer(id,this);
    }

    public Player(){

    }

    public Player(String playerName) {
        this.playerName=playerName;

    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getPlayerLevel()
    {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel)
    {
        this.playerLevel = playerLevel;
    }

    public Time getLogtime() {
        return logtime;
    }

    public void setLogtime(Time logtime) {
        this.logtime = logtime;
    }
}
