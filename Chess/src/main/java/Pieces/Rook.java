package Pieces;

import ChessBoard.Board;

public class Rook extends Piece implements IRook {

    public Rook(int x, int y, boolean isWhite, String path, Board board) {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destination_x, int destination_y) {

        Piece piece = board.getPiece(destination_x, destination_y);

        if (checkValidMoveConditions(differentColourPiece(this, piece))) return false;
        if (checkValidMoveConditions(straightMovement(this, piece))) return false;
        if (checkValidMoveConditions(isPieceInBetween(this, piece))) return false;

        return true;
    }

    @Override
    public boolean straightMovement(Piece currentPiece, Piece targetPiece) {
        return (currentPiece.getPositionX() == targetPiece.getPositionX()) || (currentPiece.getPositionY() == targetPiece.getPositionY());
    }

    @Override
    public boolean isPieceInBetween(Piece currentPiece, Piece targetPiece) {

        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = targetPiece.getPositionX();
        int targetY = targetPiece.getPositionY();

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
