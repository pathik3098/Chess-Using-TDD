package Pieces;

import ChessBoard.Board;
import java.util.ArrayList;

public class Pawn extends Piece
{
    private boolean hasMoved;
    public Pawn(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x,y,isWhite,path,board);
        hasMoved = false;
    }

    public void setIsFirstMove(boolean has_moved)
    {
        this.hasMoved = has_moved;
    }

    public boolean getIsFirstMove()
    {
        return hasMoved;
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY)
    {
        Piece targetPiece = board.getPiece(destinationX,destinationY);
        if(isWhite())
        {
            canMoveWhite(this,targetPiece);
            displayLegalMovesWhite(this,targetPiece);
        }
        else {
            canMoveBlack(this,targetPiece);
        }
        return false;
    }

    // White Pawns
    public boolean canMoveWhite(Piece currentPiece, Piece targetPiece)
    {
        if(getIsFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX())
                    || currentPiece.getPositionY()+2 ==targetPiece.getPositionY() ||
                    currentPiece.getPositionX()+1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        else
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX())
                    || currentPiece.getPositionX()+1 == targetPiece.getPositionY()+1)
            {
                return true;
            }
        }
        return false;
    }

    public void displayLegalMovesWhite(Piece currentPiece, Piece targetPiece)
    {

    }

    // Black Pawns
    public boolean canMoveBlack(Piece currentPiece, Piece targetPiece)
    {
        if(getIsFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX())
                    || currentPiece.getPositionY()-2 ==targetPiece.getPositionY()||
                    currentPiece.getPositionX()-1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        else
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX())
                    || currentPiece.getPositionX()-1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        return false;
    }


}
