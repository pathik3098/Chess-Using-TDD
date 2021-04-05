package com.piecestest;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.CaptureMovePawn;
import com.pieces.Pawn;
import com.pieces.Piece;
import com.pieces.interfaces.ICaptureMovePawn;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaptureMovePawnTest
{

    private boolean HasMoved;
    private int destinationLeftX;
    private int destinationLeftY;

    private int destinationRightX;
    private int destinationRightY;

    IBoard board = new Board();
    ICaptureMovePawn captureMovePawnObj = new CaptureMovePawn();

    @Test
    void invalidCaptureLeftBlackPawnTest()
    {
        Piece currentPiecePosition = board.getPiece(6,1);

        destinationLeftX = 5;
        destinationLeftY = 0;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationLeftX,destinationLeftY, board);
        Assertions.assertEquals(false,captureMovePawnObj.blackPawnAttack(currentPiecePosition));
    }

    @Test
    void invalidCaptureRightBlackPawnTest()
    {
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
        Piece currentPiecePosition = board.getPiece(1,5);

        destinationLeftX = 2;
        destinationLeftY = 6;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationLeftX,destinationLeftY,board);
        Assertions.assertEquals(false,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }

    @Test
    void invalidCaptureRightWhitePawnTest()
    {
        Piece currentPiecePosition = board.getPiece(1,5);

        destinationRightX = 2;
        destinationRightY = 4;

        captureMovePawnObj.initialiseValues(currentPiecePosition,destinationRightX,destinationRightY,board);
        Assertions.assertEquals(false,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }

    @Test
    void blackPawnAttackTest()
    {
        Piece whitePiece = board.getPiece(1,0);
        board.getWhitePieces().remove(whitePiece);
        board.getWhitePieces().add(new Pawn(5,0,true,"",board));

        Piece currentPiecePosition = board.getPiece(6,1);

        captureMovePawnObj.initialiseValues(currentPiecePosition,5,0,board);
        Assertions.assertEquals(true,captureMovePawnObj.blackPawnAttack(currentPiecePosition));
    }

    @Test
    void whitePawnAttackTest()
    {
        Piece blackPiece = board.getPiece(6,7);
        board.getBlackPieces().remove(blackPiece);
        board.getBlackPieces().add(new Pawn(2,7,false,"",board));

        Piece currentPiecePosition = board.getPiece(1,6);

        captureMovePawnObj.initialiseValues(currentPiecePosition,2,7,board);
        Assertions.assertEquals(true,captureMovePawnObj.whitePawnAttack(currentPiecePosition));
    }

    @Test
    void cornerBlackPawnAttackTest1()
    {
        Piece whitePiece = board.getPiece(1,1);
        board.getWhitePieces().remove(whitePiece);
        board.getWhitePieces().add(new Pawn(5,1,true,"",board));

        Piece currentPiecePosition = board.getPiece(6,0);

        captureMovePawnObj.initialiseValues(currentPiecePosition,5,1,board);
        Assertions.assertEquals(true,captureMovePawnObj.cornerBlackPawnAttack(currentPiecePosition));
    }

    @Test
    void cornerWhitePawnAttackTest1()
    {
        Piece blackPiece = board.getPiece(6,6);
        board.getBlackPieces().remove(blackPiece);
        board.getBlackPieces().add(new Pawn(2,6,false,"",board));

        Piece currentPiecePosition = board.getPiece(1,7);

        captureMovePawnObj.initialiseValues(currentPiecePosition,2,6,board);
        Assertions.assertEquals(true,captureMovePawnObj.cornerWhitePawnAttack(currentPiecePosition));
    }

    @Test
    void cornerWhitePawnAttackTest2()
    {
        Piece blackPiece = board.getPiece(6,1);
        board.getBlackPieces().remove(blackPiece);
        board.getBlackPieces().add(new Pawn(2,1,false,"",board));

        Piece currentPiecePosition = board.getPiece(1,0);

        captureMovePawnObj.initialiseValues(currentPiecePosition,2,1,board);
        Assertions.assertEquals(true,captureMovePawnObj.cornerWhitePawnAttack(currentPiecePosition));
    }

    @After
    public void destroy()
    {
        board = null;
        captureMovePawnObj = null;
    }

}