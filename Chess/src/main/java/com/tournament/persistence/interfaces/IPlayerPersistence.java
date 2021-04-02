package com.tournament.persistence.interfaces;

import com.tournament.Player;

import java.util.ArrayList;

public interface IPlayerPersistence {
    public void savePlayer(Player player);
    public ArrayList<Player> loadAllPlayers();
    public void saveAllPlayers(ArrayList<Player> playerList);
}
