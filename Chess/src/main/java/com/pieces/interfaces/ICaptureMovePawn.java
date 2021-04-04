package com.pieces.interfaces;

import com.chessboard.Board;
import com.pieces.Piece;

public interface ICaptureMovePawn
{
    void initialiseValues(Piece currentPiece, int destinationX, int destinationY, Board boardobj);
    boolean cornerWhitePawnAttack(Piece currentPiece);
    boolean whitePawnAttack(Piece currentPiece);

    boolean cornerBlackPawnAttack(Piece currentPiece);
    boolean blackPawnAttack(Piece currentPiece);

}
