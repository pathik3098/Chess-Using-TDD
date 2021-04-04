package com.piecestest;

import com.chessboard.Board;
import com.pieces.Pawn;
import com.pieces.Piece;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
POSITIVE CASES:
TestCase 1: validFirstMoveOneStepBlackPawnTest - Checks whether the black pawn can move ONE step forward for FIRST time.
TestCase 2: validFirstMoveTwoStepBlackPawnTest - Checks whether the black pawn can move TWO step forward for FIRST time.
TestCase 3: validMoveOneStepBlackPawnTest - Checks whether the black pawn can move ONE step forward when pieces not present on its way.

TestCase 4: validFirstMoveOneStepWhitePawnTest - Checks whether the white pawn can move ONE step forward for FIRST time.
TestCase 5: validFirstMoveTwoStepWhitePawnTest - Checks whether the white pawn can move TWO step forward for FIRST time.
TestCase 6: validMoveOneStepWhitePawnTest - Checks whether the white pawn can move ONE step forward when pieces not present on its way.

NEGATIVE CASES:
TestCase 7: invalidTwoStepMoveWhitePawnTest - Restricts the White Pawn to take TWO Forward Steps when its first move chance is over.
TestCase 8: invalidTwoStepMoveBlackPawnTest - Restricts the White Pawn to take TWO Forward Steps when its first move chance is over.
TestCase 9: invalidRandomPawnMovement - Restricts the Pawn from moving in random direction.
 */

public class PawnTest {

    Board board = new Board();
    private boolean HasMoved;

    @Test //TestCase 1
    void validFirstMoveOneStepBlackPawnTest()
    {
        Pawn blackActivePawn= new Pawn(6,1,false,"", board);

        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 2
    void validFirstMoveTwoStepBlackPawnTest()
    {
        Pawn blackActivePawn = new Pawn(6,1,false,"", board);

        int targetX=4;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 3
    void validMoveOneStepBlackPawnTest()
    {
        Piece activePiece = new Pawn(4,1,false,"", board);
        Pawn blackActivePawn=(Pawn)activePiece;

        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();

        int targetX=3;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }


    @Test //TestCase 4
    void validFirstMoveOneStepWhitePawnTest()
    {
        Pawn whiteActivePawn= new Pawn(1,5,true,"", board);

        int targetX=2;
        int targetY=5;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 5
    void validFirstMoveTwoStepWhitePawnTest()
    {
        Pawn whiteActivePawn = new Pawn(1,0,true,"", board);

        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 6
    void validMoveOneStepWhitePawnTest()
    {
        Pawn whiteActivePawn = new Pawn(4,1,true,"", board);

        boolean setHasMoved = true;
        whiteActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = whiteActivePawn.getIsFirstMove();

        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 7
    void invalidTwoStepMoveWhitePawnTest()
    {
        Pawn whiteActivePawn= new Pawn(3,1,true,"", board);

        boolean setHasMoved = true;
        whiteActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = whiteActivePawn.getIsFirstMove();

        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(false,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 8
    void invalidTwoStepMoveBlackPawnTest()
    {
        Pawn blackActivePawn = new Pawn(5,2,false,"", board);

        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();

        int targetX=3;
        int targetY=2;
        Assertions.assertEquals(false,blackActivePawn.validMove(targetX,targetY));
    }

    @Test //TestCase 9
    void invalidRandomPawnMovement()
    {
        Pawn blackActivePawn = new Pawn(5,2,false,"", board);

        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();

        int targetX=3;
        int targetY=7;
        Assertions.assertEquals(false,blackActivePawn.validMove(targetX,targetY));
    }

    @After
    public void destroy()
    {
        board = null;
    }
}
