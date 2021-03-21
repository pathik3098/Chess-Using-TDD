package Pieces;

import ChessBoard.Board;

public class Knight extends Piece {

    boolean valid = false;
    int[][] possibleMovePositions = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}};

    public Knight(int x, int y, boolean isWhite, String path, Board board) {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destination_x, int destination_y) {
        // if the destination position piece is of same colour then invalid move;
        Piece targetPiece = board.getPiece(destination_x, destination_y);
        boolean targetPieceColour = differentColourPiece(this, targetPiece);
        if (targetPieceColour) {

            int[][] possibleLegalMoves = new int[8][2];
            int targetPosition[][] = {{destination_x, destination_y}};
            int currentPosition[][] = {{this.getPositionX(), this.getPositionY()}};
            int possibleValue =0;
            int prevPossibleValue =0;
            for (int row = 0; row < possibleMovePositions.length; row++) {
                for (int col = 0; col < possibleMovePositions[row].length; col++) {
                    prevPossibleValue = possibleValue;
                    possibleValue = currentPosition[0][col] + possibleMovePositions[row][col];
                }
                if (prevPossibleValue >= 0 && prevPossibleValue < 8 && possibleValue >= 0 && possibleValue < 8) {
                    possibleLegalMoves[row][0] = prevPossibleValue;
                    possibleLegalMoves[row][1] = possibleValue;
                    System.out.print("\n" + possibleLegalMoves[row][0] + " " + possibleLegalMoves[row][1]);
                }
            }
            for (int row = 0; row < possibleMovePositions.length; row++) {
                if (targetPosition[0][0] == possibleLegalMoves[row][0] && targetPosition[0][1] == possibleLegalMoves[row][1]) {
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }
}
