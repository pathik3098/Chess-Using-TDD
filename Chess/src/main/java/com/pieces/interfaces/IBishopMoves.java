package com.pieces.interfaces;

public interface IBishopMoves {

    Boolean diagonalMovement(int finalCordX, int finalCordY);

    Boolean checkIfPieceInBetween(int finalCordX, int finalCordY);

}
