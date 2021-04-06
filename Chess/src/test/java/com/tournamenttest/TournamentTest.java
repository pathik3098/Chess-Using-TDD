package com.tournamenttest;

import com.tournament.Player;
import com.tournament.Tournament;
import com.tournament.TournamentMock;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentTest {

    TournamentMock tournamentMock = new TournamentMock();
    Tournament tournament;
    @Test
    void getpossiblePairsOddTest() {
        ArrayList<Player> players = new ArrayList();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(tournament.getPossiblePairs(players),3);
    }

    @Test
    void getpossiblePairsEvenTest() {
        ArrayList<Player> players = new ArrayList();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(tournament.getPossiblePairs(players),3);
    }

    @Test
    void getPlayerSize() {
        ArrayList<Player> players = new ArrayList();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(tournament.getPlayerSize(players),6);
    }

    @Test
    void pairingTest() {
        ArrayList<Player> players = new ArrayList();
        HashMap<Player, Player> mockPairPlayers = new HashMap<Player, Player>();
        HashMap<Player, Player> pairPlayers = new HashMap<Player, Player>();
        HashMap<String, String> Pairs = new HashMap<String, String>();
        HashMap<String, String> mockPairs = new HashMap<String, String>();
        players = tournamentMock.getPlayers();
        tournament = new Tournament(players);
        mockPairPlayers = tournamentMock.getPairs();
        pairPlayers=tournament.pairing(players);
       for(Player mockPlayerkeys:mockPairPlayers.keySet())
        {
            mockPairs.put(mockPlayerkeys.getPlayerName(),mockPairPlayers.get(mockPlayerkeys).getPlayerName());
        }
        for(Player playerkeys:pairPlayers.keySet())
        {
            Pairs.put(playerkeys.getPlayerName(),pairPlayers.get(playerkeys).getPlayerName());
        }
        Assertions.assertEquals(Pairs,mockPairs);
    }

    @Test
    void matchCreation(){
        MatchMock[] matchmock;
        ArrayList<Player> players = new ArrayList();
        HashMap<Player, Player> mockPairPlayers = new HashMap<Player, Player>();
        players = tournamentMock.getPlayers();
        mockPairPlayers = tournamentMock.getPairs();
        int i=0;
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();
        matchmock = new MatchMock[3];
        for(Player mockPlayerkeys:mockPairPlayers.keySet())
        {
            matchmock[i] = new MatchMock(mockPlayerkeys,mockPairPlayers.get(mockPlayerkeys));
            i++;
        }
        for(int j=0; j<mockPairPlayers.size() ;j++)
        {
            nextRoundPlayers.add(matchmock[j].getWinner());
        }
        Assertions.assertEquals(3,nextRoundPlayers.size());
    }

    @After
    public void destroy()
    {
        tournamentMock = null;
        tournament = null;
    }
}
