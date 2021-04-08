package com.tournament;

import com.tournament.persistence.TournamentPersistence;

import java.util.ArrayList;
import java.util.List;

public class FormTournamentGroups {
    private ArrayList<Player> expert;
    private ArrayList<Player> intermediate;
    private ArrayList<Player> beginner;

    private int numOfUsersActive;
    private int PlayerLevel;
    private String Players;
    private int totalBatches;
    private int defaultBatchSize;

    public FormTournamentGroups() {
        this.expert = new ArrayList<>();
        this.intermediate = new ArrayList<>();
        this.beginner = new ArrayList<>();
        numOfUsersActive = 0;
        PlayerLevel = 0;
        Players = null;
        totalBatches = 0;
        defaultBatchSize = 6;
    }

    public void groupLevels(ArrayList<Player> playerList) {
        for (Player p : playerList) {
            numOfUsersActive = numOfUsersActive + 1;
            PlayerLevel = p.getPlayerLevel();
            Players = p.getPlayerId();
            if (PlayerLevel == 1) {
                expert.add(p);
            } else if (PlayerLevel == 2) {
                intermediate.add(p);
            } else {
                beginner.add(p);
            }
        }
    }

    public List<Tournament> formSubTournamentGroups() {

        totalBatches = numOfUsersActive / defaultBatchSize;
        ArrayList<Player> listOfAllBatches = new ArrayList();
        Player winner;

        List<Tournament> tournamentList = new ArrayList<>();
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
            invokeTournament.organizingTournament(listOfAllBatches);
            tournamentList.add(invokeTournament);
        }
        return tournamentList;
    }

    public void setExpert(ArrayList<Player> expert)
    {
        this.expert = expert;
    }

    public void setIntermediate(ArrayList<Player> intermediate)
    {
        this.intermediate = intermediate;
    }

    public void setBeginner(ArrayList<Player> beginner)
    {
        this.beginner = beginner;
    }
    public ArrayList<Player> getExpert() {
        return expert;
    }
    public ArrayList<Player> getIntermediate() {
        return intermediate;
    }
    public ArrayList<Player> getBeginner() {
        return beginner;
    }

}
