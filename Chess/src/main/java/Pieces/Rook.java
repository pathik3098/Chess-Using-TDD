package Pieces;

import ChessBoard.Board;

public class Rook extends Piece{

    public Rook(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY)
    {
        Piece piece = board.getPiece(destinationX,destinationY);

        boolean a = differentColourPiece(this,piece);
        boolean b = straightMovement(this,destinationX,destinationY);
        boolean c = isPieceInBetween(this,destinationX,destinationY);

        if(a&&b&&c)
        {
            return true;
        }

        return false;

    }

    public boolean straightMovement(Piece currentPiece,int destinationX, int destinationY)
    {
        return (currentPiece.getPositionX() == destinationX) || (currentPiece.getPositionY() == destinationY);
    }

    public boolean isPieceInBetween(Piece currentPiece,int destinationX, int destinationY)
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
