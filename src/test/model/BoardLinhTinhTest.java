package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardLinhTinhTest {
    BoardLinhTinh test;
    @BeforeEach
    void runBefore(){
        test = new BoardLinhTinh();
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
        assertEquals(ShapeLinhTinh.Tetrominoe.NoShape,test.shapeAt(0,0));
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

    @Test
    void testGetCurPiece(){
        assertEquals(ShapeLinhTinh.Tetrominoe.NoShape,test.getCurPiece());
    }

    @Test
    void testPause(){
        test.pause();
        assertTrue(test.isPaused());
    }

    @Test
    void testIsFullLine(){
        assertFalse(test.isFullLine(2));
        assertFalse(test.isFullLine(3));
    }

    @Test
    void testRemoveFullLine(){
        test.removeFullLines();
        assertEquals(0,test.getNumLinesRemoved());
    }
}
