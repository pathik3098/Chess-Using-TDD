package com.pieces;

import com.chessboard.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BishopMoves implements IBishopMoves {

    private int initialX;
    private int initialY;
    private boolean isWhite;
    private String filePath;
    public Board board;

    public BishopMoves(int initialX, int initialY, boolean isWhite, String filePath, Board board) {
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

        if (diffX != diffY) {
            return false;
        }
        return true;

    }

    @Override
    public Directions getDirectionMovement(int finalCordX, int finalCordY) {

        int directionSignX = Integer.signum(finalCordX - initialX);
        int directionSignY = Integer.signum(finalCordY - initialY);

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
        List<Boolean> directionConditionList = new ArrayList();

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
            int spaces_in_between = Math.abs(finalCordX - initialX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX + i, initialY + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenNW(int finalCordY, Directions Direction) {
        if (Direction.equals(Directions.NORTHWEST)) {
            int spaces_in_between = Math.abs(finalCordY - initialY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(initialX - i, initialY + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenSW(int finalCordX, Directions Direction) {
        if (Direction.equals(Directions.SOUTHWEST)) {
            int spaces_in_between = Math.abs(initialX - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX - i, initialY - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkPieceInBetweenSE(int finalCordY, Directions Direction) {
        if (Direction.equals(Directions.SOUTHEAST)) {
            int spaces_in_between = Math.abs(initialY - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(initialX + i, initialY - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

}
