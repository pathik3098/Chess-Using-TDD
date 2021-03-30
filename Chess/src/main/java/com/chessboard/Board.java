package com.chessboard;

import com.pieces.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    public ArrayList<Piece> blackPieces;
    public ArrayList<Piece> whitePieces;
    public Piece activePiece;
    private int turn = 0;
    private final int row = 8;
    private final int column = 8;
    private int[][] boardMatrix;
    boolean whiteTurn = true;
    private Piece p;

    public Board()
    {
        //player1.alliance = Alliance.WHITE;
        //player2.alliance = Alliance.BLACK;

        boardMatrix = new int[row][column];
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        PieceFactory.setFactory(new NormalPiece());
        PieceFactory factory = PieceFactory.instance();

        whitePieces.add(factory.createKing(0,3,true,"",this));
        whitePieces.add(factory.createQueen(0,4,true,"",this));
        whitePieces.add(factory.createKing(0,1,true,"",this));
        whitePieces.add(factory.createKnight(0,6,true,"",this));
        whitePieces.add(factory.createBishop(0,2,true,"",this));
        whitePieces.add(factory.createBishop(0,5,true,"",this));
        whitePieces.add(factory.createRook(0,0,true,"",this));
        whitePieces.add(factory.createRook(0,7,true,"",this));
        whitePieces.add(factory.createPawn(1,0,true,"",this));
        whitePieces.add(factory.createPawn(1,1,true,"",this));
        whitePieces.add(factory.createPawn(1,2,true,"",this));
        whitePieces.add(factory.createPawn(1,3,true,"",this));
        whitePieces.add(factory.createPawn(1,4,true,"",this));
        whitePieces.add(factory.createPawn(1,5,true,"",this));
        whitePieces.add(factory.createPawn(1,6,true,"",this));
        whitePieces.add(factory.createPawn(1,7,true,"",this));

        blackPieces.add(factory.createKing(7,3,true,"",this));
        blackPieces.add(factory.createQueen(7,4,true,"",this));
        blackPieces.add(factory.createKnight(7,1,true,"",this));
        blackPieces.add(factory.createKnight(7,6,true,"",this));
        blackPieces.add(factory.createBishop(7,2,true,"",this));
        blackPieces.add(factory.createBishop(7,5,true,"",this));
        blackPieces.add(factory.createRook(7,0,true,"",this));
        blackPieces.add(factory.createRook(7,7,true,"",this));
        blackPieces.add(factory.createPawn(6,0,true,"",this));
        blackPieces.add(factory.createPawn(6,1,true,"",this));
        blackPieces.add(factory.createPawn(6,2,true,"",this));
        blackPieces.add(factory.createPawn(6,3,true,"",this));
        blackPieces.add(factory.createPawn(6,4,true,"",this));
        blackPieces.add(factory.createPawn(6,5,true,"",this));
        blackPieces.add(factory.createPawn(6,6,true,"",this));
        blackPieces.add(factory.createPawn(6,7,true,"",this));


        /*
        whitePieces.add(new King(0,3,true,"",this));
        whitePieces.add(new Queen(0,4,true,"",this));
        whitePieces.add(new Knight(0,1,true,"",this));
        whitePieces.add(new Knight(0,6,true,"",this));
        whitePieces.add(new Bishop(0,2,true,"",this));
        whitePieces.add(new Bishop(0,5,true,"",this));
        whitePieces.add(new Rook(0,0,true,"",this));
        whitePieces.add(new Rook(0,7,true,"",this));
        whitePieces.add(new Pawn(1,0,true,"",this));
        whitePieces.add(new Pawn(1,1,true,"",this));
        whitePieces.add(new Pawn(1,2,true,"",this));
        whitePieces.add(new Pawn(1,3,true,"",this));
        whitePieces.add(new Pawn(1,4,true,"",this));
        whitePieces.add(new Pawn(1,5,true,"",this));
        whitePieces.add(new Pawn(1,6,true,"",this));
        whitePieces.add(new Pawn(1,7,true,"",this));

        blackPieces.add(new King(7,3,true,"",this));
        blackPieces.add(new Queen(7,4,true,"",this));
        blackPieces.add(new Knight(7,1,true,"",this));
        blackPieces.add(new Knight(7,6,true,"",this));
        blackPieces.add(new Bishop(7,2,true,"",this));
        blackPieces.add(new Bishop(7,5,true,"",this));
        blackPieces.add(new Rook(7,0,true,"",this));
        blackPieces.add(new Rook(7,7,true,"",this));
        blackPieces.add(new Pawn(6,0,true,"",this));
        blackPieces.add(new Pawn(6,1,true,"",this));
        blackPieces.add(new Pawn(6,2,true,"",this));
        blackPieces.add(new Pawn(6,3,true,"",this));
        blackPieces.add(new Pawn(6,4,true,"",this));
        blackPieces.add(new Pawn(6,5,true,"",this));
        blackPieces.add(new Pawn(6,6,true,"",this));
        blackPieces.add(new Pawn(6,7,true,"",this));

         */

        this.gridInitialize();

        //drawboard();
    }

    public void gridInitialize()
    {
        for(int i=0; i<row ;i++)
        {
            for(int j=0; j<column ;j++)
            {
                boardMatrix[i][j] = 0;
            }
        }
    }

    public Piece getPiece(int x, int y)
    {
        Iterator<Piece> whiteIter = whitePieces.iterator();
        Iterator<Piece> blackIter = blackPieces.iterator();

        while(whiteIter.hasNext())
        {
            Piece p = whiteIter.next();
            if(p.getPositionX()==x && p.getPositionY()==y)
            {
                return p;
            }
        }
        while(blackIter.hasNext())
        {
            Piece p = blackIter.next();
            if(p.getPositionX()==x && p.getPositionY()==y)
            {
                return p;
            }
        }
        return null;
    }

    public void chessMovement(int x,int y)
    {
        int clickedX = x;
        int clickedY = y;

        Piece clickedPiece = getPiece(clickedX,clickedY);

        if ((turn%2)==1)
        {
            whiteTurn = false;
        }

        if(activePiece==null && clickedPiece != null)
        {
            setActivePiece(clickedPiece);
        }

        else if(activePiece != null)
        {
            movePiece(clickedX,clickedY);
        }

    }

    private void setActivePiece(Piece clickedPiece)
    {
        boolean isWhiteTurn = (whiteTurn && clickedPiece.isWhite());
        boolean isBlackTurn = (!whiteTurn && clickedPiece.isBlack());

        if(isWhiteTurn||isBlackTurn)
        {
            activePiece = clickedPiece;
        }
    }

    private void movePiece(int clickedX, int clickedY)
    {
        Piece clickPiece = getPiece(clickedX,clickedY);
        boolean validPieceMovePosition = activePiece.ValidMove(clickedX,clickedY);
        boolean isWhiteTurn = (whiteTurn && activePiece.isWhite());
        boolean isBlackTurn = (!whiteTurn && activePiece.isBlack());

        if(validPieceMovePosition && (isWhiteTurn || isBlackTurn))
        {
            if(clickPiece != null)
            {
                if(clickPiece.isWhite())
                {
                    whitePieces.remove(clickPiece);
                }
                else{
                    blackPieces.remove(clickPiece);
                }
            }

            activePiece.setPositionX(clickedX);
            activePiece.setPositionY(clickedY);

            if(activePiece.getClass().equals(Pawn.class))
            {
                Pawn pawn = (Pawn) activePiece;
                pawn.setIsFirstMove(true);
            }

            activePiece = null;
            turn++;
        }
    }

    public boolean getResult(){
        return true;
    }
}
