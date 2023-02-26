package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ShapeTest {
    // delete or rename this class!
    Shape test;

    @BeforeEach
    void runBefore(){
        test = new Shape();
    }

    @Test
    void testConstructor(){
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testSetShapeNoShape(){
        test.setShape(Shape.Tetrominoe.NoShape);
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testSetShapeZShape(){
        test.setShape(Shape.Tetrominoe.ZShape);
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testSetShapeSShape(){
        test.setShape(Shape.Tetrominoe.SShape);
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testSetShapeLineShape(){
        test.setShape(Shape.Tetrominoe.LineShape);
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(2,test.coordY(3));
    }

    @Test
    void testSetShapeTShape(){
        test.setShape(Shape.Tetrominoe.TShape);
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testSetShapeSquareShape(){
        test.setShape(Shape.Tetrominoe.SquareShape);
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testSetShapeLShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        assertEquals(-1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testSetShapeMirroredLShape(){
        test.setShape(Shape.Tetrominoe.MirroredLShape);
        assertEquals(1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testGetShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        assertEquals(Shape.Tetrominoe.LShape,test.getShape());
    }
    @Test
    void testSetRandomShape(){
        test.setRandomShape();
        Shape.Tetrominoe s = test.getShape();
        int pos = s.ordinal();
        assertTrue(0 <= pos && pos <= 7);
    }

    @Test
    void testRotateLeftOnceNoShape(){
        test.setShape(Shape.Tetrominoe.NoShape);
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftOnceZShape(){
        test.setShape(Shape.Tetrominoe.ZShape);
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftSShape(){
        test.setShape(Shape.Tetrominoe.SShape);
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
    }

    @Test
    void testRotateLeftLineShape(){
        test.setShape(Shape.Tetrominoe.LineShape);
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(2,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftTShape(){
        test.setShape(Shape.Tetrominoe.TShape);
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftSquareShape(){
        test.setShape(Shape.Tetrominoe.SquareShape);
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftLShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(-1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftMirroredLShape(){
        test.setShape(Shape.Tetrominoe.MirroredLShape);
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(-1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesNoShape(){
        test.setShape(Shape.Tetrominoe.NoShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesZShape(){
        test.setShape(Shape.Tetrominoe.ZShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesSShape(){
        test.setShape(Shape.Tetrominoe.SShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesLineShape(){
        test.setShape(Shape.Tetrominoe.LineShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-2,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-2,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(2,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesTShape(){
        test.setShape(Shape.Tetrominoe.TShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesSquareShape(){
        test.setShape(Shape.Tetrominoe.SquareShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateLeft();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesLShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateLeftMultipleTimesMirroredLShape(){
        test.setShape(Shape.Tetrominoe.MirroredLShape);
        test.rotateLeft();
        test.rotateLeft();
        assertEquals(-1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateLeft();
        assertEquals(1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }
    @Test
    void testRotateRightNoShape(){
        test.setShape(Shape.Tetrominoe.NoShape);
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightOnceZShape(){
        test.setShape(Shape.Tetrominoe.ZShape);
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
    }

    @Test
    void testRotateRightSShape(){
        test.setShape(Shape.Tetrominoe.SShape);
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightLineShape(){
        test.setShape(Shape.Tetrominoe.LineShape);
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-2,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightTShape(){
        test.setShape(Shape.Tetrominoe.TShape);
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightSquareShape(){
        test.setShape(Shape.Tetrominoe.SquareShape);
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightLShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightMirroredLShape(){
        test.setShape(Shape.Tetrominoe.MirroredLShape);
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesNoShape(){
        test.setShape(Shape.Tetrominoe.NoShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(0,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesZShape(){
        test.setShape(Shape.Tetrominoe.ZShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesSShape(){
        test.setShape(Shape.Tetrominoe.SShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(-1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesLineShape(){
        test.setShape(Shape.Tetrominoe.LineShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-2,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(2,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(2,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesTShape(){
        test.setShape(Shape.Tetrominoe.TShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(-1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(-1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(1,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesSquareShape(){
        test.setShape(Shape.Tetrominoe.SquareShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
        test.rotateRight();
        assertEquals(0,test.coordX(0));
        assertEquals(0,test.coordY(0));
        assertEquals(1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(1,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesLShape(){
        test.setShape(Shape.Tetrominoe.LShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(-1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }

    @Test
    void testRotateRightMultipleTimesMirroredLShape(){
        test.setShape(Shape.Tetrominoe.MirroredLShape);
        test.rotateRight();
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(-1,test.coordY(3));
        test.rotateRight();
        assertEquals(-1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(-1,test.coordX(1));
        assertEquals(0,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(1,test.coordX(3));
        assertEquals(0,test.coordY(3));
        test.rotateRight();
        assertEquals(1,test.coordX(0));
        assertEquals(-1,test.coordY(0));
        assertEquals(0,test.coordX(1));
        assertEquals(-1,test.coordY(1));
        assertEquals(0,test.coordX(2));
        assertEquals(0,test.coordY(2));
        assertEquals(0,test.coordX(3));
        assertEquals(1,test.coordY(3));
    }
}