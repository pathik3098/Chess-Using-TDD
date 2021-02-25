package Pieces;

import ChessBoard.Board;

public abstract class Piece {
    private int x,y;
    private boolean is_white;
    String path;
    Board board;


    public Piece(int x, int y, boolean is_white, String path, Board board){
        this.x=x;
        this.y=y;
        this.is_white=is_white;
        this.path = path;
        this.board = board;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean isWhite()
    {
        return is_white;
    }

    public boolean isBlack()
    {
        return !is_white;
    }

    // method to check the valid moves of a piece
    public abstract boolean ValidMove();

}
