package com.tournamenttest;

import com.tournament.Alliance;
import com.tournament.Player;
import com.tournament.PlayerDB.PlayerDBMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class
PlayerTest {

    @Test
    public void setAlliance()
    {
        PlayerDBMock db = new PlayerDBMock();
        Player p = new Player();
        p.setAlliance(Alliance.WHITE);
        Assertions.assertEquals(Alliance.WHITE,p.getAlliance());
        Assertions.assertEquals("pathik",p.getPlayerName());
        Assertions.assertEquals(2,p.getPlayerPoints());

    }
}
