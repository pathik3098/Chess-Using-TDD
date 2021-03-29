package com.tournament.PlayerDB;

import com.tournament.Player;

public class PlayerDBMock implements IPlayerPersistence {
    private String playerName;
    private int playerId;
    private int playerPoints;
    @Override
    public void savePlayer() {

    }

    @Override
    public void loadPlayer(int playerId, Player player)
    {
        player.setPlayerName("pathik");
        player.setPlayerPoints(2);
    }
}
