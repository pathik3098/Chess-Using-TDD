package com.pieces.abstractfactory;

import com.chessboard.Board;
import com.pieces.Piece;

public abstract class PieceFactory
{
    private static PieceFactory uniqueInstance = null;
    public static PieceFactory instance()
    {
        if (null == uniqueInstance)
        {
            uniqueInstance = new NormalPiece();
        }
        return uniqueInstance;
    }

    public static void setFactory(PieceFactory f)
    {
        uniqueInstance = f;
    }

    public abstract Piece createKing(int x, int y, boolean isWhite, String path, Board board);
    public abstract Piece createQueen(int x, int y, boolean isWhite, String path, Board board);
    public abstract Piece createBishop(int x, int y, boolean isWhite, String path, Board board);
    public abstract Piece createKnight(int x, int y, boolean isWhite, String path, Board board);
    public abstract Piece createRook(int x, int y, boolean isWhite, String path, Board board);
    public abstract Piece createPawn(int x, int y, boolean isWhite, String path, Board board);

}
