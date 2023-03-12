package persistence;

import model.Player;
import model.PlayersList;
import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            PlayersList pl = new PlayersList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPlayersList() {
        try {
            PlayersList pl = new PlayersList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlayersList.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlayersList.json");
            pl = reader.read();
//            assertEquals("My work room", wr.getName());
//            assertEquals(0, wr.numThingies());
            assertEquals(0,pl.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPlayersList() {
        try {
            PlayersList pl = new PlayersList();
            try {
                pl.addPlayer(new Player("A"));
            } catch (EmptyNameException e) {
                fail("Unexpected exception");
            }
            try {
                pl.addPlayer(new Player(""));
            } catch (EmptyNameException e) {
                // all good
            }
            try {
                pl.addPlayer(new Player("B"));
            } catch (EmptyNameException e) {
                fail("Unexpected exception");
            }
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlayersList.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlayersList.json");
            pl = reader.read();
            assertEquals(2,pl.length());
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
            fail("Exception should not have been thrown");
        }
    }
}
