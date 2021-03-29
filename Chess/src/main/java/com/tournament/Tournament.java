package com.tournament;
import java.util.ArrayList;
import java.util.HashMap;

public class Tournament {

    private enum NumberType
    {
        ODD,
        EVEN
    }
    public static ArrayList<String> Players;
    public static HashMap<String,String> schedule = new HashMap<String, String>();
    public PlayerPairs[] pair;
    public Match[] match;

    public Tournament()
    {
        Players= new ArrayList<String>();
        this.Players.add("sravani");
        this.Players.add("Aparna");
        this.Players.add("Darshil");
        this.Players.add("Pathik");
        this.Players.add("Kethan");
        this.Players.add("Rob");
        this.Players.add("Rashmika");
        for (String i : Players)
            System.out.println(i);
    }
    public int getsizePlayers(ArrayList<String> Players)
    {
        return Players.size();
    }
    public int getpossiblePairs(ArrayList<String> Players)
    {
        int pairsPossible = Players.size()/2;
        System.out.println("Num pairs possible: "+pairsPossible);
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
    public void Scheduling(ArrayList<String> Players) {
        NumberType Type;
        int numPlayers=getsizePlayers(Players);
        int numPairs=getpossiblePairs(Players);
        Type = isOddEven(numPlayers);
        switch (Type) {
            case ODD: {
                pair= new PlayerPairs[numPairs];
                match= new Match[numPairs];
                pairing(Players);
                pairMatchCreation(pair);
                break;
            }
            case EVEN: {
                pair= new PlayerPairs[numPairs];
                match= new Match[numPairs];
                pairing(Players);
                break;
            }
            default: {
                System.out.println("NA");
            }
        }
    }
    public HashMap<String,String> pairing(ArrayList<String> Players) {
        String name = Players.remove(Players.size() - 1);
        System.out.println("name is:" + name);
        System.out.println("The size is:" + Players.size());
        for (int i = 0, j = 0; i < getsizePlayers(Players); i = i + 2, j++) {
            schedule.put(Players.get(i), Players.get(i + 1));
            //pair[j] = new PlayerPairs(Players.get(i), Players.get(i + 1));
        }
        return schedule;
    }
    public void pairMatchCreation(PlayerPairs[] pair) {
        for(int i=0; i<pair.length ;i++)
        {
            System.out.println(("Creating match object for :" +i+"pair"));
            match[i] = new Match(pair[i].getFirstPlayer(),pair[i].getSecondPlayer());
        }
    }

    public void display()
    {
        Scheduling(Players);
        for(String i:schedule.keySet())
        {
            System.out.println(i + "," + schedule.get(i));
        }
        for (int i=0; i< pair.length;i++)
        {
            System.out.println(pair[i].getFirstPlayer()+":"+pair[i].getSecondPlayer());
        }
    }
}
