package com.pieces;

public interface IBishop {

    Boolean diagonalMovement(int finalCordX, int finalCordY);

    Boolean checkIfPieceInBetween(int finalCordX, int finalCordY);

    Directions getDirectionMovement(int finalCordX, int finalCordY);
    Boolean checkPieceInBetweenNE(int finalCordX, Directions Direction);
    Boolean checkPieceInBetweenNW(int finalCordY, Directions Direction);
    Boolean checkPieceInBetweenSW(int finalCordX, Directions Direction);
    Boolean checkPieceInBetweenSE(int finalCordY, Directions Direction);
}
