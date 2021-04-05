package com.piecestest;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.King;
import com.pieces.Knight;
import com.pieces.KnightKingMoves;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightMovesTest {
    int[][] possibleKnightMovePositions = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}};
    int[][] possibleKingMovePositions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    @Test
    public void knightValidMovementTest() {
        IBoard board = new Board();
        Knight knight = new Knight(5, 4, true, "", board);
        KnightKingMoves knightMoves = new KnightKingMoves(5, 4, true, "", board);
        Assertions.assertEquals(true, knightMoves.validMovement(knight, 3, 3,possibleKnightMovePositions));
    }
    @Test
    public void knightValidMovementNegativeTest() {
        IBoard board = new Board();
        Knight knight = new Knight(5, 4, true, "", board);
        KnightKingMoves knightMoves = new KnightKingMoves(5, 4, true, "", board);
        Assertions.assertEquals(false, knightMoves.validMovement(knight, 3, 4,possibleKnightMovePositions));
    }
    @Test
    void knightValidMovementExclusionsTest(){
        IBoard board = new Board();
        Knight knight = new Knight(3,0,true,"path",board);
        KnightKingMoves knightMoves = new KnightKingMoves(3, 0, true, "", board);
        Assertions.assertEquals(true,knightMoves.validMovement(knight,5,1,possibleKnightMovePositions));
    }
    @Test
    void knightValidMovementExclusionsNegativeTest(){
        IBoard board = new Board();
        Knight knight = new Knight(3,0,true,"path",board);
        KnightKingMoves knightMoves = new KnightKingMoves(3,0,true,"path",board);
        Assertions.assertNotEquals(true,knightMoves.validMovement(knight,3,-1,possibleKnightMovePositions));
    }
    @Test
    public void kingValidMovementTest() {
        IBoard board = new Board();
        King king = new King(5, 4, true, "", board);
        KnightKingMoves kingMoves = new KnightKingMoves(5, 4, true, "", board);
        Assertions.assertEquals(true, kingMoves.validMovement(king, 4, 3,possibleKingMovePositions));
    }
    @Test
    public void kingValidMovementNegativeTest() {
        IBoard board = new Board();
        King king = new King(5, 4, true, "", board);
        KnightKingMoves kingMoves = new KnightKingMoves(5, 4, true, "", board);
        Assertions.assertEquals(false, kingMoves.validMovement(king, 3, 6,possibleKingMovePositions));
    }
    @Test
    void kingValidMovementExclusionsTest(){
        IBoard board = new Board();
        King king = new King(3,0,true,"path",board);
        KnightKingMoves kingMoves = new KnightKingMoves(3, 0, true, "", board);
        Assertions.assertEquals(true,kingMoves.validMovement(king,3,1,possibleKingMovePositions));
    }
    @Test
    void kingValidMovementExclusionsNegativeTest(){
        IBoard board = new Board();
        King king = new King(3,0,true,"path",board);
        KnightKingMoves kingMoves = new KnightKingMoves(3,0,true,"path",board);
        Assertions.assertNotEquals(true,kingMoves.validMovement(king,3,-1,possibleKingMovePositions));
    }

}
