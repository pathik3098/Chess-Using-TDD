package com.tournament.dao;

import com.tournament.model.Matches;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchRepository implements IMatchRepository {

    JdbcTemplate db;

    public MatchRepository(JdbcTemplate db) {
        this.db = db;
    }

    private String Q_SAVE = "INSERT into matches (player1id,player1Name,player2id,player2Name,startTime,endTime,tournamentId) value (?,?,?,?,?,?,?)";
    private String Q_GETALL = "SELECT * from matches";
    private String Q_UPDATE = "UPDATE matches SET matchId=?,player1id=?,player1Name=?,player2id=?,player2Name=?,startTime=?,endTime=?,tournamentId=?,result=? where matchId=?";
    private String Q_DELETE = "DELETE From matches where matchId=?";

    @Override
    public void saveMatch(Matches matches) {
        this.db.update(Q_SAVE, matches.getPlayer1id(), matches.getPlayer1Name(), matches.getPlayer2id(), matches.getPlayer2Name(), matches.getStartTime(), matches.getEndTime(), matches.getTournamentId());
    }

    @Override
    public List<Matches> getAllMatch() {
        System.out.println(Q_GETALL);
        return this.db.query(Q_GETALL, new BeanPropertyRowMapper<>(Matches.class));
    }

    //    @Override
    public Integer getAllMatchCount() {
        System.out.println(Q_GETALL);
        List<Matches> temp = this.db.query(Q_GETALL, new BeanPropertyRowMapper<>(Matches.class));
        return temp.size();
    }

    @Override
    public void updateMatch(Matches matches, int matchId) {
        this.db.update(Q_UPDATE, matches.getPlayer1id(), matches.getPlayer1Name(), matches.getPlayer2id(), matches.getPlayer2Name(), matches.getStartTime(), matches.getEndTime(), matches.getTournamentId(), matches.getResult(), matchId);
    }

    @Override
    public void deleteMatch(int matchId) {
        this.db.update(Q_DELETE, matchId);
    }

}
