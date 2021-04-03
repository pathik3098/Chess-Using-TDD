package com.pieces;

import com.chessboard.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bishop extends Piece implements IBishop {

    public Bishop(int initialX, int initialY, boolean isWhite, String path, Board board) {
        super(initialX, initialY, isWhite, path, board);
    }

    private List<Boolean> validationConditionList = new ArrayList();
    private List<Boolean> directionConditionList = new ArrayList();

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        Piece piece = board.getPiece(finalCordX, finalCordY);

        validationConditionList.add(differentColourPiece(this, piece));
        validationConditionList.add(diagonalMovement(finalCordX, finalCordY));
        validationConditionList.add(checkIfPieceInBetween(finalCordX, finalCordY));

        Iterator<Boolean> iter = validationConditionList.iterator();
        while (iter.hasNext()) {
            Boolean isConditionSatisfied = iter.next();
            if (!isConditionSatisfied) {
                return false;
            }
        }
        return true;
//
//        if (checkValidMoveConditions(differentColourPiece(this, piece))) return false;
//
//        if (checkValidMoveConditions(diagonalMovement(finalCordX, finalCordY))) return false;
//
//        if (checkValidMoveConditions(checkIfPieceInBetween(finalCordX, finalCordY))) return false;
//
//        return true;
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

    public Directions getDirectionMovement(int finalCordX, int finalCordY) {

        int directionSignX = Integer.signum(finalCordX - this.getPositionX());
        int directionSignY = Integer.signum(finalCordY - this.getPositionY());

        if (directionSignX > 0 && directionSignY > 0) {
            return Directions.NORTHEAST;
        }
        if (directionSignX < 0 && directionSignY > 0) {
            return Directions.NORTHWEST;
        }
        if (directionSignX < 0 && directionSignY < 0) {
            return Directions.SOUTHWEST;
        }
        if (directionSignX > 0 && directionSignY < 0) {
            return Directions.SOUTHEAST;
        }
        return Directions.NORTHWEST;
    }

    @Override
    public Boolean checkIfPieceInBetween(int finalCordX, int finalCordY) {

        Directions Direction = getDirectionMovement(finalCordX, finalCordY);

        directionConditionList.add(checkPieceInBetweenNE(finalCordX, Direction));
        directionConditionList.add(checkPieceInBetweenNW(finalCordY, Direction));
        directionConditionList.add(checkPieceInBetweenSW(finalCordX, Direction));
        directionConditionList.add(checkPieceInBetweenSE(finalCordY, Direction));

        Iterator<Boolean> iter = directionConditionList.iterator();
        while (iter.hasNext()) {
            Boolean pieceInBetween = iter.next();
            if (pieceInBetween) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkPieceInBetweenNE(int finalCordX, Directions Direction) {
        if (Direction.equals(Directions.NORTHEAST)) {
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

    public Boolean checkPieceInBetweenNW(int finalCordY, Directions Direction) {
        if (Direction.equals(Directions.NORTHWEST)) {
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

    public Boolean checkPieceInBetweenSW(int finalCordX, Directions Direction) {
        if (Direction.equals(Directions.SOUTHWEST)) {
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

    public Boolean checkPieceInBetweenSE(int finalCordY, Directions Direction) {
        if (Direction.equals(Directions.SOUTHEAST)) {
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
