package com.tournament.model;
import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import java.util.ArrayList;

public class StartTournament
{
    public void initialise()
    {
        IPlayerPersistence PlayerPersistenceobj = new PlayerPersistence();
        ArrayList<Player> playerList = PlayerPersistenceobj.loadAllPlayers();
        PlayerPersistenceobj.saveAllPlayers(playerList);
        PlayerPersistenceobj.saveAllPlayers(playerList);

        FormTournamentGroups groupobj = new FormTournamentGroups();
        ArrayList<ArrayList> tournamentList = groupobj.formSubTournamentGroups(playerList);
        
        for(int i=0 ;i<tournamentList.size();i++)
        {
            Tournament invokeTournament = new Tournament(tournamentList.get(i));
            invokeTournament.organizingTournament(tournamentList.get(i));
        }
    }
}

