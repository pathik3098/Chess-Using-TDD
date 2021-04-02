package com.tournamenttest;

import com.tournament.Player;
import com.tournament.persistence.TournamentPersistence;
import com.tournament.persistence.interfaces.ITournamentPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


import java.sql.SQLException;
import java.util.Random;

public class TournamentPersistenceTest {

    @Test
    public void loadPlayerTest()
    {
        ITournamentPersistence T = new TournamentPersistence();
        Random random = new Random();
        Player player = new Player("Sravani");
        //Assertions.assertEquals(T.loadPlayer(player,random.nextInt()),1);
    }
}
