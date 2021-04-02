package com.tournament;

import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;

import java.util.ArrayList;
import java.util.List;

public class StartTournament
{
    public void initialise()
    {
        IPlayerPersistence PlayerPersistenceobj = new PlayerPersistence();
        ArrayList<Player> playerList = PlayerPersistenceobj.loadAllPlayers();
        PlayerPersistenceobj.saveAllPlayers(playerList);
        FormTournamentGroups groupobj = new FormTournamentGroups();
        groupobj.groupLevels(playerList);
        List<Tournament> tournamentList = groupobj.formSubTournamentGroups();
    }
}

