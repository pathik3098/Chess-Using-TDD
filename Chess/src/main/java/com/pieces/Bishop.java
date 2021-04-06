package com.pieces;

import com.chessboard.IBoard;
import com.pieces.interfaces.IBishop;
import com.pieces.interfaces.IBishopMoves;

public class Bishop extends Piece implements IBishop {

    IBishopMoves bishopMoves;

    public Bishop(int initialX, int initialY, boolean isWhite, String path, IBoard board) {
        super(initialX, initialY, isWhite, path, board);
        bishopMoves = new BishopMoves(initialX, initialY, isWhite, path, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {
        Piece piece = board.getPiece(finalCordX, finalCordY);

        Boolean isDifferentColorPiece = differentColourPiece(this, piece);
        Boolean isInDiagonalMovement = bishopMoves.diagonalMovement(finalCordX, finalCordY);
        Boolean isPieceNotInBetween = bishopMoves.checkIfPieceInBetween(finalCordX, finalCordY);

        if (isDifferentColorPiece && isInDiagonalMovement && isPieceNotInBetween) {
            return true;
        }
        return false;
    }

}
