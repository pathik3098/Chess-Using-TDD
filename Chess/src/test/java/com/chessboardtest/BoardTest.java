package com.chessboardtest;


import com.chessboard.Board;
import com.pieces.King;
import com.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void getPieceTest() {
        Board board = new Board();
        Piece piece = board.getPiece(0,3);
        Assertions.assertTrue(piece instanceof King);
        Assertions.assertEquals(0,piece.getPositionX());
        Assertions.assertEquals(3,piece.getPositionY());
    }

    @Test
    public void setActivePieceTest()
    {
        Board board = new Board();
        Piece whiteQueen = board.getPiece(0,4);
        board.chessMovement(0,4);
        Assertions.assertEquals(whiteQueen,board.activePiece);
    }

    @Test
    public void movePieceTest()
    {
        Board board = new Board();
        Piece whiteRook = board.getPiece(0,0);
        board.chessMovement(0,0);
        board.chessMovement(2,0);
        Assertions.assertEquals(whiteRook,board.activePiece);
    }

    @Test
    public void movePieceKnightTest()
    {
        Board board = new Board();
        Piece knight = board.getPiece(0,1);
        board.chessMovement(0,1);
        board.chessMovement(2,2);
        Assertions.assertEquals(null,board.activePiece);
    }

    @Test
    public void inCheckTest()
    {
        Board board = new Board();
        Assertions.assertEquals(false,board.inCheck());
    }
}
