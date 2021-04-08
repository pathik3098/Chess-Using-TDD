package com.piecestest;
import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.Bishop;
import com.pieces.BishopMoves;
import com.pieces.Piece;
import com.pieces.interfaces.IBishopMoves;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BishopMovesTest {

    IBoard board = new Board();

    @Test
    public void diagonalNorthEastMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 0, 2));
    }

    @Test
    public void diagonalNorthWestMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 0, 0));
    }

    @Test
    public void diagonalSouthEastMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 2, 0));
    }

    @Test
    public void diagonalSouthWestMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 2, 0));
    }

    @Test
    public void straightMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(false, bishopMoves.diagonalMovement(bishop, 0, 1));
    }

    @Test
    public void sameColorPieceAttackTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(0, 1, true, "WB", board);
        assertEquals(true, bishopMoves.checkIfPieceNotInBetween(bishop, 0, 2));
    }

    @After
    public void destroy() {
        board = null;
    }

}
