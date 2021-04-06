package com.pieces;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.interfaces.IBishopMoves;

public class BishopMoves implements IBishopMoves {

    private int initialX;
    private int initialY;
    private boolean isWhite;
    private String filePath;
    public IBoard board;

    public BishopMoves(int initialX, int initialY, boolean isWhite, String filePath, IBoard board) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isWhite = isWhite;
        this.filePath = filePath;
        this.board = board;
    }

    @Override
    public Boolean diagonalMovement(int finalCordX, int finalCordY) {
        int diffX = Math.abs(finalCordX - initialX);
        int diffY = Math.abs(finalCordY - initialY);

        if (diffX == diffY) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkIfPieceInBetween(int finalCordX, int finalCordY) {
        int directionSignX = Integer.signum(finalCordX - initialX);
        int directionSignY = Integer.signum(finalCordY - initialY);

        if (directionSignX > 0 && directionSignY > 0) {
            int spaces_in_between = Math.abs(finalCordX - initialX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX + i, initialY + i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0 && directionSignY > 0) {
            int spaces_in_between = Math.abs(finalCordY - initialY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(initialX - i, initialY + i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(initialX - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX - i, initialY - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX > 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(initialY - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX + i, initialY - i);
                if (p != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
