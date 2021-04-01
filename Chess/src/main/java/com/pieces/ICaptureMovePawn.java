package com.pieces;

import com.chessboard.Board;

public interface ICaptureMovePawn
{
    void initialiseValues(Piece currentPiece,Piece targetPiece, Board boardobj);
    boolean cornerWhitePawnAttack(Piece currentPiece);
    boolean whitePawnAttack(Piece currentPiece);

    boolean cornerBlackPawnAttack(Piece currentPiece);
    boolean blackPawnAttack(Piece currentPiece);

}
