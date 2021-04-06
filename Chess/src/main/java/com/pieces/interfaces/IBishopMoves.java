package com.pieces.interfaces;

import com.pieces.Piece;

public interface IBishopMoves {

    Boolean diagonalMovement(Piece currentPiece, int finalCordX, int finalCordY);

    Boolean checkIfPieceInBetween(Piece currentPiece,int finalCordX, int finalCordY);

}
