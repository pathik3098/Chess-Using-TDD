package com.chesstest.pieces;

import com.chesstest.chessboard.IBoard;
import com.chesstest.pieces.interfaces.IBishop;
import com.chesstest.pieces.interfaces.IBishopMoves;

public class Bishop extends Piece implements IBishop {

    IBishopMoves bishopMoves;

    public Bishop(int initialX, int initialY, boolean isWhite, String path, IBoard board) {
        super(initialX, initialY, isWhite, path, board);
        bishopMoves = new BishopMoves(board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY) {
        Piece piece = board.getPiece(destinationX, destinationY);

        Boolean isDifferentColorPiece = differentColourPiece(this, piece);
        Boolean isInDiagonalMovement = bishopMoves.diagonalMovement(this, destinationX, destinationY);
        Boolean isPieceNotInBetween = bishopMoves.checkIfPieceNotInBetween(this, destinationX, destinationY);

        return isDifferentColorPiece && isInDiagonalMovement && isPieceNotInBetween;
    }

}
