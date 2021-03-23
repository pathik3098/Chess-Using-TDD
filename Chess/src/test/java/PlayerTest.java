import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tournament.Alliance;
import tournament.Player;
import playerDB.PlayerDatabase;

public class PlayerTest {

    @Test
    public void setAlliance()
    {
        PlayerDatabase db = new PlayerDatabase();
        Player p = new Player(1,db);
        p.setAlliance(Alliance.WHITE);
        Assertions.assertEquals(Alliance.WHITE,p.getAlliance());

    }
}
