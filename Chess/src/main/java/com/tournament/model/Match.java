package com.tournament.model;

import com.chessboard.Board;
import com.tournament.Alliance;
import com.tournament.Player;

public class Match implements IMatch {

    Player player1;
    Player player2;
    int totalTime;
    Board board;
    Board.Winner result;

    private int matchId;
    private String player1id;
    private String player2id;
    private String startTime;
    private String endTime;
    private int tournamentId;
    private String matchWinner;

    @Override
    public String getPlayer1id() {
        return player1id;
    }

    @Override
    public void setPlayer1id(String player1id) {
        this.player1id = player1id;
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
    public int getMatchId() {
        return matchId;
    }

    @Override
    public void setMatchId(int matchId) {
        this.matchId = matchId;
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

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public Match() {
    }

    public Board getBoard() {
        return board;
    }

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.setPlayer1id(player1.getPlayerId());
        this.setPlayer2id(player2.getPlayerId());
        player1.setAlliance(Alliance.WHITE);
        player1.setAlliance(Alliance.BLACK);
        this.createBoard(player1, player2);
    }

    public void createBoard(Player player1, Player player2) {
        this.board = new Board();
    }

    public boolean getResult() {
        result = board.getResult();
        if (result == Board.Winner.WHITEWINNER) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public Player getWinner() {
        result = board.getResult();
        if (result == Board.Winner.WHITEWINNER)
        {
            setMatchWinner(player1.getPlayerId());
            return player1;
        }
        else
        {
            setMatchWinner(player2.getPlayerId());
            return player2;
        }
    }

}
