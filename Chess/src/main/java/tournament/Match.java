package tournament;

import ChessBoard.Board;

import java.util.Random;

public class Match {
    String player1;
    String player2;

    String player1Color;
    String player2Color;
    int totalTime;

    Board board;
    String result;


    String[] color = {"white", "black"};

    public Match(String player1, String player2) {
        Random random = new Random();

        int randColorIndex = random.nextInt(color.length);
        int inverseColorIndex;
        if (randColorIndex == 0) {
            inverseColorIndex = 1;
        } else {
            inverseColorIndex = 0;
        }

        this.player1 = player1;
        this.player2 = player2;
        this.player1Color = color[randColorIndex];
        this.player2Color = color[inverseColorIndex];

        System.out.println(this.player1Color);
        System.out.println(this.player2Color);

        this.createBoard();
    }

    private void createBoard() {
        this.board = new Board();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer1Color() {
        return player1Color;
    }

    public void setPlayer1Color(String player1Color) {
        this.player1Color = player1Color;
    }

    public String getPlayer2Color() {
        return player2Color;
    }

    public void setPlayer2Color(String player2Color) {
        this.player2Color = player2Color;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }


}
