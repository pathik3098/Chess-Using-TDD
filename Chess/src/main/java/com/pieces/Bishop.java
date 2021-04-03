package com.pieces;

import com.chessboard.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bishop extends Piece {

    IBishopMoves iBishopMoves;

    public Bishop(int initialX, int initialY, boolean isWhite, String path, Board board) {
        super(initialX, initialY, isWhite, path, board);
        iBishopMoves = new BishopMoves(initialX, initialY, isWhite, path, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {
        List<Boolean> validationConditionList = new ArrayList();
        Piece piece = board.getPiece(finalCordX, finalCordY);

        validationConditionList.add(differentColourPiece(this, piece));
        validationConditionList.add(iBishopMoves.diagonalMovement(finalCordX, finalCordY));
        validationConditionList.add(iBishopMoves.checkIfPieceInBetween(finalCordX, finalCordY));

        Iterator<Boolean> iter = validationConditionList.iterator();
        while (iter.hasNext()) {
            Boolean isConditionSatisfied = iter.next();
            if (!isConditionSatisfied) {
                return false;
            }
        }
        return true;
    }

}
