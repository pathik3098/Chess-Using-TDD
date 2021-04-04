package com.piecestest;

import com.chessboard.Board;
import com.pieces.IEnPassantPawn;
import com.pieces.EnPassantPawn;
import com.pieces.Pawn;
import com.pieces.Piece;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnPassantPawnTest
{
    Board board = new Board();
    IEnPassantPawn enPassantPawnObj = new EnPassantPawn();

    private int previousMovedBlackX;
    private int previousMovedBlackY;
    Piece currentPiece;

    @Test
    void checkEnPassantCapturingWhiteTest()
    {
        Piece blackPiece = board.getPiece(6,3);
        board.getBlackPieces().remove(blackPiece);
        board.getBlackPieces().add(new Pawn(4,3,false,"",board));

        Piece whitePiece = board.getPiece(1,2);
        board.getWhitePieces().remove(whitePiece);
        board.getWhitePieces().add(new Pawn(4,2,true,"",board));

        Piece enpassantBlackPiece = board.getPiece(4,3);
        Piece currentPiecePosition = board.getPiece(4,2);

        previousMovedBlackX = 4;
        previousMovedBlackY = 3;

        Assertions.assertEquals(true,enPassantPawnObj.checkEnPassantCapturingWhite(currentPiecePosition,previousMovedBlackX,previousMovedBlackY));
    }

    @Test
    void checkEnPassantCapturingBlackTest()
    {
        Piece blackPiece = board.getPiece(6,5);
        board.getBlackPieces().remove(blackPiece);
        board.getBlackPieces().add(new Pawn(3,5,false,"",board));

        Piece whitePiece = board.getPiece(1,4);
        board.getWhitePieces().remove(whitePiece);
        board.getWhitePieces().add(new Pawn(3,4,true,"",board));

        Piece enpassantWhitePiece = board.getPiece(3,4);
        Piece currentPiecePosition = board.getPiece(3,5);

        previousMovedBlackX = 3;
        previousMovedBlackY = 4;

        Assertions.assertEquals(true,enPassantPawnObj.checkEnPassantCapturingBlack(currentPiecePosition,previousMovedBlackX,previousMovedBlackY));
    }
    @After
    public void destroy()
    {
        enPassantPawnObj = null;
    }
}
