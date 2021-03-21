import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tournament.Match;

public class MatchTest {

    @Test
    void RandomColorTest() {
        Match match = new Match("61565315", "161513511531");
        Assertions.assertEquals("white", match.getPlayer1Color());
    }

}
