package com.tournament.persistence.interfaces;

import com.tournament.Player;
import com.tournament.model.LeaderBoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ILeaderBoardPersistence {
    List<Player> getLeaderboard(int tournamentId);

}
