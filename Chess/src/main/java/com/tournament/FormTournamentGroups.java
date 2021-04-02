package com.tournament;

import com.tournament.persistence.PlayerPersistence;
import java.util.ArrayList;
import java.util.List;

class FormTournamentGroups
{
    PlayerPersistence obj = new PlayerPersistence();
    List<Player> playerList = obj.loadAllPlayers();

    ArrayList<Player> expert = new ArrayList<>();
    ArrayList<Player> intermediate = new ArrayList<>();;
    ArrayList<Player> beginner = new ArrayList<>();

    int numOfUsersActive = 0;
    int PlayerLevel = 0;
    int Players = 0;
    int totalBatches = 0;
    int defaultBatchSize = 6;

    public void group()
    {
        for(Player p: playerList)
        {
            numOfUsersActive = numOfUsersActive + 1;
            PlayerLevel = p.getPlayerLevel();
            Players = p.getPlayerId();
            if(PlayerLevel == 1)
            {
                expert.add(p);
            }
            else if (PlayerLevel == 2)
            {
                intermediate.add(p);
            }
            else
            {
                beginner.add(p);
            }
        }
    }
    public void formSubTournamentGroups()
    {
        totalBatches = numOfUsersActive / defaultBatchSize;
        ArrayList<Player> listOfAllBatches = new ArrayList();

        for (int i = 0; i < totalBatches; i++) {
            ArrayList<Player> tempList = new ArrayList();
            while (tempList.size() < defaultBatchSize) {
                if (expert.size() > 0 && tempList.size() <= 6) {
                    tempList.add(expert.get(0));
                    expert.remove(0);
                }

                if (intermediate.size() > 0 && tempList.size() <= 6) {
                    tempList.add(intermediate.get(0));
                    intermediate.remove(0);
                }

                if (beginner.size() > 0 && tempList.size() <= 6) {
                    tempList.add(beginner.get(0));
                    beginner.remove(0);
                }
            }
            listOfAllBatches = tempList;
            Tournament invokeTournament = new Tournament(listOfAllBatches);
        }
    }
}


