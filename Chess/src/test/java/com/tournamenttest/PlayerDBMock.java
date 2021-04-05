package com.tournamenttest;

import com.tournament.Player;
import com.tournament.persistence.interfaces.IPlayerPersistence;

import java.util.ArrayList;

public class PlayerDBMock implements IPlayerPersistence {
    private String playerName;
    private int playerId;
    private int playerPoints;
    @Override
    public void savePlayer(Player player) {

    }

    public void loadPlayer(int playerId, Player player)
    {
        player.setPlayerName("pathik");
        player.setPlayerPoints(2);
    }

    @Override
    public ArrayList<Player> loadAllPlayers() {
        return null;
    }

    @Override
    public void saveAllPlayers(ArrayList<Player> playerList) {

    }
}
