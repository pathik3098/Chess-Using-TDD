package com.tournament;

import com.chessboard.Board;

public class Match {

    Player player1;
    Player player2;
    int totalTime;
    Board board;
    Board.Winner result;

    public Match(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        player1.setAlliance(Alliance.WHITE);
        player1.setAlliance(Alliance.BLACK);
        this.createBoard(player1,player2);
    }

    private void createBoard(Player player1,Player player2)
    {
        this.board = new Board();
    }

    public boolean getResult()
    {
        result = board.getResult();
        if(result == Board.Winner.WHITEWINNER)
        {
            return true;
        }

        else{
            return false;
        }
    }

    public int getTotalTime()
    {
        return totalTime;
    }

    public void setTotalTime(int totalTime)
    {
        this.totalTime = totalTime;
    }

    public Player getWinner()
    {
        if(getResult())
        {
            return player1;
        }
        else{
            return player2;
        }
    }

}
