package com.tournament;
import java.util.ArrayList;
import java.util.HashMap;

public class Tournament {

    private enum NumberType
    {
        ODD,
        EVEN
    }
    private static final int timelimit =20000;
    public static ArrayList<Player> Players;
    public static HashMap<Player, Player> schedule;
    public Match[] match;

    public Tournament(ArrayList<Player> Players)
    {
        this.Players= Players;
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
        while(numPlayers >1)
        {
            Type = isOddEven(numPlayers);
            switch (Type) {
                case ODD: {
                    System.out.println("IN ODD");
                    Player name = Players.remove(Players.size() - 1);
                    match = new Match[numPairs];
                    schedule = new HashMap<Player, Player>();
                    pairing(Players);
                    ArrayList<Player> nextRoundPlayers = pairMatchCreation(schedule);
                    nextRoundPlayers.add(name);
                    numPairs=getPossiblePairs(nextRoundPlayers);
                    Players = nextRoundPlayers;
                    numPlayers = nextRoundPlayers.size();
                    break;
                }
                case EVEN: {
                    System.out.println("IN EVEN");
                    match = new Match[numPairs];
                    schedule = new HashMap<Player, Player>();
                    pairing(Players);
                    ArrayList<Player> nextRoundPlayers = pairMatchCreation(schedule);
                    numPairs=getPossiblePairs(nextRoundPlayers);
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
}
