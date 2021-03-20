package Pieces;

import ChessBoard.Board;

public class kingPiece extends Piece {
    boolean valid = false;
    int[][] possibleMovePositions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    public kingPiece(int x, int y, boolean isWhite, String path, Board board) {
        super(x, y, isWhite, path, board);
    }

    @Override
    public boolean ValidMove(int destination_x, int destination_y) {
        // if the destination position piece is of same colour then invalid move;
        Piece targetPiece = board.getPiece(destination_x, destination_y);
        boolean targetPieceColour = differentColourPiece(this, targetPiece);
        if (targetPieceColour) {
            int[][] possibleLegalMoves = new int[8][2];
            int[][] targetPosition = {{destination_x, destination_y}};
            int[][] currentPosition = {{this.getPositionX(), this.getPositionY()}};

            for (int row = 0; row < possibleMovePositions.length; row++) {
                for (int col = 0; col < possibleMovePositions[row].length; col++) {
                    possibleLegalMoves[row][col] = currentPosition[0][col] + possibleMovePositions[row][col];
                }
            }
            System.out.println("the length of possibleLegal moves is:" +possibleLegalMoves.length);
            System.out.println("the length of possibleLegal moves is:" +possibleLegalMoves[0].length);


            for (int row = 0; row < possibleLegalMoves.length; row++) {
                System.out.print("\n");
                if (possibleLegalMoves[row][0]>0 && possibleLegalMoves[row][0]<8){
                    if(possibleLegalMoves[row][1]>0 && possibleLegalMoves[row][1]<8){
                        System.out.print(possibleLegalMoves[row][0] + " " + possibleLegalMoves[row][1]);
                    }
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
