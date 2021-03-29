package com.tournamenttest;

import com.tournament.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentTest {


    @Test
    void getpossiblePairsOddTest() {
        Tournament tournament = new Tournament();
        ArrayList<String> players = new ArrayList();
        players.add("sravani");
        players.add("Aparna");
        players.add("Darshil");
        players.add("Pathik");
        players.add("Kethan");
        players.add("Rob");
        players.add("Rashmika");
        Assertions.assertEquals(tournament.getpossiblePairs(players),3);
    }
    @Test
    void getpossiblePairsEvenTest() {
        Tournament tournament = new Tournament();
        ArrayList<String> players = new ArrayList();
        players.add("sravani");
        players.add("Aparna");
        players.add("Darshil");
        players.add("Pathik");
        players.add("Kethan");
        players.add("Rob");
        Assertions.assertEquals(tournament.getpossiblePairs(players),3);
    }

    @Test
    void pairingTest(){
        Tournament tournament = new Tournament();
        HashMap<String,String> schedule = new HashMap<String, String>();
        ArrayList<String> players = new ArrayList();
        players.add("sravani");
        players.add("Aparna");
        players.add("Darshil");
        players.add("Pathik");
        players.add("Kethan");
        players.add("Rob");
        players.add("Rashmika");
        schedule.put("sravani","Aparna");
        schedule.put("Darshil","Pathik");
        schedule.put("Kethan","Rob");
        Assertions.assertTrue(tournament.pairing(players).equals(schedule));
    }
}
