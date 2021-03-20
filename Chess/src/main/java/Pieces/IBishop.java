package Pieces;

public interface IBishop {

    String NORTHEAST = "NORTHEAST";
    String NORTHWEST = "NORTHWEST";
    String SOUTHEAST = "SOUTHEAST";
    String SOUTHWEST = "SOUTHWEST";

    Boolean diagonalMovement(int finalCordX, int finalCordY);

    Boolean checkIfPieceInBetween(int finalCordX, int finalCordY);

    String getDirectionMovement(int finalCordX, int finalCordY);
    Boolean checkPieceInBetweenNE(int finalCordX, String Direction);
    Boolean checkPieceInBetweenNW(int finalCordY, String Direction);
    Boolean checkPieceInBetweenSW(int finalCordX, String Direction);
    Boolean checkPieceInBetweenSE(int finalCordY, String Direction);
}
