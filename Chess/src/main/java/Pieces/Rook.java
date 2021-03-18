package Pieces;

import ChessBoard.Board;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rook extends Piece{

    public Rook(int x, int y, boolean isWhite, String path, Board board){
        super(x,y,isWhite,path,board);
    }

    @Override
    public boolean ValidMove(int destination_x, int destination_y) {

        Piece piece = board.getPiece(destination_x,destination_y);
        List Conditions = new ArrayList();

        Conditions.add(differentColourPiece(this,piece));
        Conditions.add(straightMovement(this,piece));
        Conditions.add(isPieceInBetween(this,piece));

        Iterator iter = Conditions.iterator();
        while(iter.hasNext())
        {

        }
        return false;
    }

    public boolean straightMovement(Piece currentPiece, Piece targetPiece) {
        return (currentPiece.getPositionX() == targetPiece.getPositionX()) || (currentPiece.getPositionY() == targetPiece.getPositionY());
    }

    public boolean isPieceInBetween(Piece currentPiece, Piece targetPiece){

        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = targetPiece.getPositionX();
        int targetY = targetPiece.getPositionY();

        int directionSignX = Integer.signum(targetX - currentX);
        int directionSignY = Integer.signum(targetY - currentY);

        if(directionSignX > 0)
        {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i=1 ; i < spaceToMove ; i++)
            {
                Piece p = board.getPiece(currentX + i,currentY);

                if(p != null)
                {
                    return false;
                }
            }
        }

        if(directionSignX < 0)
        {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i=1 ; i < spaceToMove ; i++)
            {
                Piece p = board.getPiece(currentX - i,currentY);

                if(p != null)
                {
                    return false;
                }
            }
        }

        if(directionSignY > 0)
        {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i=1 ; i < spaceToMove ; i++)
            {
                Piece p = board.getPiece(currentX,currentY + i);

                if(p != null)
                {
                    return false;
                }
            }
        }

        if(directionSignY < 0)
        {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i=1 ; i < spaceToMove ; i++)
            {
                Piece p = board.getPiece(currentX - i,currentY);

                if(p != null)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
