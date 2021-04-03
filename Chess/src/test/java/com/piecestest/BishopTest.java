package com.piecestest;



import static org.junit.Assert.*;


import com.chessboard.Board;
import com.pieces.Bishop;
import com.pieces.Piece;
import org.junit.Test;

public class BishopTest {

    Board board = new Board();

    @Test
    public void sameAllyTest() {
        Piece bishop = new Bishop(0, 1, true, "Filepath", board);
        assertEquals(false, bishop.validMove(0, 2));
    }

    @Test
    public void diagonalMovementTest() {
        Piece bishop = new Bishop(0, 0, true, "Filepath", board);
        assertEquals(false, bishop.validMove(1, 1));
    }

    @Test
    public void simpleTest() {
        Piece bishop = new Bishop(1, 1, true, "Filepath", board);
        assertEquals(true, bishop.validMove(2, 2));
    }
}
