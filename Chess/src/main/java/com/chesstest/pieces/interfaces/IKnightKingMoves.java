package com.chesstest.pieces.interfaces;

import com.chesstest.pieces.Piece;

public interface IKnightKingMoves {

    boolean validMovement(Piece currentPiece, int destinationX, int destinationY, int[][] possibleMovePositions);
}
