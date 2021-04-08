package com.piecestest;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.Bishop;
import com.pieces.BishopMoves;
import com.pieces.interfaces.IBishopMoves;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BishopMovesTest {

    IBoard board = new Board();

    @Test
    public void diagonalMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Bishop bishop = new Bishop(0, 1, true, "WB", board);
        assertEquals(false, bishopMoves.diagonalMovement(bishop, 1, 1));
    }

    @Test
    public void sameColorPieceAttackTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Bishop bishop = new Bishop(0, 1, true, "WB", board);
        assertEquals(true, bishopMoves.checkIfPieceInBetween(bishop, 0, 2));
    }

    @After
    public void destroy() {
        board = null;
    }

}
