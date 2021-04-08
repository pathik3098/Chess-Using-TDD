package com.tournament;
import com.tournament.model.Match;
import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.TournamentPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import com.tournament.persistence.interfaces.ITournamentPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Tournament {

    private static final int timelimit =100;
    private static ArrayList<Player> Players;
    private static HashMap<Player, Player> schedule;
    private Match[] match;
    Random random = new Random();
    private int id;
    private int tournamentID;

    public Tournament(ArrayList<Player> Players)
    {
        this.Players= Players;
        tournamentID=random.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getTournamentID() {
        return tournamentID;
    }

    public int getPlayerSize(ArrayList<Player> Players)
    {
        return Players.size();
    }

    public int getPossiblePairs(ArrayList<Player> Players)
    {
        int pairsPossible = Players.size()/2;
        return  pairsPossible;
    }

    public void organizingTournament(ArrayList<Player> Players)
    {
        int numPlayers=getPlayerSize(Players);
        int numPairs=getPossiblePairs(Players);

        while(numPlayers >1)
        {
            if (numPlayers % 2 == 1)
            {
                Players=oddScheduling(numPairs,Players);
            }
            else
            {
                Players=evenScheduling(numPairs,Players);
            }
            numPairs = getPossiblePairs(Players);
            numPlayers = Players.size();
        }

        ITournamentPersistence tournamentPersistence = new TournamentPersistence();
        tournamentPersistence.loadPlayer(Players.get(0), tournamentID);
    }

    public ArrayList<Player> oddScheduling(int numPairs,ArrayList<Player> Players)
    {
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();
        Player name = Players.remove(Players.size() - 1);
        match = new Match[numPairs];
        schedule = new HashMap<Player, Player>();
        schedule=pairing(Players);
        nextRoundPlayers=pairMatchCreation(schedule);
        nextRoundPlayers.add(name);
        return nextRoundPlayers;
    }

    public ArrayList<Player> evenScheduling(int numPairs,ArrayList<Player> Players)
    {
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();
        match = new Match[numPairs];
        schedule = new HashMap<Player, Player>();
        schedule=pairing(Players);
        nextRoundPlayers=pairMatchCreation(schedule);
        return nextRoundPlayers;
    }

    public HashMap<Player,Player> pairing(ArrayList<Player> Players) {
        HashMap<Player, Player> pairs = new HashMap<Player, Player>();

        for (int i = 0; i < getPlayerSize(Players); i = i + 2)
        {
            pairs.put(Players.get(i), Players.get(i + 1));
        }
        return pairs;
    }

    public ArrayList<Player> pairMatchCreation(HashMap<Player,Player> schedule) {
        int i=0;
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();

        for(Player p:schedule.keySet())
        {
            match[i] = new Match(p,schedule.get(p));
            i++;
        }

        try {
            Thread.sleep(timelimit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int j=0; j<schedule.size() ;j++)
        {
            nextRoundPlayers.add(match[j].getWinner());
        }

        return nextRoundPlayers;
    }

    public List<Player> getLeaderboard(){

        List<Player> playerList = null;
        try {
            IPlayerPersistence playerPersistence = new PlayerPersistence();
            playerList = playerPersistence.getLeaderboard(this.id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }
}
