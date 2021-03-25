package Pieces;

import ChessBoard.Board;

public class CaptureMovePawn implements ICaptureMovePawn
{

    private int attackdiagonalXLeft;
    private int attackdiagonalYLeft;
    private int attackdiagonalXRight;
    private int attackdiagonalYRight;

    private int targetX;
    private int targetY;

    boolean attackLeft = false;
    boolean attackRight = false;

    Board boardobj; //Board Class

    public void initialiseValues(Piece currentPiece,Piece targetPiece, Board boardobj)
    {
        targetX = targetPiece.getPositionX();
        targetY = targetPiece.getPositionY();
    }

    public boolean checkAttack(int attackX, int attackY)
    {
        boolean attack = false;
        Piece attackPieceIsPresent = boardobj.getPiece(attackX, attackY);
        if (attackPieceIsPresent != null && attackX == targetX && attackY == targetY)
        {
            attack = true;
            return attack;
        }
        return attack;
    }

    public boolean cornerWhitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        boolean pawnCanAttack = false;

        if(currentY <= 7) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX == 0) {
                attackdiagonalXRight = currentX + 1; //Valid position to be attacked
                attackdiagonalYRight = currentY + 1;
                attackRight = checkAttack(attackdiagonalXRight,attackdiagonalYRight);
                return attackRight;
            }

            if (currentX == 7) {
                attackdiagonalXLeft = currentX - 1; //Valid position to be attacked
                attackdiagonalYLeft = currentY + 1;
                attackLeft = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);
                return attackLeft;
            }
        }
        return pawnCanAttack;
    }

    public boolean whitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        boolean pawnCanAttack = false;

        if(currentY <= 7) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX > 0 && currentX < 7)
            {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY + 1;
                attackLeft = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);


                attackdiagonalXRight = currentX + 1;
                attackdiagonalYRight = currentY + 1;
                attackRight = checkAttack(attackdiagonalXRight,attackdiagonalYRight);

                if ( attackLeft || attackRight)
                {
                    pawnCanAttack = true;
                    return pawnCanAttack;
                }
            }

        }
        return pawnCanAttack;
    }

    public boolean cornerBlackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        boolean pawnCanAttack = false;

        if(currentY >=0 ) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX == 0) {
                attackdiagonalXLeft = currentX + 1;
                attackdiagonalYLeft = currentY - 1;
                attackLeft = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);
                return attackLeft;
            }

            if (currentX == 7) {
                attackdiagonalXRight = currentX - 1;
                attackdiagonalYRight = currentY - 1;
                attackRight = checkAttack(attackdiagonalXRight,attackdiagonalYRight);
                return attackRight;
            }
        }
        return pawnCanAttack;
    }


    public boolean blackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        boolean pawnCanAttack = false;

        if(currentY >= 0) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX > 0 && currentX < 7)
            {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY - 1;
                attackLeft = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);


                attackdiagonalXRight = currentX + 1;
                attackdiagonalYRight = currentY - 1;
                attackRight = checkAttack(attackdiagonalXRight,attackdiagonalYRight);

                if ( attackLeft || attackRight)
                {
                    pawnCanAttack = true;
                    return pawnCanAttack;
                }
            }

        }
        return pawnCanAttack;
    }
}
