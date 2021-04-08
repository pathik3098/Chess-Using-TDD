package com.piecestest;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.King;
import com.pieces.Piece;
import com.pieces.Rook;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KingTest {

    IBoard board = new Board();

    @Test
    void ValidMoveTest() {
        King king = new King(5,4,true,"path",board);
        Assertions.assertEquals(true,king.validMove(4,3));
    }
    @Test
    void ValidMoveNegativeTest() {
        King king = new King(5,4,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,6));
    }
    @Test
    void ValidMoveExclusionsTest(){
        King king = new King(3,0,true,"path",board);
        Assertions.assertEquals(true,king.validMove(3,1));
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        King king = new King(3,0,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,-1));
    }
    @After
    void destroy()
    {
        board=null;
    }
}