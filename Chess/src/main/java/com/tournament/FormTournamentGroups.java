package com.tournament;

import com.tournament.model.UsersList;

import java.util.ArrayList;
import java.util.List;

class FormTournamentGroups
{
    List expert = new ArrayList();
    List intermediate = new ArrayList();
    List beginner = new ArrayList();

    List<UsersList> userList = null;

    int numOfUsersActive = 0;
    String PlayerLevel = null;
    String Players = null;
    int totalBatches = 0;
    int defaultBatchSize = 6;

    public void group()
    {
        for(UsersList u: userList)
        {
            numOfUsersActive = numOfUsersActive + 1;
            PlayerLevel = u.getPlayerLevel();
            Players = u.getUserId();
            if(PlayerLevel.equals("1"))
            {
                expert = expertPlayers(PlayerLevel,Players);
            }
            else if (PlayerLevel.equals("2"))
            {
                intermediate = intermediatePlayers(PlayerLevel,Players);
            }
            else
            {
                beginner = beginnerPlayers(PlayerLevel,Players);
            }
        }
    }

    public List expertPlayers(String PlayerLevel, String Players) //Forming List of Expert Players
    {
        expert.add(Players);
        return expert;
    }

    public List intermediatePlayers(String PlayerLevel, String Players) //Forming List of Intermediate Players
    {
        intermediate.add(Players);
        return intermediate;
    }

    public List beginnerPlayers(String PlayerLevel, String Players) //Forming List of Beginner Players
    {
        beginner.add(Players);
        return beginner;
    }


    public ArrayList<Player> formSubTournamentGroups()
    {
        totalBatches = numOfUsersActive/defaultBatchSize;
        ArrayList<Player> listOfAllBatches = new ArrayList();

        for (int i=0 ; i < totalBatches; i++)
        {
            ArrayList tempList = new ArrayList();
            while(tempList.size() < defaultBatchSize)
            {
                if (expert.size() > 0 && tempList.size() <= 6)
                {
                    tempList.add(expert.get(0));
                    expert.remove(0);
                }

                if (intermediate.size() > 0 && tempList.size() <= 6)
                {
                    tempList.add(intermediate.get(0));
                    intermediate.remove(0);
                }

                if (beginner.size() > 0 && tempList.size() <= 6)
                {
                    tempList.add(beginner.get(0));
                    beginner.remove(0);
                }
            }
            listOfAllBatches =  tempList;
        }
        return listOfAllBatches; //Returns the grouped Batch object
    }

}


