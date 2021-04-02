package com.tournament.persistence;

import com.tournament.model.Matches;
import com.tournament.persistence.interfaces.IMatchRepository;
import com.tournament.persistence.interfaces.IMatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    com.tournament.persistence.interfaces.IMatchRepository IMatchRepository;

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
