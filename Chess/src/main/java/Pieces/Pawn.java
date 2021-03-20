package Pieces;

import ChessBoard.Board;

public class Pawn extends Piece{

    public Pawn(int x, int y, boolean isWhite, String path, Board board) {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY) {
        return false;
    }

    public void setHasMoved(boolean b) {
    }
}
