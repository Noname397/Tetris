package model;

import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testIndex() throws EmptyNameException, OutOfBoundException, EmptyListException {
        test.addPlayer(new Player("A"));
        test.addPlayer(new Player("B"));
        test.addPlayer(new Player("C"));
        assertEquals("A",test.index(0).getName());
        assertEquals("B",test.index(1).getName());
        assertEquals("C",test.index(2).getName());
    }

    @Test
    void testPrintOut(){

    }

}
