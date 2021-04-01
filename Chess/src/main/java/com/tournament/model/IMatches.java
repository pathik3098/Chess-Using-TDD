package com.tournament.model;

import java.time.LocalDateTime;

public interface IMatches {

    int getMatchId();
    void setMatchId(int matchId);

    String getPlayer1id();
    void setPlayer1id(String player1id);

    String getPlayer1Name();
    void setPlayer1Name(String player1Name);

    String getPlayer2id();
    void setPlayer2id(String player2id);

    String getPlayer2Name();
    void setPlayer2Name(String player2Name);

    String getStartTime();
    void setStartTime(String startTime);

    String getEndTime();
    void setEndTime(String endTime);

    int getTournamentId();
    void setTournamentId(int tournamentId);

    String getResult();
    void setResult(String result);
}
