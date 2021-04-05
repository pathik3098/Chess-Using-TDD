package com.piecestest;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.King;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KingTest {

    @Test
    void ValidMoveTest() {
        IBoard board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertEquals(true,king.validMove(4,3));
    }
    @Test
    void ValidMoveNegativeTest() {
        IBoard board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,6));
    }
    @Test
    void ValidMoveExclusionsTest(){
        IBoard board = new Board();
        King king = new King(3,0,true,"path",board);
        Assertions.assertEquals(true,king.validMove(3,1));
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        IBoard board = new Board();
        King king = new King(3,0,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,-1));
    }
}