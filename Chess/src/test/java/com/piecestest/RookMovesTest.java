package com.piecestest;

import com.chessboard.Board;
import com.pieces.Piece;
import com.pieces.Rook;
import com.pieces.RookMoves;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookMovesTest {
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
        RookMoves rookMove = new RookMoves(0,0,true,"", board);
        int targetX=5;
        int targetY=0;
        Assertions.assertEquals(true,rookMove.straightMovement(whiteRook,targetX,targetY));
    }

    @Test
    public void isPieceInBetweenTest(){
        Board board = new Board();
        Rook whiteRook = new Rook(0,0,true,"", board);
        RookMoves rookMove = new RookMoves(0,0,true,"", board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,rookMove.isPieceInBetween(whiteRook,targetX,targetY));
    }

}
