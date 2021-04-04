package com.pieces;

import com.chessboard.Board;
import com.pieces.interfaces.IRookMoves;

public class Rook extends Piece {

    IRookMoves iRookMoves;

    public Rook(int x, int y, boolean isWhite, String path, Board board) {
        super(x, y, isWhite, path, board);
        iRookMoves = new RookMoves(x, y, isWhite, path, board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY) {
        Piece piece = board.getPiece(destinationX, destinationY);

        boolean a = differentColourPiece(this, piece);
        boolean b = iRookMoves.straightMovement(this, destinationX, destinationY);
        boolean c = iRookMoves.isPieceInBetween(this, destinationX, destinationY);

        if (a && b && c) {
            return true;
        }

        return false;

    }


}
