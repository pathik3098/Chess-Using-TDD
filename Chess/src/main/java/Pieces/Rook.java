package Pieces;

import ChessBoard.Board;

abstract class movevalidator{

    public abstract boolean isvalidmove(Piece currentPiece,Piece targetPiece);

}
class SamePiece extends movevalidator{

    @Override
    public boolean isvalidmove(Piece currentPiece, Piece targetPiece) {
        if (targetPiece != null){
            if(targetPiece.isWhite() && currentPiece.isWhite()){
                return false;
            }
            if(targetPiece.isBlack() && currentPiece.isBlack()){
                return false;
            }
        }
            return true;
    }

}
class StraightMovement extends movevalidator{

    @Override
    public boolean isvalidmove(Piece currentPiece, Piece targetPiece) {
        if(currentPiece.getX() != targetPiece.getX() && currentPiece.getY()!= targetPiece.getY()){
            return false;
        }
        return true;
    }
}

class Direction extends movevalidator{

    private String direction = "";

    @Override
    public boolean isvalidmove(Piece currentPiece, Piece targetPiece) {
        if(targetPiece.getX()<currentPiece.getY()){
            direction="up";
        }
        if(targetPiece.getX()<currentPiece.getY()){
            direction="down";
        }
        if(targetPiece.getX()<currentPiece.getY()){
            direction="left";
        }
        if(targetPiece.getX()<currentPiece.getY()){
            direction="right";
        }

        if(direction.equals("up")){
            int path_length = Math.abs(targetPiece.getY()- currentPiece.getY());

           /*

           for(int i=1;i<path_length;i++){
                Piece a;
                a = Board.getPiece(currentPiece.getX(), currentPiece.getY()+i);
                if(a!=null){
                    return false;
                }
            }

            */
        }
        return true;

    }
}

public class Rook extends Piece{

    public Rook(int x, int y, boolean is_white, String path, Board board){
        super(x,y,is_white,path,board);
    }
    @Override
    public boolean ValidMove(int target_x, int target_y) {
        Piece Piece = board.getPiece(target_x,target_y);

        return false;
    }
}
