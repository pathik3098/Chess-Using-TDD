package com.chesstest.pieces.abstractfactory;

import com.chesstest.chessboard.Board;
import com.chesstest.pieces.Piece;

public abstract class AbstractPieceFactory
{
    private static AbstractPieceFactory uniqueInstance = null;
    public static AbstractPieceFactory instance()
    {
        if (null == uniqueInstance)
        {
            uniqueInstance = new ConcretePieceFactory();
        }
        return uniqueInstance;
    }

    public static void setFactory(AbstractPieceFactory f)
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
