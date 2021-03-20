package Pieces;

public interface IRook {
    boolean ValidMove(int destination_x, int destination_y);

    default boolean checkValidMoveConditions(boolean condition) {
        if (!condition) {
            return true;
        }
        return false;
    }

    boolean straightMovement(Piece currentPiece, Piece targetPiece);

    boolean isPieceInBetween(Piece currentPiece, Piece targetPiece);
}
