package com.chessboardtest;


import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.King;
import com.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void getPieceTest()
    {
        IBoard board = new Board();
        Piece piece = board.getPiece(0,3);
        Assertions.assertTrue(piece instanceof King);
        Assertions.assertEquals(0,piece.getPositionX());
        Assertions.assertEquals(3,piece.getPositionY());
    }

    @Test
    public void setActivePieceTest()
    {
        IBoard board = new Board();
        Piece whiteQueen = board.getPiece(0,4);
        board.chessMovement(0,4);
        Assertions.assertEquals(whiteQueen,board.getActivePiece());
    }

    @Test
    public void movePieceTest()
    {
        IBoard board = new Board();
        Piece whiteRook = board.getPiece(0,0);
        board.chessMovement(0,0);
        board.chessMovement(2,0);
        Assertions.assertEquals(whiteRook,board.getActivePiece());
    }

    @Test
    public void movePieceKnightTest()
    {
        IBoard board = new Board();
        Piece knight = board.getPiece(0,1);
        board.chessMovement(0,1);
        board.chessMovement(2,2);
        Assertions.assertEquals(null,board.getActivePiece());
    }

    @Test
    public void inCheckTest()
    {
        Board board = new Board();
        Assertions.assertEquals(false,board.inCheck());
    }
}
