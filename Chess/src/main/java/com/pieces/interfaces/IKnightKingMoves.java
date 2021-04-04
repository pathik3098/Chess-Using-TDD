package com.pieces.interfaces;

import com.pieces.Piece;

public interface IKnightKingMoves {

    boolean validMovement(Piece currentPiece, int destinationX, int destinationY, int[][] possibleMovePositions);
}
