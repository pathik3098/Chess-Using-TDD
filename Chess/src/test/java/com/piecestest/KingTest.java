package com.piecestest;


import com.chessboard.Board;
import com.pieces.King;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KingTest {

    @Test
    void ValidMoveTest() {
        Board board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertEquals(true,king.validMove(4,3));
    }
    @Test
    void ValidMoveNegativeTest() {
        Board board = new Board();
        King king = new King(5,4,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,6));
    }
    @Test
    void ValidMoveExclusionsTest(){
        Board board = new Board();
        King king = new King(3,0,true,"path",board);
        Assertions.assertEquals(true,king.validMove(3,1));
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Board board = new Board();
        King king = new King(3,0,true,"path",board);
        Assertions.assertNotEquals(true,king.validMove(3,-1));
    }
}