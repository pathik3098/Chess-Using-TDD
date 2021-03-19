package Pieces;

import ChessBoard.Board;
import java.util.ArrayList;

public class Pawn extends Piece
{

    public Pawn(int x, int y, boolean isWhite, String path, Board board,boolean isFirstMove)
    {
        super(x,y,isWhite,path,board,isFirstMove);
    }

    @Override
    public boolean validMove(int destination_x, int destination_y)
    {
        Piece targetPiece = board.getPiece(destination_x,destination_y);
        if(isWhite())
        {
            canMoveWhite(this,targetPiece);
        }
        else {
            canMoveBlack(this,targetPiece);
        }
        return false;
    }


    public boolean canMoveWhite(Piece currentPiece, Piece targetPiece)
    {
        if(isFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX()) || currentPiece.getPositionY()+2 ==targetPiece.getPositionY() ||
                    currentPiece.getPositionX()+1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        else if(!isFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX())|| currentPiece.getPositionX()+1 == targetPiece.getPositionY()+1)
            {
                return true;
            }
        }
        else
        {
            return false;
        }

        return false;
    }

    public boolean canMoveBlack(Piece currentPiece, Piece targetPiece)
    {
        if(isFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX()) || currentPiece.getPositionY()-2 ==targetPiece.getPositionY()||
                    currentPiece.getPositionX()-1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        else if(!isFirstMove())
        {
            if((targetPiece!= null && currentPiece.getPositionX() == targetPiece.getPositionX()) || currentPiece.getPositionX()-1 == targetPiece.getPositionY())
            {
                return true;
            }
        }
        else
        {
            return false;
        }

        return false;
    }
}
