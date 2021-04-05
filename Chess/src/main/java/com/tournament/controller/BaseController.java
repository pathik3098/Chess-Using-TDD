package com.tournament.controller;

import com.chessboard.Board;
import com.pieces.Piece;
import com.tournament.Player;
import com.tournament.model.IMatch;
import com.tournament.model.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {

    IMatch iMatch = new Match();
    Player player1 = new Player();
    Player player2 = new Player();
    Board board = new Board();
    Piece activePiece;

    @RequestMapping("/matchChess")
    public String viewMatchChessPage(HttpServletRequest request, Model model) {
        iMatch.createBoard(player1, player2);
        board = iMatch.getBoard();

        Map<String, String> piecePositions = new HashMap<String, String>();
        piecePositions = iMatch.getBoard().getPositions();
        System.out.println(piecePositions);
        model.addAttribute("positions", piecePositions);

        return "MatchChess";
    }

    @RequestMapping(value = "/handleChessMove", method = {RequestMethod.POST})
    public String handleChessMove(HttpServletRequest request, Model model) {

        String inputX = request.getParameter("inputX");
        String inputY = request.getParameter("inputY");

        int clickX = Integer.parseInt(inputX);
        int clickY = Integer.parseInt(inputY);

        board.chessMovement(clickX, clickY);
        System.out.println(board.activePiece);

        Map<String, String> piecePositions = new HashMap<String, String>();
        piecePositions = iMatch.getBoard().getPositions();
        System.out.println(piecePositions);
        model.addAttribute("positions", piecePositions);

        model.addAttribute("error", "Failed");

        return "MatchChess";
    }

}
