package model;

import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    Player test;
    @BeforeEach
    void runBefore() throws EmptyNameException {
        test = new Player("A");
    }

    @Test
    void testConstructor(){
        assertEquals("A",test.getName());
    }

    @Test
    void testConstructorEmptyName() throws EmptyNameException{
        assertThrows(EmptyNameException.class, () -> {
            test = new Player("");
        });
    }

    @Test
    void testGetScore(){
        assertEquals(0,test.getScore());
    }

    @Test
    void testGetName(){
        assertEquals("A",test.getName());
    }
}
