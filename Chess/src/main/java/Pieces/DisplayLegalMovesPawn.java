package Pieces;
import ChessBoard.Board;

/* ClassName : displayLegalMovesPawn
/* Whenever the pawn piece is mouse pressed - Its possible or Legal moves will be displayed */
/* Method : display() */
/* Input Parameters : Obj-currentPiece , Obj-targetPiece */

class DisplayLegalMovesPawn extends Pawn
{
    private boolean hasMoved;
    public DisplayLegalMovesPawn(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x,y,isWhite,path,board);
    }

    public boolean getIsFirstMove()
    {
        return hasMoved;
    }

    public void display(Piece currentPiece, Piece targetPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = targetPiece.getPositionX();
        int targetY = targetPiece.getPositionY();

        if (isWhite())
        {
            if(getIsFirstMove())
            {

            }
        }

    }
}