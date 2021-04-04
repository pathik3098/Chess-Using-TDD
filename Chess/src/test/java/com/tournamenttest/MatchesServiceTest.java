package com.tournamenttest;

import com.tournament.model.Match;
import com.tournament.persistence.MatchPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MatchesServiceTest {

    @Test
    void getAllMatchesTest() {
        MatchPersistence matchPersistence = Mockito.mock(MatchPersistence.class);

        List<Match> matchesList = new ArrayList<>();
        Mockito.when(matchPersistence.getAllMatch()).thenReturn(matchesList);

        Assertions.assertNotNull(matchesList);
    }
}
