package com.pieces;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.interfaces.IBishopMoves;

public class BishopMoves implements IBishopMoves {

    private int initialX;
    private int initialY;
    private boolean isWhite;
    public IBoard board;

    public BishopMoves(int initialX, int initialY, boolean isWhite, IBoard board) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isWhite = isWhite;
        this.board = board;
    }

    @Override
    public Boolean diagonalMovement(Piece currentPiece,int finalCordX, int finalCordY) {
        int diffX = Math.abs(finalCordX - currentPiece.getPositionX());
        int diffY = Math.abs(finalCordY - currentPiece.getPositionY());

        if (diffX == diffY) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkIfPieceInBetween(Piece currentPiece,int finalCordX, int finalCordY) {
        int directionSignX = Integer.signum(finalCordX - currentPiece.getPositionX());
        int directionSignY = Integer.signum(finalCordY - currentPiece.getPositionY());

        if (directionSignX > 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(finalCordX - currentPiece.getPositionX()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(finalCordY - currentPiece.getPositionY()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(currentPiece.getPositionX() - i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX > 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(currentPiece.getPositionX() - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX > 0 && directionSignY > 0) {
            int spaces_in_between = Math.abs(currentPiece.getPositionY() - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() + i);
                if (p != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
