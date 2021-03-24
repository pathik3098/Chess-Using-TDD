package PiecesTest;

import ChessBoard.Board;
import Pieces.Bishop;
import Pieces.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BishopTest {

    Board board = new Board();

    @Test
    public void sameAllyTest() {
        Piece bishop = new Bishop(0, 1, true, "Filepath", board);
        assertEquals(false, bishop.ValidMove(0, 2));
    }

    @Test
    public void diagonalMovementTest() {
        Piece bishop = new Bishop(1, 1, true, "Filepath", board);
        assertEquals(false, bishop.ValidMove(2, 3));
    }

    @Test
    public void simpleTest() {
        Piece bishop = new Bishop(1, 1, true, "Filepath", board);
        assertEquals(true, bishop.ValidMove(2, 2));
    }
}
