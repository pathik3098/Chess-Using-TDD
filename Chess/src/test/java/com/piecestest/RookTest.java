package com.piecestest;


import com.chessboard.Board;
import com.pieces.Piece;
import com.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookTest {

    @Test
    public void validMoveTest(){
        Board board = new Board();
        Rook whiteRook = new Rook(0,7,true,"",board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
        targetX = 0;
        targetY = 1;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
        targetX = 3;
        targetY = 3;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
    }
}
