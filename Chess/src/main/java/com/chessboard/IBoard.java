package com.chessboard;

import com.pieces.Piece;

import java.util.ArrayList;
import java.util.Map;

public interface IBoard {

    public Piece getActivePiece();
    public Piece getPiece(int x,int y);
    public ArrayList<Piece> getBlackPieces();
    public ArrayList<Piece> getWhitePieces();
    public void chessMovement(int x,int y);
    public void removeBlackPieceFromBoard(Piece removePiece);
    public void addBlackPieceToBoard(Piece addPiece);
    public void removeWhitePieceFromBoard(Piece removePiece);
    public void addWhitePieceToBoard(Piece addPiece);
    public boolean inCheck();

    Board.Winner getResult();
    Map<String, String> getPositions();

    String isKingInCheck();

    String getActivePieceFilePath();
}
