package com.pieces;

public interface IBishopMoves {

    Boolean diagonalMovement(int finalCordX, int finalCordY);

    Boolean checkIfPieceInBetween(int finalCordX, int finalCordY);

    Directions getDirectionMovement(int finalCordX, int finalCordY);

    Boolean checkPieceInBetweenNE(int finalCordX, Directions Direction);

    Boolean checkPieceInBetweenNW(int finalCordX, Directions Direction);

    Boolean checkPieceInBetweenSW(int finalCordX, Directions Direction);

    Boolean checkPieceInBetweenSE(int finalCordX, Directions Direction);

}
