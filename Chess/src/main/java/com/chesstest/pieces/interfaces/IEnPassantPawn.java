package com.chesstest.pieces.interfaces;

import com.chesstest.pieces.Piece;

public interface IEnPassantPawn
{
    boolean checkEnPassantCapturingWhite(Piece currentPiece, int previousMovedBlackX, int previousMovedBlackY );
    boolean checkEnPassantCapturingBlack(Piece currentPiece,int previousMovedWhiteX, int previousMovedWhiteY );
}
