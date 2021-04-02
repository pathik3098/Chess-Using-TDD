package com.pieces;

import com.chessboard.Board;

public class Bishop extends Piece implements IBishop {

    public Bishop(int initialX, int initialY, boolean isWhite, String path, Board board) {
        super(initialX, initialY, isWhite, path, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        Piece piece = board.getPiece(finalCordX, finalCordY);

        if (checkValidMoveConditions(differentColourPiece(this, piece))) return false;

        if (checkValidMoveConditions(diagonalMovement(finalCordX, finalCordY))) return false;

        if (checkValidMoveConditions(checkIfPieceInBetween(finalCordX, finalCordY))) return false;

        return true;
    }

    private boolean checkValidMoveConditions(boolean condition) {
        if (!condition) {
            return true;
        }
        return false;
    }

    public Boolean diagonalMovement(int finalCordX, int finalCordY) {
        int diffX = Math.abs(finalCordX - this.getPositionX());
        int diffY = Math.abs(finalCordY - this.getPositionY());

        if (diffX != diffY) {
            return false;
        }
        return true;

    }

    public String getDirectionMovement(int finalCordX, int finalCordY) {

        int directionSignX = Integer.signum(finalCordX - this.getPositionX());
        int directionSignY = Integer.signum(finalCordY - this.getPositionY());

        if (directionSignX > 0 && directionSignY > 0) {
            return NORTHEAST;
        }
        if (directionSignX < 0 && directionSignY > 0) {
            return NORTHWEST;
        }
        if (directionSignX < 0 && directionSignY < 0) {
            return SOUTHWEST;
        }
        if (directionSignX > 0 && directionSignY < 0) {
            return SOUTHEAST;
        }
        return "";
    }

    @Override
    public Boolean checkIfPieceInBetween(int finalCordX, int finalCordY) {

        String Direction = getDirectionMovement(finalCordX, finalCordY);

        if (checkPieceInBetweenNE(finalCordX, Direction)) return false;

        if (checkPieceInBetweenNW(finalCordY, Direction)) return false;

        if (checkPieceInBetweenSW(finalCordX, Direction)) return false;

        if (checkPieceInBetweenSE(finalCordY, Direction)) return false;

        return true;
    }

    public Boolean checkPieceInBetweenNE(int finalCordX, String Direction) {
        if (Direction.equals(NORTHEAST)) {
            int spaces_in_between = Math.abs(finalCordX - this.getPositionX()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenNW(int finalCordY, String Direction) {
        if (Direction.equals(NORTHWEST)) {
            int spaces_in_between = Math.abs(finalCordY - this.getPositionY()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenSW(int finalCordX, String Direction) {
        if (Direction.equals(SOUTHWEST)) {
            int spaces_in_between = Math.abs(this.getPositionX() - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenSE(int finalCordY, String Direction) {
        if (Direction.equals(SOUTHEAST)) {
            int spaces_in_between = Math.abs(this.getPositionY() - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

}
