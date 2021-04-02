package com.tournament.persistence.interfaces;

import com.tournament.model.Matches;

import java.util.List;

public interface IMatchRepository {
    void saveMatch(Matches matches);

    List<Matches> getAllMatch();

    Matches getMatchById(int matchId);

    void updateMatch(Matches matches, int matchId);

    void deleteMatch(int matchId);
}
