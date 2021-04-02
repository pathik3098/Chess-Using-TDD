package com.tournament.authentication;

import com.tournament.FormTournamentGroups;
import com.tournament.Player;
import com.tournament.PlayerDB.PlayerDB;
import com.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class FormGroup
{
    public void initialise()
    {
        PlayerDB playerDBObj = new PlayerDB();
        ArrayList<Player> playerList = playerDBObj.loadAllPlayers();

        FormTournamentGroups groupobj = new FormTournamentGroups();
        groupobj.groupLevels(playerList);
        List<Tournament> tournamentList = groupobj.formSubTournamentGroups();
    }
}
