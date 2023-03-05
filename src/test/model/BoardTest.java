package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board test;
    Shape shape;

    @BeforeEach
    void runBefore(){
        test = new Board();
        shape = new Shape();
    }

    @Test
    void testTryMoveZShape(){
        shape.setShape(Tetrominoe.ZShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,11,6));
        assertTrue(test.tryMove(shape,10,6));
        assertTrue(test.tryMove(shape,5,9));
        assertFalse(test.tryMove(shape,5,11));
        assertFalse(test.tryMove(shape,5,10));
    }

    @Test
    void testTryMoveZShapeOnceRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
    }

    @Test
    void testTryMoveZShapeTwiceRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveZShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveSShape(){
        shape.setShape(Tetrominoe.SShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,11,6));
        assertTrue(test.tryMove(shape,10,6));
        assertTrue(test.tryMove(shape,5,9));
        assertFalse(test.tryMove(shape,5,11));
        assertFalse(test.tryMove(shape,5,10));
    }

    @Test
    void testTryMoveSShapeOnceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
    }

    @Test
    void testTryMoveSShapeTwiceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveSShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveTShape(){
        shape.setShape(Tetrominoe.TShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,11,6));
        assertTrue(test.tryMove(shape,10,6));
        assertTrue(test.tryMove(shape,5,9));
        assertFalse(test.tryMove(shape,5,11));
        assertFalse(test.tryMove(shape,5,10));
    }

    @Test
    void testTryMoveTShapeOnceRotate(){
        shape.setShape(Tetrominoe.TShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
    }

    @Test
    void testTryMoveTShapeTwiceRotate(){
        shape.setShape(Tetrominoe.TShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveTShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveLShape(){
        shape.setShape(Tetrominoe.SShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,11,6));
        assertTrue(test.tryMove(shape,10,6));
        assertTrue(test.tryMove(shape,5,9));
        assertFalse(test.tryMove(shape,5,11));
        assertFalse(test.tryMove(shape,5,10));
    }

    @Test
    void testTryMoveLShapeOnceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
    }

    @Test
    void testTryMoveLShapeTwiceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveLShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveMirroredLShape(){
        shape.setShape(Tetrominoe.MirroredLShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,11,6));
        assertTrue(test.tryMove(shape,10,6));
        assertTrue(test.tryMove(shape,5,9));
        assertFalse(test.tryMove(shape,5,11));
        assertFalse(test.tryMove(shape,5,10));
    }

    @Test
    void testTryMoveMirroredLShapeOnceRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
    }

    @Test
    void testTryMoveMirroredLShapeTwiceRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveMirroredLShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveSquareShape(){
        shape.setShape(Tetrominoe.SquareShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
    }

    @Test
    void testTryMoveLineShape(){
        shape.setShape(Tetrominoe.LineShape);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertTrue(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertFalse(test.tryMove(shape,6,9));
        assertTrue(test.tryMove(shape,6,8));
    }

    @Test
    void testTryMoveLineShapeRotateOnce(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,9,0));
        assertTrue(test.tryMove(shape,8,0));
        assertTrue(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
        assertTrue(test.tryMove(shape,6,8));
    }

    @Test
    void testTryMoveLineShapeRotateTwice(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertTrue(test.tryMove(shape,11,0));
        assertTrue(test.tryMove(shape,10,0));
        assertTrue(test.tryMove(shape,9,0));
        assertTrue(test.tryMove(shape,8,0));
        assertFalse(test.tryMove(shape,6,11));
        assertFalse(test.tryMove(shape,6,10));
        assertFalse(test.tryMove(shape,6,9));
        assertTrue(test.tryMove(shape,6,8));
    }

    @Test
    void testTryMoveLineShapeRotateThreeTimes(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,11,0));
        assertFalse(test.tryMove(shape,10,0));
        assertFalse(test.tryMove(shape,9,0));
        assertTrue(test.tryMove(shape,8,0));
        assertTrue(test.tryMove(shape,6,11));
        assertTrue(test.tryMove(shape,6,10));
        assertTrue(test.tryMove(shape,6,9));
        assertTrue(test.tryMove(shape,6,8));
    }

    @Test
    void testDropDown(){
//        test.addNewPiece();
//        test.getCurPiece();
//        test.dropDown();
//        test.printOutBoard();
        shape.setShape(Tetrominoe.LShape);
        assertTrue(test.tryMove(shape,10,6));
    }
}
