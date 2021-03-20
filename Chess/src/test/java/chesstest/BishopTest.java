package chesstest;

import ChessBoard.Board;
import Pieces.Bishop;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

    Board bo1 = new Board();

    @Test
    public void sameAllyTest() {

        Bishop b1 = new Bishop(1, 1, true, "Filepath", bo1);

        assertEquals(false, b1.ValidMove(2, 2));
    }

    @Test
    public void movementTest() {
        Bishop b1 = new Bishop(1, 1, true, "Filepath", bo1);
        assertEquals(false, b1.ValidMove(2, 3));
    }

    @Test
    public void simpleTest() {
        Bishop b1 = new Bishop(1, 1, true, "Filepath", bo1);
        assertEquals(false, b1.ValidMove(2, 2));
    }
}
