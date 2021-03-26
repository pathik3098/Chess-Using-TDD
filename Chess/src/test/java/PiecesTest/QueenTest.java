package PiecesTest;

import ChessBoard.Board;
import Pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueenTest {

    Board board = new Board();

    @Test
    public void sameAllyTest() {
        Queen queen = new Queen(1, 1, true, "filepath", board);
        assertEquals(false, queen.ValidMove(1, 2));
    }

    @Test
    public void checkNullMovementTest() {
        Queen queen = new Queen(1, 1, true, "filepath", board);
        assertNull(board.getPiece(2, 2));
//        assertEquals(true, queen.ValidMove(2, 2));
    }

    @Test
    public void straightMovementTest() {
        Queen queen = new Queen(0, 4, true, "filepath", board);
        assertEquals(false, queen.ValidMove(1, 4));
    }

    @Test
    public void horizontalMovementTest() {
        Queen queen = new Queen(0, 4, true, "filepath", board);
        assertEquals(false, queen.ValidMove(0, 5));
    }

    @Test
    public void diagonalMovementTest() {
        Queen queen = new Queen(0, 4, true, "filepath", board);
        assertEquals(true, queen.ValidMove(1, 5));
    }

    @Test
    public void IsPieceInBetweenTest() {
        Queen queen = new Queen(0, 4, true, "filepath", board);
        assertEquals(false, queen.ValidMove(2, 2));
    }

}