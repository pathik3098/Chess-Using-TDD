package com.tournament;
import com.tournament.model.Match;
import com.tournament.persistence.LeaderBoardPersistence;
import com.tournament.persistence.TournamentPersistence;
import com.tournament.persistence.interfaces.ILeaderBoardPersistence;
import com.tournament.persistence.interfaces.ITournamentPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Tournament {

    private enum NumberType
    {
        ODD,
        EVEN
    }
    private static final int timelimit =100;
    public static ArrayList<Player> Players;
    public static HashMap<Player, Player> schedule;
    public Match[] match;
    Random random = new Random();

    public Tournament(ArrayList<Player> Players)
    {
        this.Players= Players;
        //Random random = new Random();
        Scheduling(Players);

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

    public NumberType isOddEven(int numPlayers)
    {
        int remainder = numPlayers%2;
        if (remainder == 0)
        {
            return NumberType.EVEN;
        }
        else
        {
            return NumberType.ODD;
        }
    }

    public void Scheduling(ArrayList<Player> Players) {
        NumberType Type;
        int numPlayers=getPlayerSize(Players);
        int numPairs=getPossiblePairs(Players);
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();
        while(numPlayers >1) {
            Type = isOddEven(numPlayers);
            switch (Type) {
                case ODD: {
                    System.out.println("IN ODD");
                    Player name = Players.remove(Players.size() - 1);
                    match = new Match[numPairs];
                    schedule = new HashMap<Player, Player>();
                    pairing(Players);
                    nextRoundPlayers = pairMatchCreation(schedule);
                    nextRoundPlayers.add(name);
                    numPairs = getPossiblePairs(nextRoundPlayers);
                    Players = nextRoundPlayers;
                    numPlayers = nextRoundPlayers.size();
                    break;
                }
                case EVEN: {
                    System.out.println("IN EVEN");
                    match = new Match[numPairs];
                    schedule = new HashMap<Player, Player>();
                    pairing(Players);
                    nextRoundPlayers = pairMatchCreation(schedule);
                    numPairs = getPossiblePairs(nextRoundPlayers);
                    Players = nextRoundPlayers;
                    numPlayers = nextRoundPlayers.size();
                    break;
                }
                default: {
                    System.out.println("NA");
                    break;
                }
            }
        }
        ITournamentPersistence tournamentPersistence = new TournamentPersistence();
        tournamentPersistence.loadPlayer(nextRoundPlayers.get(0), random.nextInt());
     }

    public HashMap<Player,Player> pairing(ArrayList<Player> Players) {
        schedule = new HashMap<Player, Player>();
        for (int i = 0; i < getPlayerSize(Players); i = i + 2) {
            schedule.put(Players.get(i), Players.get(i + 1));
        }
        return schedule;
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
            match[j].getResult();
            nextRoundPlayers.add(match[j].getWinner());
        }
        return nextRoundPlayers;
    }

    public List<Player> getLeaderboard(){

        List<Player> playerList = null;
        try {
            ILeaderBoardPersistence iLeaderBoardPersistence = new LeaderBoardPersistence();
            playerList = iLeaderBoardPersistence.getLeaderboard(4);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }

}
