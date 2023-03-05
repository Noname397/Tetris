package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ShapeLinhTinhTest {
    // delete or rename this class!
    ShapeLinhTinh test;

    @BeforeEach
    void runBefore(){
        test = new ShapeLinhTinh();
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
        test.setShape(ShapeLinhTinh.Tetrominoe.NoShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.ZShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LineShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.TShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SquareShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.MirroredLShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
        assertEquals(ShapeLinhTinh.Tetrominoe.LShape,test.getShape());
    }
    @Test
    void testSetRandomShape(){
        test.setRandomShape();
        ShapeLinhTinh.Tetrominoe s = test.getShape();
        int pos = s.ordinal();
        assertTrue(0 <= pos && pos <= 7);
    }

    @Test
    void testRotateLeftOnceNoShape(){
        test.setShape(ShapeLinhTinh.Tetrominoe.NoShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.ZShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LineShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.TShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SquareShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.MirroredLShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.NoShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.ZShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LineShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.TShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SquareShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.MirroredLShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.NoShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.ZShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LineShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.TShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SquareShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.MirroredLShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.NoShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.ZShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LineShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.TShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.SquareShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.LShape);
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
        test.setShape(ShapeLinhTinh.Tetrominoe.MirroredLShape);
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