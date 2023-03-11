package model;

import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayersListTest {
    PlayersList test;
    @BeforeEach
    void runBefore(){
        test = new PlayersList();
    }

    @Test
    void testConstructor(){

    }

    @Test
    void testAddPlayerOnce() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        assertEquals(1,test.length());
        assertEquals("A",test.index(0).getName());
    }

    @Test
    void testAddPlayerMultipleTimes() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        test.addPlayer(new Player("B"));
        test.addPlayer(new Player("C"));
        assertEquals(3,test.length());
        assertEquals("A",test.index(0).getName());
        assertEquals("B",test.index(1).getName());
        assertEquals("C",test.index(2).getName());
    }

    @Test
    void testRemovePlayerOnce() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        test.addPlayer(new Player("B"));
        test.addPlayer(new Player("C"));
        test.removePlayer(1);
        assertEquals(2,test.length());
        assertEquals("A",test.index(0).getName());
        assertEquals("C",test.index(1).getName());
    }

    @Test
    void testRemovePlayerMultipleTimes() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        test.addPlayer(new Player("B"));
        test.addPlayer(new Player("C"));
        test.removePlayer(1);
        assertEquals(2,test.length());
        assertEquals("A",test.index(0).getName());
        assertEquals("C",test.index(1).getName());
        test.removePlayer(0);
        assertEquals(1,test.length());
        assertEquals("C",test.index(0).getName());
    }

    @Test
    void testRemovePlayerEmptyList() throws EmptyNameException, OutOfBoundException, EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            test.removePlayer(1);
        });
        assertThrows(EmptyListException.class, () -> {
            test.removePlayer(0);
        });
    }

    @Test
    void testRemovePlayerOutOfBound() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        assertThrows(OutOfBoundException.class, () -> {
            test.removePlayer(-1);
        });
        assertThrows(OutOfBoundException.class, () -> {
            test.removePlayer(100);
        });
    }

    @Test
    void testLength() throws EmptyNameException {
        assertEquals(0,test.length());
        test.addPlayer(new Player("A"));
        assertEquals(1,test.length());
        test.addPlayer(new Player("B"));
        assertEquals(2,test.length());
        test.addPlayer(new Player("C"));
        assertEquals(3,test.length());
    }

    @Test
    void testIndexNoException() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        test.addPlayer(new Player("B"));
        test.addPlayer(new Player("C"));
        assertEquals("A",test.index(0).getName());
        assertEquals("B",test.index(1).getName());
        assertEquals("C",test.index(2).getName());
    }

    @Test
    void testIndexEmptyList() throws EmptyNameException, OutOfBoundException, EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            test.index(0);
        });
    }

    @Test
    void testIndexOutOfBound() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        assertThrows(OutOfBoundException.class, () -> {
            test.index(-1);
        });
        assertThrows(OutOfBoundException.class, () -> {
            test.index(100);
        });
    }

    @Test
    void testToJson(){
        try {
            test.addPlayer(new Player("A"));
        } catch (EmptyNameException e) {
            fail("Unexpected exception");
        }
        try {
            test.addPlayer(new Player("A"));
        } catch (EmptyNameException e) {
            fail("Unexpected exception");
        }
        JSONObject check = test.toJson();
        JSONArray jsonArray = check.getJSONArray("PlayersList");
        for (int i = 0; i < 2;++i){
            String name = jsonArray.getJSONObject(i).getString("name");
            int score = jsonArray.getJSONObject(i).getInt("score");
            assertEquals(0,score);
            assertEquals("A",name);
        }
    }
}
