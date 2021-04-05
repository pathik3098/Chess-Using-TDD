package com.piecestest;


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
        board.chessMovement(0,0);
        board.chessMovement(1,0);
        Piece whiteTargetPiece = board.getPiece(1,0);
        Assertions.assertEquals(false,whiteRook.differentColourPiece(whiteRook,whiteTargetPiece));
    }

    @Test
    public void validMoveTest(){
        Board board = new Board();
        Piece whiteRook = new Rook(0,0,true,"",board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
        targetX = 0;
        targetY = 1;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
        targetX = 3;
        targetY = 3;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
//        board.chessMovement(0,1);
//        board.chessMovement(2,2);
//        board.chessMovement(7,1);
//        board.chessMovement(5,2);
//        board.chessMovement(2,2);
//        board.chessMovement(4,3);
//        Piece p = board.getPiece(4,3);
//        System.out.println(p);
        board.chessMovement(0,0);
        board.chessMovement(2,0);
        Assertions.assertEquals(false,whiteRook.validMove(2,0));


    }
}
