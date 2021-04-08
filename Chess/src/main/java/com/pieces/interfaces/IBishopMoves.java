package com.pieces.interfaces;

import com.pieces.Piece;

public interface IBishopMoves {

    Boolean diagonalMovement(Piece currentPiece, int destinationX, int destinationY);

    Boolean checkIfPieceNotInBetween(Piece currentPiece,int destinationX, int destinationY);

}
