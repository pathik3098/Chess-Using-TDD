package Piece;
import java.util.ArrayList;

public class Pawn extends piece
{
    public void cal_Possible_Moves_white(int Cur_x, int Cur_y)
    {
        if (c == 1) //White
        {
            if (pawn_moved == false) // Pawn piece hasn't made its first move
            {
                if ((current_board_state[Cur_x - 1][Cur_y] == '0') && (current_board_state[Cur_x - 2][Cur_y] == '0')) {
                    ValidMove(Cur_x - 1, Cur_y);
                    ValidMove(Cur_x - 2, Cur_y);
                    pawn_moved = true;
                } else if ((current_board_state[Cur_x - 1][Cur_y] == '0') && (current_board_state[Cur_x - 2][Cur_y] != '0')) {
                    ValidMove(Cur_x - 1, Cur_y);
                } else {
                    //Cannot move: Pawn cannot Jump and move to the next
                    //Cannot move: Pawn cannot move front as the front places are occupied with other pieces.
                    System.out.println("Cannot move the pawn: The destination path is blocked");
                }
            }
            else { ValidMove(Cur_x - 1, Cur_y); }
        }
    }


    public void cal_Possible_Moves_black(int Cur_x, int Cur_y)
    {
        if (c == 0) // Black
        {
            if (pawn_moved == false) // Pawn piece hasn't made its first move
            {
                if ((current_board_state[Cur_x + 1][Cur_y] == '0') && (current_board_state[Cur_x + 2][Cur_y] == '0')) {
                    ValidMove(Cur_x + 1, Cur_y);
                    ValidMove(Cur_x + 2, Cur_y);
                    pawn_moved = true;
                } else if ((current_board_state[Cur_x + 1][Cur_y] == '0') && (current_board_state[Cur_x + 2][Cur_y] != '0')) {
                    ValidMove(Cur_x + 1, Cur_y);
                } else {
                    //Cannot move: Pawn cannot Jump and move to the next
                    //Cannot move: Pawn cannot move front as the front places are occupied with other pieces.
                    System.out.println("Cannot move the pawn: The destination path is blocked");
                }

            } else {
                ValidMove(Cur_x + 1, Cur_y);
            }
        }
    }

    public void attack_move(int Cur_x, int Cur_y)
    {

    }

    //x & y are the destinations
    public boolean ValidMove(int x, int y)
    {
        if ((x == Des_x) && (y == Des_y) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    
}
