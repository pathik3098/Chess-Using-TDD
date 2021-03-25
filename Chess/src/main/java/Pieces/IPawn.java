package Pieces;

public interface IPawn
{
    boolean canMoveWhite(Piece currentPiece, Piece targetPiece);
    boolean canMoveBlack(Piece currentPiece, Piece targetPiece);
}
