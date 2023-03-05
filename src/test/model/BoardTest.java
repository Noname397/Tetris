package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest extends Board{
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
    void testDropDownZShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.ZShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testDropDownSShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testDropDownLineShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.getCurPiece().rotateLeft();
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }
    @Test
    void testDropDownTShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.TShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.TShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testDropDownSquareShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        boardTest = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testDropDownLShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        test.printOutBoard();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testDropDownMirroredLShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.MirroredLShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
//        test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };

        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.MirroredLShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        boardTest = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }


    @Test
    void testOneLineDown(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.MirroredLShape);
        test.setCurX(10);
        test.oneLineDown();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        };

        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test


    private boolean compareBoard(int boardA[][], int boardB[][]){
        int boardWidth = test.getBoardWidth();
        int boardHeight = test.getBoardHeight();
        for (int i = 0;i < boardHeight;++i) {
            for (int j = 0;j < boardWidth;++j){
                if (boardA[i][j] != boardB[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }


}
