package com.tournamenttest;

import com.tournament.persistence.MatchPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class MatchesServiceTest {

    @Test
    void getAllMatchesTest(){
        MatchPersistence matchPersistence = Mockito.mock(MatchPersistence.class);
//        MatchService matchService = new MatchService(matchRepository);

//        Match matches = new Match();
//        List<Match> matchesList = new ArrayList<>();

//        matchesList.add(matches);
//        Mockito.when(matchPersistence.getAllMatch()).thenReturn(matchesList);
//        List<Matches> returnedMatches = matchService.getAllMatch();
        Assertions.assertTrue((BooleanSupplier) matchPersistence.getAllMatch());
    }


}
