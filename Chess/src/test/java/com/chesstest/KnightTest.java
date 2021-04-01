package com.chesstest;


import com.chessboard.Board;
import com.pieces.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightTest {

    @Test
    void ValidMoveTest() {
        Board board = new Board();
        Knight kp = new Knight(5,4,true,"path",board);
        Assertions.assertEquals(kp.ValidMove(3,3),true);
    }
    @Test
    void ValidMoveNegativeTest() {
        Board board = new Board();
        Knight kp = new Knight(5,4,true,"path",board);
        Assertions.assertNotEquals(kp.ValidMove(3,6),true);
    }
    @Test
    void ValidMoveExclusionsTest(){
        Board board = new Board();
        Knight kp = new Knight(3,0,true,"path",board);
        Assertions.assertEquals(kp.ValidMove(5,1),true);
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Board board = new Board();
        Knight kp = new Knight(3,0,true,"path",board);
        Assertions.assertNotEquals(kp.ValidMove(3,-1),true);
    }
}