package com.piecestest;

import com.chessboard.Board;
import com.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnTest {

    Board boardObject = new Board();

    @Test
    void canMoveBlackTest() //
    {
        boolean hasMoved = true;

        Pawn blackPawn = new Pawn(6,1,true,"", boardObject);
        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(false,blackPawn.canMoveBlack(blackPawn,targetX,targetY));
    }
}
