package com.chesstest.piecestest;

import com.chesstest.chessboard.Board;
import com.chesstest.chessboard.IBoard;
import com.chesstest.pieces.Piece;
import com.chesstest.pieces.Rook;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookTest {

    IBoard board = new Board();

    @Test
    public void differentColourPieceTest()
    {
        Piece whiteRook = new Rook(0,0,true," ", board);
        Piece whitePawn = board.getPiece(1,0);
        Assertions.assertEquals(false,whiteRook.differentColourPiece(whiteRook,whitePawn));
        Piece blackPawn = board.getPiece(6,0);
        Assertions.assertEquals(true,whiteRook.differentColourPiece(whiteRook,blackPawn));
    }

    @Test
    public void validMoveTest()
    {
        Piece whiteRook = new Rook(0,0,true,"",board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,whiteRook.validMove(targetX,targetY));
    }

    @After
    public void destroy()
    {
        board = null;
    }
}
