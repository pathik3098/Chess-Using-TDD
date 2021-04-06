package com.pieces.interfaces;

import com.pieces.Piece;

public interface IRookMoves {
    boolean straightMovement(Piece currentPiece, int destinationX, int destinationY);
    boolean checkPieceNotInBetween(Piece currentPiece, int destinationX, int destinationY);
}
