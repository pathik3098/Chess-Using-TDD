package com.piecestest;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.interfaces.IQueen;
import com.pieces.Queen;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    IBoard board = new Board();

    @Test
    public void sameAllyTest() {
        IQueen queen = new Queen(1, 1, true, "BQ", board);
        assertEquals(false, queen.validMove(1, 2));
    }

    @Test
    public void checkNullMovementTest() {
        IQueen queen = new Queen(1, 1, true, "BQ", board);
        assertNull(board.getPiece(2, 2));
        assertEquals(true, queen.validMove(2, 2));
    }

    @Test
    public void straightMovementTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertEquals(false, queen.validMove(1, 4));
    }

    @Test
    public void horizontalMovementTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertEquals(false, queen.validMove(0, 5));
    }

    @Test
    public void diagonalMovementTest() {
        IQueen queen = new Queen(5, 5, true, "BQ", board);
        assertEquals(true, queen.validMove(6, 6));
    }

    @Test
    public void IsPieceInBetweenTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertEquals(false, queen.validMove(2, 2));
    }

    @After
    public void destroy() {
        board = null;
    }

}
