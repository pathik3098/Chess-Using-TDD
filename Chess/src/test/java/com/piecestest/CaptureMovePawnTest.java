package com.piecestest;

import com.chessboard.*;
import com.pieces.CaptureMovePawn;
import com.pieces.Pawn;
import com.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CaptureMovePawnTest
{

    private boolean HasMoved;
    private int destinationLeftX;
    private int destinationLeftY;

    private int destinationRightX;
    private int destinationRightY;

    @Test
    void invalidCaptureLeftBlackPawnTest()
    {
        Board board = new Board();
        CaptureMovePawn captureMovePawnObj = new CaptureMovePawn();
        Piece targetPiecePosition = board.getPiece(5,0);
        Piece currentPiecePosition = board.getPiece(6,1);

        destinationLeftX = 5;
        destinationLeftY = 0;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationLeftX,destinationLeftY,board);
        Assertions.assertEquals(false,captureMovePawnObj.blackPawnAttack(currentPiecePosition));
    }

    @Test
    void invalidCaptureRightBlackPawnTest()
    {
        Board board = new Board();
        CaptureMovePawn captureMovePawnObj = new CaptureMovePawn();
        Piece targetPiecePosition = board.getPiece(5,2);
        Piece currentPiecePosition = board.getPiece(6,1);

        destinationRightX = 5;
        destinationRightY = 2;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationLeftX,destinationLeftY,board);
        Assertions.assertEquals(false,captureMovePawnObj.blackPawnAttack(currentPiecePosition));
    }
    @Test
    void invalidCaptureLeftWhitePawnTest()
    {
        Board board = new Board();
        CaptureMovePawn captureMovePawnObj = new CaptureMovePawn();
        Piece targetPiecePosition = board.getPiece(2,6);
        Piece currentPiecePosition = board.getPiece(1,5);

        destinationLeftX = 2;
        destinationLeftY = 6;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationLeftX,destinationLeftY,board);
        Assertions.assertEquals(false,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }

    @Test
    void invalidCaptureRightWhitePawnTest()
    {
        Board board = new Board();
        CaptureMovePawn captureMovePawnObj = new CaptureMovePawn();
        Piece targetPiecePosition = board.getPiece(2,4);
        Piece currentPiecePosition = board.getPiece(1,5);

        destinationRightX = 2;
        destinationRightY = 4;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationRightX,destinationRightY,board);
        Assertions.assertEquals(false,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }


    @Test
    void CaptureRightWhitePawnTest()
    {
        Board board = mock(Board.class);
        Piece piece = mock(Piece.class);

        Piece currentPiecePosition = board.getPiece(1,6);
        when(board.getPiece(2,5)).thenReturn(currentPiecePosition);

        CaptureMovePawn captureMovePawnObj = new CaptureMovePawn();
        //Piece attackPiecePosition = board.getPiece(2,5);

        destinationRightX = 2;
        destinationRightY = 5;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationRightX,destinationRightY,board);
        Assertions.assertEquals(true,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }
}
