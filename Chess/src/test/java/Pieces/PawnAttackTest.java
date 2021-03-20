package Pieces;

import ChessBoard.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TestCases: TestCase 1 and TestCase 2
// TestCase1 : checks the call for cornerWhitePawnAttack and whitePawnAttack
// TestCase2 : checks the call for cornerBlackPawnAttack and blackPawnAttack


public class PawnAttackTest
{
    Board boardObject = new Board();
    @Test
    void pawnAttackTestCase1()
    {
        CaptureMovePawn obj = new CaptureMovePawn(0, 1, true, "xxx", boardObject);

        Piece currentPiece = boardObject.getPiece(1,2);
        Assertions.assertThrows(NullPointerException.class, () -> {
            obj.cornerWhitePawnAttack(currentPiece);
        });

        Piece currentPiece1 = boardObject.getPiece(3,2);
        Assertions.assertThrows(NullPointerException.class, () -> {
            obj.whitePawnAttack(currentPiece1);
        });
    }

    @Test
    void pawnAttackTestCase2()
    {
        CaptureMovePawn obj = new CaptureMovePawn(7, 6, false, "xxx", boardObject);

        Piece currentPiece = boardObject.getPiece(6,5);
        Assertions.assertThrows(NullPointerException.class, () -> {
            obj.cornerBlackPawnAttack(currentPiece);
        });

        Piece currentPiece1 = boardObject.getPiece(4,5);
        Assertions.assertThrows(NullPointerException.class, () -> {
            obj.blackPawnAttack(currentPiece1);
        });
    }
}
