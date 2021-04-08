package com.tournament;

import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;

public class Player {

    private String playerName;
    private String playerId;
    private int playerLevel;
    private String logtime;
    private int playerPoints;
    private int tournamentId;
    private Alliance alliance;

    public enum Alliance{
        WHITE,
        BLACK
    }

    public Player()
    {
        this.playerPoints=0;
    }

    public Player(String playerName) {
        this.playerName=playerName;
    }

    public void updatePlayerPoints()
    {
        int winPoints = 2;
        playerPoints = playerPoints + winPoints;
        IPlayerPersistence persistence = new PlayerPersistence();
        persistence.savePlayer(this);
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

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
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
