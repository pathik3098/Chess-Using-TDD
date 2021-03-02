package Piece;

import java.util.ArrayList;

abstract class piece
{
    //Assuming the current board status as of now
    char[][] current_board_state = {    {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','0','p','p','p'},
            {'0','0','0','0','p','0','0','0'},
            {'0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0'},
            {'N','0','0','P','0','0','0','0'},
            {'P','P','P','0','P','P','P','P'},
            {'R','0','B','Q','K','B','N','R'}
    };

    ArrayList<Integer> possible_moves = new ArrayList<Integer>(5);

    //Destination x & y - where the user wants to move
    public int Des_x;
    public int Des_y;

    //Current x & y position of the pawn piece - from which the user wants to move
    public int Cur_x;
    public int Cur_y;

    //piece_colour_indicator
    public int c;

    //Initialising
    boolean pawn_moved = false;


    public void getDesPositions(int x, int y)
    {
        this.Des_x = x;
        this.Des_y = y;
    }

    public void getCurrentPositions(int a, int b)
    {
        this.Cur_x = a;
        this.Cur_y = b;
    }

    public int iswhiteOrblack(String colour)
    {
        if (colour.equals("white"))
        {
            c = 1;
            return c;
        }
        else
        {
            c = 0;
            return c;
        }
    }

    public abstract boolean ValidMove(int target_x, int target_y);
}
