package com.pieces;

import com.chessboard.IBoard;
import com.pieces.interfaces.IRookMoves;

public class Rook extends Piece {

    IRookMoves rookMoves;

    public Rook(int x, int y, boolean isWhite, String path, IBoard board) {
        super(x, y, isWhite, path, board);
        rookMoves = new RookMoves(x, y, isWhite, path, board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY) {
        Piece piece = board.getPiece(destinationX, destinationY);

        boolean a = differentColourPiece(this, piece);
        boolean b = rookMoves.straightMovement(this, destinationX, destinationY);
        boolean c = rookMoves.checkPieceInBetween(this, destinationX, destinationY);

        if (a && b && c) {
            return true;
        }
        return false;
    }
}
