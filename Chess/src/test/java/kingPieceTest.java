import Pieces.kingPiece;
import ChessBoard.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class kingPieceTest {

    @Test
    void ValidMoveTest() {
        Board board = new Board();
        kingPiece king = new kingPiece(5,4,true,"path",board);
        Assertions.assertEquals(king.ValidMove(4,3),true);
    }
    @Test
    void ValidMoveNegativeTest() {
        Board board = new Board();
        kingPiece king = new kingPiece(5,4,true,"path",board);
        Assertions.assertNotEquals(king.ValidMove(3,6),true);
    }
    @Test
    void ValidMoveExclusionsTest(){
        Board board = new Board();
        kingPiece king = new kingPiece(3,0,true,"path",board);
        Assertions.assertEquals(king.ValidMove(3,1),true);
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Board board = new Board();
        kingPiece king = new kingPiece(3,0,true,"path",board);
        Assertions.assertNotEquals(king.ValidMove(3,-1),true);
    }
}