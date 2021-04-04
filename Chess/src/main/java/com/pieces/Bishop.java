package com.pieces;

import com.chessboard.Board;
import com.pieces.interfaces.IBishopMoves;

public class Bishop extends Piece {

    IBishopMoves iBishopMoves;

    public Bishop(int initialX, int initialY, boolean isWhite, String path, Board board) {
        super(initialX, initialY, isWhite, path, board);
        iBishopMoves = new BishopMoves(initialX, initialY, isWhite, path, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {
        Piece piece = board.getPiece(finalCordX, finalCordY);

        Boolean isDifferentColorPiece = differentColourPiece(this, piece);
        Boolean isInDiagonalMovement = iBishopMoves.diagonalMovement(finalCordX, finalCordY);
        Boolean isPieceNotInBetween = iBishopMoves.checkIfPieceInBetween(finalCordX, finalCordY);

        if (isDifferentColorPiece && isInDiagonalMovement && isPieceNotInBetween) {
            return true;
        }
        return false;
    }

}
