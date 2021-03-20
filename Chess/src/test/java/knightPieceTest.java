import Pieces.knightPiece;
import ChessBoard.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class knightPieceTest {

    @Test
    void ValidMoveTest() {
        Board board = new Board();
        knightPiece kp = new knightPiece(5,4,true,"path",board);
        Assertions.assertEquals(kp.ValidMove(3,3),true);
    }
    @Test
    void ValidMoveNegativeTest() {
        Board board = new Board();
        knightPiece kp = new knightPiece(5,4,true,"path",board);
        Assertions.assertNotEquals(kp.ValidMove(3,6),true);
    }
    @Test
    void ValidMoveExclusionsTest(){
        Board board = new Board();
        knightPiece kp = new knightPiece(3,0,true,"path",board);
        Assertions.assertEquals(kp.ValidMove(5,1),true);
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Board board = new Board();
        knightPiece kp = new knightPiece(3,0,true,"path",board);
        Assertions.assertNotEquals(kp.ValidMove(3,-1),true);
    }
}