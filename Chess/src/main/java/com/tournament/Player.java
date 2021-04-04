package com.tournament;

import com.tournament.persistence.interfaces.IPlayerPersistence;

import java.sql.Time;

public class Player {

    private String playerName;
    private String playerId;
    private int playerLevel;
    private String logtime;
    private int playerPoints;
    private int tournamentId;
    private Alliance alliance;

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

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
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

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }
}
