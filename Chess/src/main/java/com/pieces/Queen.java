package com.pieces;

import com.chessboard.Board;
import com.pieces.interfaces.IBishopMoves;
import com.pieces.interfaces.IRookMoves;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queen extends Piece {

    IBishopMoves iBishopMoves;
    IRookMoves iRookMoves;

    public Queen(int initialX, int initialY, boolean isWhite, String filepath, Board board) {
        super(initialX, initialY, isWhite, filepath, board);
        iBishopMoves = new BishopMoves(initialX, initialY, isWhite, filepath, board);
        iRookMoves = new RookMoves(initialX, initialY, isWhite, filepath, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        List<Boolean> validationConditionList = new ArrayList();
        Piece piece = board.getPiece(finalCordX, finalCordY);

        validationConditionList.add(differentColourPiece(this, piece));
        validationConditionList.add(iRookMoves.straightMovement(this, finalCordX, finalCordY) || iBishopMoves.diagonalMovement(finalCordX, finalCordY));
        validationConditionList.add(iRookMoves.checkPieceInBetween(this, finalCordX, finalCordY) || iBishopMoves.checkIfPieceInBetween(finalCordX, finalCordY));

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
