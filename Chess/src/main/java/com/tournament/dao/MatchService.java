package com.tournament.dao;

import com.tournament.model.Matches;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    IMatchRepository IMatchRepository;

    public MatchService(IMatchRepository IMatchRepository) {
        this.IMatchRepository = IMatchRepository;
    }

    @Override
    public void saveMatch(Matches matches) {
        IMatchRepository.saveMatch(matches);
    }

    @Override
    public List<Matches> getAllMatch() {
        return IMatchRepository.getAllMatch();
    }

    public Integer getAllMatchCount() {
        List<Matches> temp = IMatchRepository.getAllMatch();
        return temp.size();
    }

    @Override
    public void updateMatch(Matches matches, int matchId) {
        IMatchRepository.updateMatch(matches, matchId);
    }

    @Override
    public void deleteMatch(int matchId) {
        IMatchRepository.deleteMatch(matchId);
    }

}
