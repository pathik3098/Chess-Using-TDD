package Pieces;

import ChessBoard.Board;

public class CaptureMovePawn extends Pawn
{
    private boolean hasMoved;

    private int attackdiagonalXLeft;
    private int attackdiagonalYLeft;
    private int attackdiagonalXRight;
    private int attackdiagonalYRight;

    public CaptureMovePawn(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x,y,isWhite,path,board);
    }

    public boolean getIsFirstMove()
    {
        return hasMoved;
    }

    public void pawnAttack(int curX, int curY)
    {
        Piece currentPiece = board.getPiece(curX,curY);
        if(isWhite())
        {
            cornerWhitePawnAttack(this);
            whitePawnAttack(this);
        }
        else
        {
            cornerBlackPawnAttack(this);
            blackPawnAttack(this);
        }
    }

    public boolean cornerWhitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        if(currentY <= 7) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX == 0) {
                attackdiagonalXLeft = currentX + 1;
                attackdiagonalYLeft = currentY + 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalYLeft);
                if (p != null) {
                    System.out.println("Attack Here!.........." + attackdiagonalXLeft + attackdiagonalYLeft);
                    return true;
                }
            }

            if (currentX == 7) {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY + 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalXLeft);
                if (p != null) {
                    System.out.println("Attack Here!.........." + attackdiagonalXLeft + attackdiagonalYLeft);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean whitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        if(currentY <= 7) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX > 0 && currentX < 7)
            {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY + 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalYLeft);


                attackdiagonalXRight = currentX + 1;
                attackdiagonalYRight = currentY + 1;
                Piece p1 = board.getPiece(attackdiagonalXRight, attackdiagonalYRight);

                if ( (p!=null) || (p1!=null))
                {
                    System.out.println("Attack Here!..........");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean cornerBlackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        if(currentY >=0 ) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX == 0) {
                attackdiagonalXLeft = currentX + 1;
                attackdiagonalYLeft = currentY - 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalYLeft);
                if (p != null) {
                    System.out.println("Attack Here!.........." + attackdiagonalXLeft + attackdiagonalYLeft);
                    return true;
                }
            }

            if (currentX == 7) {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY - 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalXLeft);
                if (p != null) {
                    System.out.println("Attack Here!.........." + attackdiagonalXLeft + attackdiagonalYLeft);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean blackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        if(currentY >= 0) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentX > 0 && currentX < 7)
            {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY - 1;
                Piece p = board.getPiece(attackdiagonalXLeft, attackdiagonalYLeft);


                attackdiagonalXRight = currentX + 1;
                attackdiagonalYRight = currentY - 1;
                Piece p1 = board.getPiece(attackdiagonalXRight, attackdiagonalYRight);

                if ( (p!=null) || (p1!=null))
                {
                    System.out.println("Attack Here!..........");
                    return true;
                }
            }

        }
        return false;
    }
}
