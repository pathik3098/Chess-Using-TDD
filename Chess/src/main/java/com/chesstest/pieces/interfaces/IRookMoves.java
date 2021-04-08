package com.chesstest.pieces.interfaces;

import com.chesstest.pieces.Piece;

public interface IRookMoves {
    boolean straightMovement(Piece currentPiece, int destinationX, int destinationY);
    boolean checkPieceNotInBetween(Piece currentPiece, int destinationX, int destinationY);
}
