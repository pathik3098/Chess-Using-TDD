package com.tournamenttest;

import com.tournament.model.Match;
import com.tournament.Player;
import com.tournament.persistence.PlayerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatchesTest {

    @Test
    void matchPlayedTest() {
        PlayerPersistence db = new PlayerPersistence();
        Player player1 = new Player();
        Player player2 = new Player();
        Match match = new Match(player1,player2);
        Assertions.assertEquals(false, match.getResult());
    }

}
