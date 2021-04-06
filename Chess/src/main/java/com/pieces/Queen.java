package com.pieces;

import com.chessboard.IBoard;
import com.pieces.interfaces.IBishopMoves;
import com.pieces.interfaces.IRookMoves;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queen extends Piece implements IQueen {

    IBishopMoves bishopMoves;
    IRookMoves rookMoves;

    public Queen(int initialX, int initialY, boolean isWhite, String filepath, IBoard board) {
        super(initialX, initialY, isWhite, filepath, board);
        bishopMoves = new BishopMoves(initialX, initialY, isWhite, filepath, board);
        rookMoves = new RookMoves(initialX, initialY, isWhite, filepath, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        List<Boolean> validationConditionList = new ArrayList();
        Piece piece = board.getPiece(finalCordX, finalCordY);

        validationConditionList.add(differentColourPiece(this, piece));
        validationConditionList.add(rookMoves.straightMovement(this, finalCordX, finalCordY) || bishopMoves.diagonalMovement(finalCordX, finalCordY));
        validationConditionList.add(rookMoves.checkPieceInBetween(this, finalCordX, finalCordY) || bishopMoves.checkIfPieceInBetween(finalCordX, finalCordY));

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
