package Pieces;

import ChessBoard.Board;

public class Pawn extends Piece implements IPawn
{
    private boolean hasMoved;
    boolean canPawnMove = false;
    boolean canPawnAttack = false;
    boolean canCornerPawnAttack = false;
    boolean isDiffColourPawn = false;
    boolean isForwardMove = false;

    public Pawn(int x, int y, boolean isWhite, String path, Board board)
    {
        super(x,y,isWhite,path,board);
        hasMoved = false;
    }


    public void setIsFirstMove(boolean has_moved)
    {
        this.hasMoved = has_moved;
    }

    public boolean getIsFirstMove()
    {
        return hasMoved;
    }

    @Override
    public boolean ValidMove(int destinationX, int destinationY)
    {
        Piece targetPiece = board.getPiece(destinationX,destinationY);

        isDiffColourPawn = differentColourPiece(this,targetPiece);
        isForwardMove  = (targetPiece == null && this.getPositionX() == targetPiece.getPositionX()) ? true : false;

        if (isDiffColourPawn)
        {
            CaptureMovePawn captureObj = new CaptureMovePawn();
            captureObj.initialiseValues(this, targetPiece, board);

            if (this.isWhite()) //When CurrentPiece is WhitePawn
            {
                canPawnMove = canMoveWhite(this, targetPiece);
                canCornerPawnAttack = captureObj.cornerWhitePawnAttack(this);
                canPawnAttack = captureObj.whitePawnAttack(this);
            }
            else               //When CurrentPiece is BlackPawn
            {
                canPawnMove = canMoveBlack(this, targetPiece);
                canCornerPawnAttack = captureObj.cornerBlackPawnAttack(this);
                canPawnAttack = captureObj.blackPawnAttack(this);
            }

            if (canPawnMove || canCornerPawnAttack || canPawnAttack) {
                return true;
            }
        }
        return false;
    }


    public boolean canMoveWhite(Piece currentPiece, Piece targetPiece)
    {
        boolean canMoveOneStepForward = (currentPiece.getPositionY()+1 == targetPiece.getPositionY()) ? true : false;
        boolean canMoveTwoStepForward = (currentPiece.getPositionY()+2 ==targetPiece.getPositionY()) ? true : false;
        if(getIsFirstMove())
        {
            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                return true;
            }
        }
        else
        {
            if(isForwardMove && canMoveOneStepForward)
            {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveBlack(Piece currentPiece, Piece targetPiece)
    {
        boolean canMoveOneStepForward = (currentPiece.getPositionY()-1 == targetPiece.getPositionY()) ? true : false;
        boolean canMoveTwoStepForward = (currentPiece.getPositionY()-2 ==targetPiece.getPositionY()) ? true : false;
        if(getIsFirstMove())
        {
            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                return true;
            }
        }
        else
        {
            if(isForwardMove && canMoveOneStepForward)
            {
                return true;
            }
        }
        return false;
    }

}
