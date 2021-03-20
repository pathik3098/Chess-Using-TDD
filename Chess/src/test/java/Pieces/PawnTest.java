package Pieces;

import ChessBoard.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnTest {

    Board boardObject = new Board();

    // Valid move test when null
    @Test
    void ValidMoveTest() {
        Pawn pawnObject = new Pawn(1, 1, true, "xxx", boardObject);
        Assertions.assertThrows(NullPointerException.class, () -> {
            pawnObject.validMove(1, 2);
        });
    }
}
