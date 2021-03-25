package Pieces;

public interface IPawn
{
    public boolean canMoveWhite(Piece currentPiece, Piece targetPiece);
    public boolean canMoveBlack(Piece currentPiece, Piece targetPiece);
}
