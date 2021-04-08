package com.tournament.persistence.interfaces;


import com.tournament.Player;

public interface ITournamentPersistence {
    public void loadPlayer(Player player, int tournamentid);
}
