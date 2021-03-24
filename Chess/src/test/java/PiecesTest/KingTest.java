package PiecesTest;

import Pieces.King;
import ChessBoard.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KingTest {

    @Test
    void ValidMoveTest() {
        Board board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertEquals(king.ValidMove(4,3),true);
    }
    @Test
    void ValidMoveNegativeTest() {
        Board board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertNotEquals(king.ValidMove(3,6),true);
    }
    @Test
    void ValidMoveExclusionsTest(){
        Board board = new Board();
        King king = new King(3,0,true,"path",board);
        Assertions.assertEquals(king.ValidMove(3,1),true);
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Board board = new Board();
        King king = new King(3,0,true,"path",board);
        System.out.println("IN Negative Exclusions");
        Assertions.assertNotEquals(king.ValidMove(3,-1),true);
    }
}