package com.piecestest;



import static org.junit.Assert.*;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.Bishop;
import com.pieces.interfaces.IBishop;
import org.junit.Test;

public class BishopTest {

    IBoard board = new Board();

    @Test
    public void sameAllyTest() {
        IBishop bishop = new Bishop(0, 1, true, "WB", board);
        assertEquals(false, bishop.validMove(0, 2));
    }

    @Test
    public void diagonalMovementTest() {
        IBishop bishop = new Bishop(0, 0, true, "WB", board);
        assertEquals(false, bishop.validMove(1, 1));
    }

    @Test
    public void simpleTest() {
        IBishop bishop = new Bishop(1, 1, true, "WB", board);
        assertEquals(true, bishop.validMove(2, 2));
    }
}
