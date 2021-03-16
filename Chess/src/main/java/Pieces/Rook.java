package Pieces;

import ChessBoard.Board;
import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(int x, int y, boolean isWhite, String path, Board board){

        super(x,y,isWhite,path,board);
    }

    public boolean straightMovement(Piece currentPiece, Piece targetPiece) {

        if((currentPiece.getPositionX()==targetPiece.getPositionX())||(currentPiece.getPositionY()==targetPiece.getPositionY())){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isPieceInBetween(Piece currentPiece, Piece targetPiece){

        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = targetPiece.getPositionX();
        int targetY = targetPiece.getPositionY();

        int signX = Integer.signum(targetX - currentX);
        int signY = Integer.signum(targetY - currentY);

        while((targetX != currentX) && (targetY != currentY))
        {
            // here the first current position will be of the active piece itself,
            // so try to find a solution to that problem.

            Piece p = board.getPiece(currentX,currentY);

            if(p != null)
            {
              return  false;
            }

            currentX = currentX + (signX * 1);
            currentY = currentY + (signY * 1);
        }
        return true;
    }

    @Override
    public boolean ValidMove(int destination_x, int destination_y) {

        Piece piece = board.getPiece(destination_x,destination_y);
        ArrayList Conditions = new ArrayList();

        Conditions.add(differentColourPiece(this,piece));
        Conditions.add(straightMovement(this,piece));
        Conditions.add(isPieceInBetween(this,piece));

        return false;
    }
}
