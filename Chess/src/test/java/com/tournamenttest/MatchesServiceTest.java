package com.tournamenttest;

import com.tournament.Match;
import com.tournament.dao.MatchRepository;
import com.tournament.dao.MatchService;
import com.tournament.model.Matches;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MatchesServiceTest {

    @Test
    void getAllMatchesTest(){
        MatchRepository matchRepository = Mockito.mock(MatchRepository.class);
        MatchService matchService = new MatchService(matchRepository);

        Matches matches = new Matches();
        List<Matches> matchesList = new ArrayList<>();

        matchesList.add(matches);
        Mockito.when(matchRepository.getAllMatch()).thenReturn(matchesList);
        List<Matches> returnedMatches = matchService.getAllMatch();
        Assertions.assertTrue(returnedMatches.equals(matchesList));
    }


}
