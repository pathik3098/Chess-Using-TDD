package com.pieces;

import com.chessboard.IBoard;
import com.pieces.interfaces.ICaptureMovePawn;
import com.pieces.interfaces.IEnPassantPawn;

public class Pawn extends Piece
{
    private boolean hasMoved;
    private boolean canPawnMove;
    private boolean canPawnAttack;
    private boolean canCornerPawnAttack;
    private boolean isDiffColourPawn;
    private boolean isForwardMove;
    private boolean enPassantAttack;
    private boolean pawnPromotionMove;
    private int targetX;

    boolean enPassantBlackPawn;
    private int enPassantBlackX;
    private int enPassantBlackY;

    boolean enPassantWhitePawn;
    private int enPassantWhiteX;
    private int enPassantWhiteY;

    public Pawn(int x, int y, boolean isWhite, String path, IBoard board)
    {
        super(x,y,isWhite,path,board);
        hasMoved = false;
        canPawnMove = false;
        canPawnAttack = false;
        canCornerPawnAttack = false;
        isDiffColourPawn = false;
        isForwardMove = false;
        enPassantAttack = false;
        pawnPromotionMove = false;

        enPassantBlackPawn = false;
        enPassantBlackX = 0;
        enPassantBlackY = 0;
        
        enPassantWhitePawn = false;
        enPassantWhiteX = 0;
        enPassantWhiteY = 0;
    }

    public boolean getIsFirstMove()
    {
        return hasMoved;
    }

    public void setIsFirstMove(boolean hasMoved)
    {
        this.hasMoved = hasMoved;
    }

    @Override
    public boolean validMove(int destinationX, int destinationY)
    {
        this.targetX = destinationX;
        Piece targetPiece = board.getPiece(destinationX,destinationY);

        isDiffColourPawn = differentColourPiece(this,targetPiece);
        isForwardMove  = (targetPiece == null && this.getPositionY() == destinationY);

        if (isDiffColourPawn)
        {
            ICaptureMovePawn captureObj = new CaptureMovePawn();
            captureObj.initialiseValues(this, destinationX,destinationY, board);

            IEnPassantPawn enPassantObj = new EnPassantPawn();

            if (this.isWhite()) //When CurrentPiece is WhitePawn
            {
                canPawnMove = canMoveWhite(this, destinationX,destinationY);

                if (enPassantBlackPawn)
                {
                    enPassantAttack = enPassantObj.checkEnPassantCapturingWhite(this,enPassantWhiteX,enPassantWhiteY);
                    return enPassantAttack;
                }

                canCornerPawnAttack = captureObj.cornerWhitePawnAttack(this);
                canPawnAttack = captureObj.whitePawnAttack(this);

            }
            else              //When CurrentPiece is BlackPawn
            {
                canPawnMove = canMoveBlack(this, destinationX,destinationY);
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

    private boolean canMoveWhite(Piece currentPiece, int destinationX, int destinationY)
    {
        boolean canMoveOneStepForward = (currentPiece.getPositionX()+1 == destinationX);

        if(!getIsFirstMove())
        {
            //canMoveTwoStepForward can be true only when it is first move
            boolean canMoveTwoStepForward = (currentPiece.getPositionX()+2 == destinationX);

            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                // Set flag 1 to black, to check eligibility for enPassant attack.
                if(canMoveTwoStepForward)
                {
                    enPassantWhitePawn = true;
                    int enPassantWhiteX = destinationX;
                    int enPassantWhiteY = destinationY;
                }
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
    private boolean canMoveBlack(Piece currentPiece, int destinationX, int destinationY)
    {
        boolean canMoveOneStepForward = (currentPiece.getPositionX()-1 == destinationX);

        if(!getIsFirstMove())
        {
            //canMoveTwoStepForward can be true only when it is first move
            boolean canMoveTwoStepForward = (currentPiece.getPositionX()-2 == destinationX);

            if( isForwardMove && (canMoveOneStepForward || canMoveTwoStepForward))
            {
                // Set flag 1 to black, to check eligibility for enPassant attack.
                if(canMoveTwoStepForward)
                {
                    enPassantBlackPawn = true;
                    int enPassantBlackX = destinationX;
                    int enPassantBlackY = destinationY;
                }
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
    public boolean isPawnPromotion()
    {
        if(targetX == 7)
        {
            pawnPromotionMove = true;
            return pawnPromotionMove;
        }

        if(targetX == 0)
        {
            pawnPromotionMove = true;
            return pawnPromotionMove;
        }
        return pawnPromotionMove;
    }
}
