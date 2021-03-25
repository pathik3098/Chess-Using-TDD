package Pieces;

public interface ICaptureMovePawn
{
    public boolean cornerWhitePawnAttack(Piece currentPiece);
    public boolean whitePawnAttack(Piece currentPiece);

    public boolean cornerBlackPawnAttack(Piece currentPiece);
    public boolean blackPawnAttack(Piece currentPiece);

}
