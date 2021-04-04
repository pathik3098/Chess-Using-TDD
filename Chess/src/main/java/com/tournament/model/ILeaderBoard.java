package com.tournament.model;

public interface ILeaderBoard {

    public int getId();
    public void setId(int id);

    public String getPlayerId();
    public void setPlayerId(String playerId);

    public int getTournamentId();
    public void setTournamentId(int tournamentId);

    public int getPoints();
    public void setPoints(int points);
}
