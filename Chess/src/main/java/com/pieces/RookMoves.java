package com.pieces;

import com.chessboard.Board;
import com.chessboard.IBoard;
import com.pieces.interfaces.IRookMoves;

public class RookMoves implements IRookMoves {

    private int initialX;
    private int initialY;
    private boolean isWhite;
    private String filePath;
    public IBoard board;

    public RookMoves(int initialX, int initialY, boolean isWhite, String filePath, IBoard board) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isWhite = isWhite;
        this.filePath = filePath;
        this.board = board;
    }

    @Override
    public boolean straightMovement(Piece currentPiece, int destinationX, int destinationY)
    {
        return (currentPiece.getPositionX() == destinationX) || (currentPiece.getPositionY() == destinationY);
    }

    @Override
    public boolean checkPieceInBetween(Piece currentPiece, int destinationX, int destinationY)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = destinationX;
        int targetY = destinationY;

        int directionSignX = Integer.signum(targetX - currentX);
        int directionSignY = Integer.signum(targetY - currentY);

        if (directionSignX > 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX + i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX - i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY > 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY + i);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY < 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY - i);

                if (p != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
