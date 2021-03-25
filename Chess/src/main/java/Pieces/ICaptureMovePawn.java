package Pieces;

public interface ICaptureMovePawn
{
    boolean cornerWhitePawnAttack(Piece currentPiece);
    boolean whitePawnAttack(Piece currentPiece);

    boolean cornerBlackPawnAttack(Piece currentPiece);
    boolean blackPawnAttack(Piece currentPiece);

}
