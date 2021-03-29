package com.pieces;

import com.chessboard.Board;

public class Pawn extends Piece implements IPawn
{
    private boolean hasMoved;
    boolean canPawnMove = false;
    boolean canPawnAttack = false;
    boolean canCornerPawnAttack = false;
    boolean isDiffColourPawn = false;
    boolean isForwardMove = false;
    boolean enPassantAttack = false;

    boolean enPassantBlackPawn = false;
    int enPassantBlackX = 0;
    int enPassantBlackY = 0;

    boolean enPassantWhitePawn = false;
    int enPassantWhiteX = 0;
    int enPassantWhiteY = 0;

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
        isForwardMove  = (targetPiece == null && this.getPositionY() == targetPiece.getPositionY()) ? true : false;

        if (isDiffColourPawn)
        {
            CaptureMovePawn captureObj = new CaptureMovePawn();
            captureObj.initialiseValues(this, targetPiece, board);

            EnPassantPawn enPassantObj = new EnPassantPawn();

            if (this.isWhite()) //When CurrentPiece is WhitePawn
            {
                canPawnMove = canMoveWhite(this, targetPiece);
                if (enPassantBlackPawn)
                {
                    enPassantAttack = enPassantObj.checkEnPassantCapturingWhite(this,enPassantWhiteX,enPassantWhiteY);
                    return enPassantAttack;
                }

                canCornerPawnAttack = captureObj.cornerWhitePawnAttack(this);
                canPawnAttack = captureObj.whitePawnAttack(this);


            }
            else               //When CurrentPiece is BlackPawn
            {
                canPawnMove = canMoveBlack(this, targetPiece);
                if(enPassantWhitePawn)
                {
                    enPassantAttack = enPassantObj.checkEnPassantCapturingBlack(this,enPassantBlackX,enPassantBlackY);
                    return enPassantAttack;
                }

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
        boolean canMoveOneStepForward = (currentPiece.getPositionX()+1 == targetPiece.getPositionX()) ? true : false;

        if(getIsFirstMove())
        {
            //canMoveTwoStepForward can be true only when it is first move
            boolean canMoveTwoStepForward = (currentPiece.getPositionX()+2 ==targetPiece.getPositionX()) ? true : false;

            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                // Set flag 1 to black, to check eligibility for enPassant attack.
                enPassantWhitePawn = (canMoveTwoStepForward)? true : false ;
                int enPassantWhiteX = (enPassantWhitePawn)? targetPiece.getPositionX() : 0;
                int enPassantWhiteY = (enPassantWhitePawn)? targetPiece.getPositionY() : 0;
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
        boolean canMoveOneStepForward = (currentPiece.getPositionX()-1 == targetPiece.getPositionX()) ? true : false;

        if(getIsFirstMove())
        {
            //canMoveTwoStepForward can be true only when it is first move
            boolean canMoveTwoStepForward = (currentPiece.getPositionX()-2 ==targetPiece.getPositionX()) ? true : false;

            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                // Set flag 1 to black, to check eligibility for enPassant attack.
                enPassantBlackPawn = (canMoveTwoStepForward)? true : false ;
                int enPassantBlackX = (enPassantBlackPawn)? targetPiece.getPositionX() : 0;
                int enPassantBlackY = (enPassantBlackPawn)? targetPiece.getPositionY() : 0;
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
