package chesstest;

import ChessBoard.Board;
import Pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueenTest {

    Board bo1 = new Board();

    @Test
    public void sameAllyTest() {

        Queen queen = new Queen(1, 1, true, "filepath", bo1);

        assertEquals(false, queen.ValidMove(2, 2));
    }

    @Test
    public void movementTest() {
        Queen queen = new Queen(1, 1, true, "filepath", bo1);
        assertEquals(false, queen.ValidMove(2, 3));
    }

    @Test
    public void simpleTest() {
        Queen queen = new Queen(1, 1, true, "filepath", bo1);
        assertEquals(false, queen.ValidMove(2, 2));
    }

}
