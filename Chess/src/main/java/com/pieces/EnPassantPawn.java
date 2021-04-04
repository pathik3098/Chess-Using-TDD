package com.pieces;

public class EnPassantPawn implements IEnPassantPawn
{
    private boolean enPassantAttack;

    public EnPassantPawn()
    {
        enPassantAttack = false;
    }

    public boolean checkEnPassantCapturingWhite(Piece currentPiece,int previousMovedBlackX, int previousMovedBlackY )
    {
        if (currentPiece.getPositionX() == 4) // White Pawn should have advanced 3 Ranks from its initial board position.
        {
            boolean left = (currentPiece.getPositionY()-1 == previousMovedBlackY && currentPiece.getPositionX() == previousMovedBlackX);
            boolean right = (currentPiece.getPositionY()+1 == previousMovedBlackY && currentPiece.getPositionX() == previousMovedBlackX);

            if(left || right)
            {
                enPassantAttack = true;
                return enPassantAttack;
            }
        }
        return enPassantAttack;
    }

    public boolean checkEnPassantCapturingBlack(Piece currentPiece,int previousMovedWhiteX, int previousMovedWhiteY )
    {
        if (currentPiece.getPositionX() == 3) // Black Pawn should have advanced 3 Ranks from its initial board position.
        {
            boolean left = (currentPiece.getPositionY()+1 == previousMovedWhiteY && currentPiece.getPositionX() == previousMovedWhiteX);
            boolean right = (currentPiece.getPositionY()-1 == previousMovedWhiteY && currentPiece.getPositionX() == previousMovedWhiteX);

            if(left || right)
            {
                enPassantAttack = true;
                return enPassantAttack;
            }
        }
        return enPassantAttack;
    }
}
