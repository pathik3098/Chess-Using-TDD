package com.tournament;

public class PlayerPairs {
    String firstPlayer,secondPlayer;

    PlayerPairs(String firstPlayer, String secondPlayer)
    {
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
    }

    public PlayerPairs() {

    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }
}
