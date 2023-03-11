package persistence;

import model.Player;
import model.PlayersList;
import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PlayersList pl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlayersList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlayersList.json");
        try {
            PlayersList pl = reader.read();
            assertEquals(0, pl.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlayersList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlayersList.json");
        try {
            PlayersList pl = reader.read();
//            assertEquals("My work room", wr.getName());
//            List<Thingy> thingies = wr.getThingies();
//            assertEquals(2, thingies.size());
            assertEquals(2,pl.length());
            //checkThingy("needle", Category.STITCHING, thingies.get(0));
            //checkThingy("saw", Category.WOODWORK, thingies.get(1));
            try {
                checkPlayer("A",0,pl.index(0));
            } catch (OutOfBoundException e) {
                fail("Exception should not have been thrown");
            } catch (EmptyListException e) {
                fail("Exception should not have been thrown");
            }
            try {
                checkPlayer("B",0,pl.index(1));
            } catch (OutOfBoundException e) {
                fail("Exception should not have been thrown");
            } catch (EmptyListException e) {
                fail("Exception should not have been thrown");
            }
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
