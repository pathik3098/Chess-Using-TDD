package Pieces;

import ChessBoard.Board;

public class Bishop extends Piece {

    public Bishop(int initialX, int initialY, boolean isWhite, Board board) {
        super(initialX, initialY, isWhite, board);
    }

    @Override
    public boolean ValidMove(int finalCordX, int finalCordY) {

        Piece piece = board.getPiece(finalCordX, finalCordY);

        if (!this.differentColourPiece(this, piece)) {
            return false;
        }

        if (!checkDirectionMovement(finalCordX, finalCordY)) {
            return false;
        }

        if (!checkIfPieceInBetween(finalCordX, finalCordY)) {
            return false;
        }

        return true;
    }

    private boolean checkDirectionMovement(int finalCordX, int finalCordY) {
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
            return "NORTHEAST";
        }
        if (directionSignX < 0 && directionSignY > 0) {
            return "NORTHWEST";
        }
        if (directionSignX < 0 && directionSignY < 0) {
            return "SOUTHWEST";
        }
        if (directionSignX > 0 && directionSignY < 0) {
            return "SOUTHEAST";
        }
        return "";
    }

    public Boolean checkIfPieceInBetween(int finalCordX, int finalCordY) {

        String Direction = getDirectionMovement(finalCordX, finalCordY);

        if (Direction == "NORTHEAST") {
            int spaces_in_between = Math.abs(finalCordX - this.getPositionX()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() + i);
                if (p != null) {
                    return false;
                }
            }

        }

        if (Direction == "NORTHWEST") {
            int spaces_in_between = Math.abs(finalCordY - this.getPositionY()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() + i);
                if (p != null) {
                    return false;
                }
            }

        }

        if (Direction == "SOUTHWEST") {
            int spaces_in_between = Math.abs(this.getPositionX() - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }

        }

        if (Direction == "SOUTHEAST") {
            int spaces_in_between = Math.abs(this.getPositionY() - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }

        }

        return true;
    }

}
