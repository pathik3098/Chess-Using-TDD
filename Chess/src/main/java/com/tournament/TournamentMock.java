package com.tournament;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentMock {
    private final ArrayList<Player> Players = new ArrayList<>();;
    private final HashMap<Player, Player> pairs = new HashMap<Player,Player>();
    public TournamentMock()
    {
        Players.add(new Player("Sravani"));
        Players.add(new Player("Aparna"));
        Players.add(new Player("Darshil"));
        Players.add(new Player("Pathik"));
        Players.add(new Player("Kethan"));
        Players.add(new Player("Rob"));
        //Players.add(new Player("Rashmika"));
        pairs.put(new Player("Sravani"),new Player("Aparna"));
        pairs.put(new Player("Darshil"),new Player("Pathik"));
        pairs.put(new Player("Kethan"),new Player("Rob"));
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public HashMap<Player,Player> getPairs()
    {
        return pairs;
    }
}
