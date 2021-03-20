package Pieces;

import ChessBoard.Board;

public class King extends Piece{

    public King(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY) {
        return false;
    }
}
