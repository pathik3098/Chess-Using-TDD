package Pieces;

import ChessBoard.Board;

public class Rook extends Piece{

    public Rook(int x, int y, boolean isWhite, Board board) {
        super(x, y, isWhite, board);
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY) {
        return false;
    }
}
