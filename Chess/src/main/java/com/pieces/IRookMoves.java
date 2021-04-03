package com.pieces;

public interface IRookMoves {
    boolean straightMovement(Piece currentPiece, int destinationX, int destinationY);

    boolean isPieceInBetween(Piece currentPiece, int destinationX, int destinationY);
}
