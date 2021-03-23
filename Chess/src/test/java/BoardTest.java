import ChessBoard.Board;
import Pieces.King;
import Pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void getPieceTest() {
        Board board = new Board();
        Piece piece = board.getPiece(0,3);
        Assertions.assertTrue(piece instanceof King);
        Assertions.assertEquals(0,piece.getPositionX());
        Assertions.assertEquals(3,piece.getPositionY());
    }

    @Test
    public void setActivePieceTest()
    {
        Board board = new Board();
        Piece whiteQueen = board.getPiece(0,4);
        board.chessMovement(0,4);
        Assertions.assertEquals(whiteQueen,board.activePiece);
    }

    @Test
    public void movePieceTest()
    {
        Board board = new Board();
        Piece whiteRook = board.getPiece(0,0);
        board.chessMovement(0,0);
        board.chessMovement(2,0);
        Assertions.assertEquals(whiteRook,board.activePiece);
    }
}
