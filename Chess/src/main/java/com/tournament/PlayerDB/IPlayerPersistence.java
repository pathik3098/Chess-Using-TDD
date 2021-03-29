package com.tournament.PlayerDB;

import com.tournament.Player;

public interface IPlayerPersistence {
    public void savePlayer();
    public void loadPlayer(int playerId, Player player);
}
