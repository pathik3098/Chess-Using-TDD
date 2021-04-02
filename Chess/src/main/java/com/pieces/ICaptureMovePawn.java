package com.pieces;

import com.chessboard.Board;

public interface ICaptureMovePawn
{
    void initialiseValues(Piece currentPiece,int destinationX,int destinationY, Board boardobj);
    boolean cornerWhitePawnAttack(Piece currentPiece);
    boolean whitePawnAttack(Piece currentPiece);

    boolean cornerBlackPawnAttack(Piece currentPiece);
    boolean blackPawnAttack(Piece currentPiece);

}
