package com.tournamenttest;

import java.util.ArrayList;
import java.util.List;

import com.tournament.FormTournamentGroups;
import com.tournament.Player;
import com.tournament.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormTournamentGroupsTest
{
    private FormTournamentGroups formTournamentGroup;
    int numOfUsersActive = 0;
    int PlayerLevel = 0;
    int Players = 0;
    int totalBatches = 0;
    int defaultBatchSize = 6;

    @Test
    public void groupLevelsTest()
    {
        formTournamentGroup = new FormTournamentGroups();
        Player player = new Player();
        ArrayList<Player> Playerlist = new ArrayList<>();
        Playerlist.add(new Player("Sravani"));
        Playerlist.add(new Player("Aparna"));
        Playerlist.add(new Player("Darshil"));
        Playerlist.add(new Player("Pathik"));
        Playerlist.add(new Player("Kethan"));
        Playerlist.add(new Player("Rob"));
        Playerlist.add(new Player("hendry"));
        int i = 5;
        for (Player p : Playerlist) {
            numOfUsersActive = numOfUsersActive + 1;
            p.setPlayerLevel(i%3 + 1);
            p.setPlayerId(10 + i);
            i = i + 1;
        }
        FormTournamentGroups formTournamentGroups = new FormTournamentGroups();
        formTournamentGroups.groupLevels(Playerlist);
        Assertions.assertEquals(2,formTournamentGroups.getExpert().size());
    }

    @Test
    public void formSubTournamentGroupsTest()
    {
        FormTournamentGroups formTournamentGroups = new FormTournamentGroups();

        ArrayList<Player> expertPlayerlist = new ArrayList<>();
        expertPlayerlist.add(new Player("Kethan"));
        expertPlayerlist.add(new Player("Rob"));
        expertPlayerlist.add(new Player("Pathik"));

        ArrayList<Player> intermediatePlayerlist = new ArrayList<>();
        intermediatePlayerlist.add(new Player("Sravani"));
        intermediatePlayerlist.add(new Player("Aparna"));
        intermediatePlayerlist.add(new Player("Sergiton"));

        ArrayList<Player> beginnerPlayerList = new ArrayList<>();
        beginnerPlayerList.add(new Player("Darshil"));
        beginnerPlayerList.add(new Player("Hendry"));
        beginnerPlayerList.add(new Player("William"));


        formTournamentGroups.getExpert().size();
        formTournamentGroups.getIntermediate().size();
        formTournamentGroups.getBeginner().size();

        totalBatches = numOfUsersActive / defaultBatchSize;


        ArrayList<Player> batchList = new ArrayList<>();
        batchList.add(new Player("Sravani"));
        batchList.add(new Player("Sravani"));
        batchList.add(new Player("Sravani"));
        batchList.add(new Player("Sravani"));
        batchList.add(new Player("Sravani"));
        batchList.add(new Player("Sravani"));

        Tournament obj = new Tournament(new ArrayList<>());
        //Assertions.assertEquals();


    }
}
