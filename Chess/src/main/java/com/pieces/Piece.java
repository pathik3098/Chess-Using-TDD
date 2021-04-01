package com.pieces;

import com.chessboard.Board;

public abstract class Piece {

    private int positionX;
    private int positionY;
    private boolean isWhite;
    private String filePath;
    public Board board;

    public Piece(int x, int y, boolean isWhite, String path, Board board)
    {
        this.positionX=x;
        this.positionY=y;
        this.isWhite=isWhite;
        this.filePath = path;
        this.board = board;
    }

    public void setPositionX(int x)
    {
        this.positionX = x;
    }
    public int getPositionX()
    {
        return positionX;
    }
    public void setPositionY(int y)
    {
        this.positionY = y;
    }
    public int getPositionY()
    {
        return positionY;
    }
    public void setFilePath(String path)
    {
        this.filePath = path;
    }
    public String getFilePath()
    {
        return filePath;
    }
    public boolean isWhite()
    {
        return isWhite;
    }
    public boolean isBlack()
    {
        return !isWhite;
    }

    public abstract boolean ValidMove(int destinationX, int destinationY);

    public boolean differentColourPiece (Piece currentPiece, Piece targetPiece) {
        if (targetPiece == null)
        {
            return true;
        }
        else {
            if(targetPiece.isWhite() && currentPiece.isWhite()){
                return false;
            }
            if(targetPiece.isBlack() && currentPiece.isBlack()){
                return false;
            }
            else{
                return true;
            }
        }
    }

}
