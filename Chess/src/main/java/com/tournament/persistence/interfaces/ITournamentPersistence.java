package com.tournament.persistence.interfaces;


import com.tournament.Player;

public interface ITournamentPersistence {
    public Integer loadPlayer(Player player, int tournamentid);
}
