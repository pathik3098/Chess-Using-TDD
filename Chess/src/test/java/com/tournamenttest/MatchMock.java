package com.tournamenttest;

import com.tournament.Player;

public class MatchMock{

        Player player1;
        Player player2;
        int totalTime;
        private int matchId;
        private String player1id;
        private String player2id;
        private String startTime;
        private String endTime;
        private int tournamentId;
        private String matchWinner;

        public MatchMock(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        public Player getWinner() {
            return player1;
        }

    }
