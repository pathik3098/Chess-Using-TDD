package com.pieces;

import com.chessboard.Board;

public class Queen extends Piece implements IBishop {

    public Queen(int initialX, int initialY, boolean isWhite, String filepath, Board board) {
        super(initialX, initialY, isWhite, filepath, board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        Piece piece = board.getPiece(finalCordX, finalCordY);

//        if (checkValidMoveConditions(differentColourPiece(this, piece))) return false;
//        System.out.println("1");
//        if (checkValidMoveConditions(StraightMovement(finalCordX, finalCordY) || diagonalMovement(finalCordX, finalCordY))) return false;
//        System.out.println("2");
//        if (checkValidMoveConditions(IsPieceInBetween(finalCordX, finalCordY)||checkIfPieceInBetween(finalCordX, finalCordY))) return false;
//        System.out.println("3");


//        if (checkValidMoveConditions(diagonalMovement(finalCordX, finalCordY))) return false;
//        System.out.println("4");
//        if (checkValidMoveConditions(checkIfPieceInBetween(finalCordX, finalCordY))) return false;
//        System.out.println("5");


        return true;
    }

//    @Override
    public boolean straightMovement(Piece currentPiece, Piece targetPiece) {
        return (currentPiece.getPositionX() == targetPiece.getPositionX()) || (currentPiece.getPositionY() == targetPiece.getPositionY());
    }

    public boolean StraightMovement(int finalCordX, int finalCordY) {
        return (this.getPositionX() == finalCordX) || (this.getPositionY() == finalCordY);
    }

//    @Override
    public boolean isPieceInBetween(Piece currentPiece, Piece targetPiece) {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        int targetX = targetPiece.getPositionX();
        int targetY = targetPiece.getPositionY();

        int directionSignX = Integer.signum(targetX - currentX);
        int directionSignY = Integer.signum(targetY - currentY);

        if (directionSignX > 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX + i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX - i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY > 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY + i);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY < 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY - i);

                if (p != null) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean IsPieceInBetween(int finalCordX, int finalCordY) {
        int currentX = this.getPositionX();
        int currentY = this.getPositionY();
        int targetX = finalCordX;
        int targetY = finalCordY;

        int directionSignX = Integer.signum(targetX - currentX);
        int directionSignY = Integer.signum(targetY - currentY);

        if (directionSignX > 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX + i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0) {
            int spaceToMove = Math.abs(targetX - currentX);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX - i, currentY);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY > 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY + i);

                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignY < 0) {
            int spaceToMove = Math.abs(targetY - currentY);

            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(currentX, currentY - i);

                if (p != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Boolean diagonalMovement(int finalCordX, int finalCordY) {
        return (Math.abs(finalCordX - this.getPositionX()) == Math.abs(finalCordY - this.getPositionY()));
    }

    @Override
    public Boolean checkIfPieceInBetween(int finalCordX, int finalCordY) {
        String Direction = getDirectionMovement(finalCordX, finalCordY);

        if (checkPieceInBetweenNE(finalCordX, Direction)) return false;

        if (checkPieceInBetweenNW(finalCordY, Direction)) return false;

        if (checkPieceInBetweenSW(finalCordX, Direction)) return false;

        if (checkPieceInBetweenSE(finalCordY, Direction)) return false;

        return true;
    }

    @Override
    public String getDirectionMovement(int finalCordX, int finalCordY) {
        int directionSignX = Integer.signum(finalCordX - this.getPositionX());
        int directionSignY = Integer.signum(finalCordY - this.getPositionY());

        if (directionSignX > 0 && directionSignY > 0) {
            return NORTHEAST;
        }
        if (directionSignX < 0 && directionSignY > 0) {
            return NORTHWEST;
        }
        if (directionSignX < 0 && directionSignY < 0) {
            return SOUTHWEST;
        }
        if (directionSignX > 0 && directionSignY < 0) {
            return SOUTHEAST;
        }
        return "";
    }

    @Override
    public Boolean checkPieceInBetweenNE(int finalCordX, String Direction) {
        if (Direction.equals(NORTHEAST)) {
            int spaces_in_between = Math.abs(finalCordX - this.getPositionX()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean checkPieceInBetweenNW(int finalCordY, String Direction) {
        if (Direction.equals(NORTHWEST)) {
            int spaces_in_between = Math.abs(finalCordY - this.getPositionY()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() + i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean checkPieceInBetweenSW(int finalCordX, String Direction) {
        if (Direction.equals(SOUTHWEST)) {
            int spaces_in_between = Math.abs(this.getPositionX() - finalCordX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() - i, this.getPositionY() - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean checkPieceInBetweenSE(int finalCordY, String Direction) {
        if (Direction.equals(SOUTHEAST)) {
            int spaces_in_between = Math.abs(this.getPositionY() - finalCordY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(this.getPositionX() + i, this.getPositionY() - i);
                if (p != null) {
                    return true;
                }
            }
        }
        return false;
    }


}
