package com.tournamenttest;

import com.tournament.model.Player;
import com.tournament.persistence.interfaces.IPlayerPersistence;

import java.util.ArrayList;
import java.util.List;

public class PlayerDBMock implements IPlayerPersistence {
    private String playerName;
    private int playerId;


    @Override
    public void savePlayer(Player player) {

    }

    @Override
    public ArrayList<Player> loadAllPlayers()
    {
        ArrayList<Player> playerList = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPlayerName("pathik");
        player2.setPlayerName("darshil");
        playerList.add(player1);
        playerList.add(player2);
        return playerList;
    }

    @Override
    public void saveAllPlayers(ArrayList<Player> playerList) {

    }

    @Override
    public List<Player> getLeaderboard(int tournamentId) {
        return null;
    }
}
