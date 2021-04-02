package com.tournament;

import com.tournament.persistence.PlayerPersistence;

import java.util.ArrayList;
import java.util.List;

public class StartTournament
{
    public void initialise()
    {
        PlayerPersistence PlayerPersistenceObj = new PlayerPersistence();
        ArrayList<Player> playerList = PlayerPersistenceObj.loadAllPlayers();

        FormTournamentGroups groupobj = new FormTournamentGroups();
        groupobj.groupLevels(playerList);
        List<Tournament> tournamentList = groupobj.formSubTournamentGroups();
    }
}

