import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import playerDB.PlayerDBMock;
import tournament.*;

public class PlayerTest {

    @Test
    public void setAlliance()
    {
        PlayerDBMock db = new PlayerDBMock();
        Player p = new Player(1,db);
        p.setAlliance(Alliance.WHITE);
        Assertions.assertEquals(Alliance.WHITE,p.getAlliance());
        Assertions.assertEquals("pathik",p.getPlayerName());
        Assertions.assertEquals(2,p.getPlayerPoints());

    }
}
