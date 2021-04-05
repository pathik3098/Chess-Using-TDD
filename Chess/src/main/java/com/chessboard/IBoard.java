package com.chessboard;

import com.pieces.Piece;

public interface IBoard {

    public Piece getActivePiece();
    public Piece getPiece(int x,int y);
    public void chessMovement(int x,int y);
    public void removeBlackPieceFromBoard(Piece removePiece);
    public void addBlackPieceToBoard(Piece addPiece);
    public void removeWhitePieceFromBoard(Piece removePiece);
    public void addWhitePieceToBoard(Piece addPiece);

}
