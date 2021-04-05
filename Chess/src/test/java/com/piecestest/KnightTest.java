package com.piecestest;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightTest {

    @Test
    void ValidMoveTest() {
        IBoard board = new Board();
        Knight knight = new Knight(5,4,true,"path",board);
        Assertions.assertEquals(true,knight.validMove(3,3));
    }
    @Test
    void ValidMoveNegativeTest() {
        IBoard board = new Board();
        Knight knight = new Knight(5,4,true,"path",board);
        Assertions.assertNotEquals(true,knight.validMove(3,6));
    }
    @Test
    void ValidMoveExclusionsTest(){
        IBoard board = new Board();
        Knight knight = new Knight(3,0,true,"path",board);
        Assertions.assertEquals(true,knight.validMove(5,1));
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        IBoard board = new Board();
        Knight knight = new Knight(3,0,true,"path",board);
        Assertions.assertNotEquals(true,knight.validMove(3,-1));
    }
}