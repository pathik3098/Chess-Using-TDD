import ChessBoard.Board;
import Pieces.Piece;
import Pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookTest {
    // check whether the destination is different colour piece or not
    @Test
    public void differentColourPieceTest(){
        Board board = new Board();
        Piece r = new Rook(0,0,true,"xyz", board);
        int x=2;
        int y=0;
        Rook dest_r=new Rook(x, y, true, "abc", board);
        Assertions.assertEquals(false,r.ValidMove(x,y));
    }

    // check whether the direction is straight or not

    @Test
    public void StraightMovementTest(){
        Board board = new Board();
        Rook r = new Rook(0,0,true,"xyz", board);
        int x=2;
        int y=0;
        Assertions.assertEquals(true,r.ValidMove(x,y));
    }

    // check whether there is a piece in between or not

    @Test
    public void ValidMoveTest(){
        Board board = new Board();
        Rook r = new Rook(0,0,true,"xyz", board);
        int x=2;
        int y=0;
        Rook dest_r=new Rook(1, 0, true, "abc", board);
        Assertions.assertEquals(false,r.ValidMove(x,y));
    }


}
