package com.pieces;

import com.chessboard.Board;

public class NormalPiece extends PieceFactory{
    @Override
    public Piece createKing(int x, int y, boolean isWhite, String path, Board board) {
        return new King(x,y,isWhite,path,board);
    }

    @Override
    public Piece createQueen(int x, int y, boolean isWhite, String path, Board board) {
        return new Queen(x,y,isWhite,path,board);
    }

    @Override
    public Piece createBishop(int x, int y, boolean isWhite, String path, Board board) {
        return new Bishop(x,y,isWhite,path,board);
    }

    @Override
    public Piece createKnight(int x, int y, boolean isWhite, String path, Board board) {
        return new Knight(x,y,isWhite,path,board);
    }

    @Override
    public Piece createRook(int x, int y, boolean isWhite, String path, Board board) {
        return new Rook(x,y,isWhite,path,board);
    }

    @Override
    public Piece createPawn(int x, int y, boolean isWhite, String path, Board board) {
        return new Pawn(x,y,isWhite,path,board);
    }
}