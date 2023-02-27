package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board test;
    @BeforeEach
    void runBefore(){
        test = new Board();
    }

    @Test
    void testConstructor(){
       assertFalse(test.isFallingFinished());
       assertFalse(test.isPaused());
       assertFalse(test.isGameFinished());
       assertEquals(0,test.getNumLinesRemoved());
       assertEquals(0,test.getCurX());
       assertEquals(0,test.getCurY());
    }

    @Test
    void testShapeAt(){
        assertEquals(Shape.Tetrominoe.NoShape,test.shapeAt(0,0));
    }

    @Test
    void testIsFallingFinished() {
        assertFalse(test.isFallingFinished());
    }

    @Test
    void testGetNumLinesRemoved() {
        assertEquals(0,test.getNumLinesRemoved());
    }

    @Test
    void testIsPaused() {
         assertFalse(test.isPaused());
    }

    @Test
    void testGetCurX() {
        assertEquals(0,test.getCurX());
    }

    @Test
    void testGetCurY() {
        assertEquals(0,test.getCurY());
    }

}
