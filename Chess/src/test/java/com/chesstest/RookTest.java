package com.chesstest;


import com.chessboard.Board;
import com.pieces.Piece;
import com.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookTest {

    @Test
    public void differentColourPieceTest(){
        Board board = new Board();
        Piece whiteRook = new Rook(0,0,true," ", board);
        int x=1;
        int y=0;
        board.chessMovement(0,0);
        board.chessMovement(x,y);
        Piece whiteTargetPiece = board.getPiece(x,y);
        Assertions.assertEquals(false,whiteRook.differentColourPiece(whiteRook,whiteTargetPiece));
    }

    @Test
    public void StraightMovementTest(){
        Board board = new Board();
        Rook whiteRook = new Rook(0,0,true,"", board);
        int targetX=5;
        int targetY=0;
        Assertions.assertEquals(true,whiteRook.straightMovement(whiteRook,targetX,targetY));
    }

    @Test
    public void isPieceInBetweenTest(){
        Board board = new Board();
        Rook whiteRook = new Rook(0,0,true,"", board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,whiteRook.isPieceInBetween(whiteRook,targetX,targetY));
    }

    @Test
    public void validMoveTest(){
        Board board = new Board();
        Rook whiteRook = new Rook(0,7,true,"",board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,whiteRook.ValidMove(targetX,targetY));
        targetX = 0;
        targetY = 1;
        Assertions.assertEquals(false,whiteRook.ValidMove(targetX,targetY));
        targetX = 3;
        targetY = 3;
        Assertions.assertEquals(false,whiteRook.ValidMove(targetX,targetY));
    }
}
