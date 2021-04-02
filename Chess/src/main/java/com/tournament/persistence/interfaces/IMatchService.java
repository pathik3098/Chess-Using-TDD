package com.tournament.persistence.interfaces;

import com.tournament.model.Matches;

import java.util.List;

public interface IMatchService {
    void saveMatch(Matches matches);

    List<Matches> getAllMatch();

    void updateMatch(Matches matches, int matchId);

    void deleteMatch(int matchId);
}
