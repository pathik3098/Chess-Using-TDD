package com.tournamenttest;

import com.tournament.Match;
import com.tournament.Player;
import com.tournament.persistence.PlayerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatchesTest {

    @Test
    void matchPlayedTest() {
        PlayerPersistence db = new PlayerPersistence();
        Player player1 = new Player(1, db);
        Player player2 = new Player(2,db);
        Match match = new Match(player1,player2);
        Assertions.assertEquals(true, match.getResult());
    }

}
