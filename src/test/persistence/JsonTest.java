package persistence;

import model.Player;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlayer(String name, int score, Player p){
        assertEquals(name,p.getName());
        assertEquals(score,p.getScore());
    }
}
