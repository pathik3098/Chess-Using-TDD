package com.pieces;

import com.chessboard.IBoard;
import com.pieces.interfaces.IKnightKingMoves;

public class KnightKingMoves implements IKnightKingMoves
{
    private int initialX;
    private int initialY;
    private boolean isWhite;
    private String filePath;
    public IBoard board;

    public KnightKingMoves(int initialX, int initialY, boolean isWhite, String filePath, IBoard board)
    {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isWhite = isWhite;
        this.filePath = filePath;
        this.board = board;
    }

    @Override
    public boolean validMovement(Piece currentPiece, int destinationX, int destinationY, int[][] possibleMovePositions)
    {
            int[][] possibleLegalMoves = new int[8][2];
            int currentX = currentPiece.getPositionX();
            int currentY = currentPiece.getPositionY();
            int targetPosition[][] = {{destinationX, destinationY}};
            int currentPosition[][] = {{currentX,currentY}};
            int possiblePosition =0;
            int prevPossiblePosition =0;

            for (int row = 0; row < possibleMovePositions.length; row++)
            {
                for (int col = 0; col < possibleMovePositions[row].length; col++)
                {
                    prevPossiblePosition = possiblePosition;
                    possiblePosition = currentPosition[0][col] + possibleMovePositions[row][col];
                }

                if (prevPossiblePosition >= 0 && prevPossiblePosition < 8 && possiblePosition >= 0 && possiblePosition < 8)
                {
                    possibleLegalMoves[row][0] = prevPossiblePosition;
                    possibleLegalMoves[row][1] = possiblePosition;
                }
            }
            for (int row = 0; row < possibleMovePositions.length; row++)
            {
                if (targetPosition[0][0] == possibleLegalMoves[row][0] && targetPosition[0][1] == possibleLegalMoves[row][1])
                {
                    return true;
                }
            }
            return false;
        }
    }

