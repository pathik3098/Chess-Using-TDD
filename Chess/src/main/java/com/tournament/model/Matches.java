package com.tournament.model;

public class Matches implements IMatches {

    private int matchId;
    private String player1id;
    private String player1Name;
    private String player2id;
    private String player2Name;
    private String startTime;
    private String endTime;
    private int tournamentId;
    private String result;

    @Override
    public int getMatchId() {
        return matchId;
    }

    @Override
    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Override
    public String getPlayer1id() {
        return player1id;
    }

    @Override
    public void setPlayer1id(String player1id) {
        this.player1id = player1id;
    }

    @Override
    public String getPlayer1Name() {
        return player1Name;
    }

    @Override
    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    @Override
    public String getPlayer2id() {
        return player2id;
    }

    @Override
    public void setPlayer2id(String player2id) {
        this.player2id = player2id;
    }

    @Override
    public String getPlayer2Name() {
        return player2Name;
    }

    @Override
    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    @Override
    public String getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public int getTournamentId() {
        return tournamentId;
    }

    @Override
    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }
}
