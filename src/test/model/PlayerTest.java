package model;

import model.exceptions.EmptyNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
