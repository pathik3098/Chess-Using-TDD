import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tournament.Match;
import tournament.Player;
import playerDB.PlayerDatabase;

public class MatchTest {

    @Test
    void matchPlayedTest() {
        PlayerDatabase db = new PlayerDatabase();
        Player player1 = new Player(1, db);
        Player player2 = new Player(2,db);
        Match match = new Match(player1,player2);
        Assertions.assertEquals(true, match.getResult());
    }

}
