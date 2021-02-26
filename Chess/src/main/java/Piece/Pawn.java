package Piece;

import java.util.ArrayList;
public class Pawn
{
    //Assuming the current board status as of now
    char[][] current_board_state = {    {'r','n','b','q','k','b','n','r'},
                                        {'p','p','p','p','0','p','p','p'},
                                        {'0','0','0','0','p','0','0','0'},
                                        {'0','0','0','0','0','0','0','0'},
                                        {'0','0','0','0','0','0','0','0'},
                                        {'0','0','0','P','0','0','0','0'},
                                        {'P','P','P','0','P','P','P','P'},
                                        {'R','N','B','Q','K','B','N','R'}
                                    };

    ArrayList<Integer> possible_moves = new ArrayList<Integer>(5);

    //Destination x & y - where the user wants to move
    private int Des_x;
    private int Des_y;

    //Current x & y position of the pawn piece - which the user wants to move
    private int Cur_x;
    private int Cur_y;

    //piece_colour_indicator
    private int c;

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

    public int[][] cal_Possible_Moves(int Cur_x, int Cur_y)
    {

        if ((pawn_moved == false) && (c == 1))
        {
            if ((current_board_state[Cur_x - 1][Cur_y] =='0') && (current_board_state[Cur_x - 2][Cur_y] =='0'))
            {
                possible_moves.add(current_board_state[Cur_x - 1][Cur_y]);
                possible_moves.add(current_board_state[Cur_x - 2][Cur_y]);
                pawn_moved = true;
            }

        }
        else if((pawn_moved == false) && (c == 0))
        {
            if ((current_board_state[Cur_x + 1][Cur_y] =='0') && (current_board_state[Cur_x + 2][Cur_y] =='0'))
            {
                possible_moves.add(current_board_state[Cur_x + 1][Cur_y]);
                possible_moves.add(current_board_state[Cur_x + 2][Cur_y]);
                pawn_moved = true;
            }
        }
    }

    //x & y are the destinations
    public boolean canMove(int x, int y)
    {

        return true;
    }
}
