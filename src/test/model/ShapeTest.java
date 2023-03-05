package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
    Shape test;
    // assume that int[][] at pos 0 is the original state, pos 1 is rotating right 1 times, 2 is 2 times, 3 is 3 times
    public int [][][] rotationNoShape = {
            {{0,0,0},{0,0,0}},
            {{0,0},{0,0},{0,0}}
    };
    public int [][][] rotationZShape = {
            {{1,1,0},{0,1,1}},
            {{0,1},{1,1},{1,0}},
            {{1,1,0},{0,1,1}},
            {{0,1},{1,1},{1,0}},
    };
    public int[][][] rotationSShape = {
            {{0,1,1},{1,1,0}},
            {{1,0},{1,1},{0,1}},
            {{0,1,1},{1,1,0}},
            {{1,0},{1,1},{0,1}}
    };
    public int[][][] rotationLineShape = {
            {{1,1,1,1}},
            {{1},{1},{1},{1}},
            {{1,1,1,1}},
            {{1},{1},{1},{1}}
    };
    public int[][][] rotationTShape = {
            {{0,1,0},{1,1,1}},
            {{1,0},{1,1},{1,0}},
            {{1,1,1},{0,1,0}},
            {{0,1},{1,1},{0,1}}
    };
    public int[][][] rotationSquareShape =
            {{{1,1},{1,1},{1,1}}};
    public int[][][] rotationLShape = {
            {{0,0,1},{1,1,1}},
            {{1,0},{1,0},{1,1}},
            {{1,1,1},{1,0,0}},
            {{1,1},{0,1},{0,1}}
    };
    public int[][][] rotationMirroredLShape = {
            {{1,0,0},{1,1,1}},
            {{1,1},{1,0},{1,0}},
            {{1,1,1},{0,0,1}},
            {{0,1},{0,1},{1,1}}
    };
    public int coordTest[][];

    @BeforeEach
    void runBefore(){
        test = new Shape();
    }

    @Test
    void testConstructor(){
        assertEquals(test.getPieceShape(),Tetrominoe.NoShape);
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeNoShape(){
        test.setShape(Tetrominoe.NoShape);
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeZShape(){
        test.setShape(Tetrominoe.ZShape);
        coordTest = rotationZShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeSShape(){
        test.setShape(Tetrominoe.SShape);
        coordTest = rotationSShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeLineShape(){
        test.setShape(Tetrominoe.LineShape);
        coordTest = rotationLineShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeTShape(){
        test.setShape(Tetrominoe.TShape);
        coordTest = rotationTShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeSquareShape(){
        test.setShape(Tetrominoe.SquareShape);
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeLShape(){
        test.setShape(Tetrominoe.LShape);
        coordTest = rotationLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetShapeMirroredLShape(){
        test.setShape(Tetrominoe.MirroredLShape);
        coordTest = rotationMirroredLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testSetRandomShape(){
        test.setRandomShape();
        switch (test.getPieceShape()){
            case SquareShape:
                coordTest = rotationSquareShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            case SShape:
                coordTest = rotationSShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            case LShape:
                coordTest = rotationLShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            case LineShape:
                coordTest = rotationLineShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            case ZShape:
                coordTest = rotationZShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            case TShape:
                coordTest = rotationTShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
            default:
                coordTest = rotationMirroredLShape[0];
                assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
                break;
        }
    }

    @Test
    void testRotateLeftOnceNoShape(){
        test.rotateLeft();
        coordTest = rotationNoShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesNoShape(){
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationNoShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceZShape(){
        test.setShape(Tetrominoe.ZShape);
        test.rotateLeft();
        coordTest = rotationZShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesZShape(){
        test.setShape(Tetrominoe.ZShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationZShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationZShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationZShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceSShape(){
        test.setShape(Tetrominoe.SShape);
        test.rotateLeft();
        coordTest = rotationSShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesSShape(){
        test.setShape(Tetrominoe.SShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationSShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationSShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationSShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceLineShape(){
        test.setShape(Tetrominoe.LineShape);
        test.rotateLeft();
        coordTest = rotationLineShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesLineShape(){
        test.setShape(Tetrominoe.LineShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationLineShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationLineShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationLineShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceTShape(){
        test.setShape(Tetrominoe.TShape);
        test.rotateLeft();
        coordTest = rotationTShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesTShape(){
        test.setShape(Tetrominoe.TShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationTShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationTShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationTShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceSquareShape(){
        test.setShape(Tetrominoe.SquareShape);
        test.rotateLeft();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesSquareShape(){
        test.setShape(Tetrominoe.SquareShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceLShape(){
        test.setShape(Tetrominoe.LShape);
        test.rotateLeft();
        coordTest = rotationLShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesLShape(){
        test.setShape(Tetrominoe.LShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationLShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationLShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftOnceMirroredLShape(){
        test.setShape(Tetrominoe.MirroredLShape);
        test.rotateLeft();
        coordTest = rotationMirroredLShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateLeftMultipleTimesMirroredLShape(){
        test.setShape(Tetrominoe.MirroredLShape);
        test.rotateLeft();
        test.rotateLeft();
        coordTest = rotationMirroredLShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationMirroredLShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateLeft();
        coordTest = rotationMirroredLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightNoShape(){
        test.setShape(Tetrominoe.NoShape);
        test.rotateRight();
        coordTest = rotationNoShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationNoShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationNoShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightSquareShape(){
        test.setShape(Tetrominoe.SquareShape);
        test.rotateRight();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSquareShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightZShape(){
        test.setShape(Tetrominoe.ZShape);
        test.rotateRight();
        coordTest = rotationZShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationZShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationZShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationZShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightSShape(){
        test.setShape(Tetrominoe.SShape);
        test.rotateRight();
        coordTest = rotationSShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationSShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightLineShape(){
        test.setShape(Tetrominoe.LineShape);
        test.rotateRight();
        coordTest = rotationLineShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLineShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLineShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLineShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightTShape(){
        test.setShape(Tetrominoe.TShape);
        test.rotateRight();
        coordTest = rotationTShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationTShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationTShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationTShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightLShape(){
        test.setShape(Tetrominoe.LShape);
        test.rotateRight();
        coordTest = rotationLShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testRotateRightMirroredLShape(){
        test.setShape(Tetrominoe.MirroredLShape);
        test.rotateRight();
        coordTest = rotationMirroredLShape[1];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationMirroredLShape[2];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationMirroredLShape[3];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
        test.rotateRight();
        coordTest = rotationMirroredLShape[0];
        assertTrue(compareShape(coordTest,test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testGetCoords(){
        assertTrue(compareShape(rotationNoShape[0],test.getCoords(),test.getRow(),test.getColumn()));
    }

    @Test
    void testGetPieceShape(){
        test.setShape(Tetrominoe.NoShape);
        assertEquals(Tetrominoe.NoShape,test.getPieceShape());
        test.setShape(Tetrominoe.ZShape);
        assertEquals(Tetrominoe.ZShape,test.getPieceShape());
        test.setShape(Tetrominoe.SShape);
        assertEquals(Tetrominoe.SShape,test.getPieceShape());
        test.setShape(Tetrominoe.LineShape);
        assertEquals(Tetrominoe.LineShape,test.getPieceShape());
        test.setShape(Tetrominoe.TShape);
        assertEquals(Tetrominoe.TShape,test.getPieceShape());
        test.setShape(Tetrominoe.SquareShape);
        assertEquals(Tetrominoe.SquareShape,test.getPieceShape());
        test.setShape(Tetrominoe.LShape);
        assertEquals(Tetrominoe.LShape,test.getPieceShape());
        test.setShape(Tetrominoe.MirroredLShape);
        assertEquals(Tetrominoe.MirroredLShape,test.getPieceShape());
    }

    @Test
    void testGetSize(){
        test.setShape(Tetrominoe.NoShape);
        assertEquals(3,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.ZShape);
        assertEquals(3,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.SShape);
        assertEquals(3,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.LineShape);
        assertEquals(4,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.TShape);
        assertEquals(3,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.SquareShape);
        assertEquals(2,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.LShape);
        assertEquals(3,test.getRow(),test.getColumn());
        test.setShape(Tetrominoe.MirroredLShape);
        assertEquals(3,test.getRow(),test.getColumn());
    }

//    @Test
//    void testGetAllZeroColLeft(){
//        test.setShape(Tetrominoe.NoShape);
//        assertEquals(3,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.ZShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.LShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.MirroredLShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.SShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.SquareShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.LineShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(2,test.getAllZeroColLeft());
//        test.setShape(Tetrominoe.TShape);
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColLeft());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColLeft());
//    }
//
//    @Test
//    void testGetAllZeroColRight(){
//        test.setShape(Tetrominoe.NoShape);
//        assertEquals(3,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.ZShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.LShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.MirroredLShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.SShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.SquareShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.LineShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(2,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.setShape(Tetrominoe.TShape);
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroColRight());
//    }
//
//    @Test
//    void testGetAllZeroRowUp(){
//        test.setShape(Tetrominoe.NoShape);
//        assertEquals(3,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.ZShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.LShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.MirroredLShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.SShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.SquareShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.LineShape);
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(2,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.setShape(Tetrominoe.TShape);
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowUp());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowUp());
//    }
//
//    @Test
//    void testGetAllZeroRowDown(){
//        test.setShape(Tetrominoe.NoShape);
//        assertEquals(3,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.ZShape);
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.LShape);
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.MirroredLShape);
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.SShape);
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.SquareShape);
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.LineShape);
//        assertEquals(2,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.setShape(Tetrominoe.TShape);
//        assertEquals(1,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//        test.rotateLeft();
//        assertEquals(0,test.getAllZeroRowDown());
//    }


    private boolean compareShape(int a[][],int b[][],int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; ++j) {
                if (a[i][j]!= b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
