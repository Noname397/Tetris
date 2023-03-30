package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertFalse(test.tryMove(shape,row -1,6));
        assertTrue(test.tryMove(shape,row -2,6));
        assertTrue(test.tryMove(shape,5,col -3));
        assertFalse(test.tryMove(shape,5,col -1));
        assertFalse(test.tryMove(shape,5,col -2));
    }

    @Test
    void testTryMoveZShapeOnceRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
    }

    @Test
    void testTryMoveZShapeTwiceRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row -1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertFalse(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveZShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.ZShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveSShape(){
        shape.setShape(Tetrominoe.SShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertFalse(test.tryMove(shape,row -1,6));
        assertTrue(test.tryMove(shape,row -2,6));
        assertTrue(test.tryMove(shape,5,col - 3));
        assertFalse(test.tryMove(shape,5,col -2));
        assertFalse(test.tryMove(shape,5,col -1));
    }

    @Test
    void testTryMoveSShapeOnceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
    }

    @Test
    void testTryMoveSShapeTwiceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertFalse(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveSShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveTShape(){
        shape.setShape(Tetrominoe.TShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row -1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertFalse(test.tryMove(shape,row -1,6));
        assertTrue(test.tryMove(shape,row -2,6));
        assertTrue(test.tryMove(shape,5,col -3));
        assertFalse(test.tryMove(shape,5,col -1));
        assertFalse(test.tryMove(shape,5,col -2));
    }

    @Test
    void testTryMoveTShapeOnceRotate(){
        shape.setShape(Tetrominoe.TShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
    }

    @Test
    void testTryMoveTShapeTwiceRotate(){
        shape.setShape(Tetrominoe.TShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row -1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertFalse(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveTShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
        assertTrue(test.tryMove(shape,6,col -3));
    }

    @Test
    void testTryMoveLShape(){
        shape.setShape(Tetrominoe.SShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertFalse(test.tryMove(shape,row -1,6));
        assertTrue(test.tryMove(shape,row -2,6));
        assertTrue(test.tryMove(shape,5,col -3));
        assertFalse(test.tryMove(shape,5,col -1));
        assertFalse(test.tryMove(shape,5,col -2));
    }

    @Test
    void testTryMoveLShapeOnceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row -1,0));
        assertFalse(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row -3,0));
        assertFalse(test.tryMove(shape,6,col -1));
        assertTrue(test.tryMove(shape,6,col -2));
    }

    @Test
    void testTryMoveLShapeTwiceRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row -2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertFalse(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
    }

    @Test
    void testTryMoveLShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.SShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertFalse(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
    }

    @Test
    void testTryMoveMirroredLShape(){
        shape.setShape(Tetrominoe.MirroredLShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertFalse(test.tryMove(shape,row - 1,6));
        assertTrue(test.tryMove(shape,row - 2,6));
        assertTrue(test.tryMove(shape,5,col - 3));
        assertFalse(test.tryMove(shape,5,col - 1));
        assertFalse(test.tryMove(shape,5,col - 2));
    }

    @Test
    void testTryMoveMirroredLShapeOnceRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertFalse(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
    }

    @Test
    void testTryMoveMirroredLShapeTwiceRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertFalse(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
    }

    @Test
    void testTryMoveMirroredLShapeThreeTimesRotate(){
        shape.setShape(Tetrominoe.MirroredLShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertFalse(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
    }

    @Test
    void testTryMoveSquareShape(){
        shape.setShape(Tetrominoe.SquareShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
    }

    @Test
    void testTryMoveLineShape(){
        shape.setShape(Tetrominoe.LineShape);
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertTrue(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertFalse(test.tryMove(shape,6,col - 2));
        assertFalse(test.tryMove(shape,6,col - 3));
        assertTrue(test.tryMove(shape,6,col - 4));
    }

    @Test
    void testTryMoveLineShapeRotateOnce(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertFalse(test.tryMove(shape,row - 2,0));
        assertFalse(test.tryMove(shape,row - 3,0));
        assertTrue(test.tryMove(shape,row - 4,0));
        assertTrue(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
        assertTrue(test.tryMove(shape,6,col - 4));
    }

    @Test
    void testTryMoveLineShapeRotateTwice(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row, 0));
        assertTrue(test.tryMove(shape,row - 1,0));
        assertTrue(test.tryMove(shape,row - 2,0));
        assertTrue(test.tryMove(shape,row - 3,0));
        assertTrue(test.tryMove(shape,row - 4,0));
        assertFalse(test.tryMove(shape,6,col - 1));
        assertFalse(test.tryMove(shape,6,col - 2));
        assertFalse(test.tryMove(shape,6,col - 3));
        assertTrue(test.tryMove(shape,6,col - 4));
    }

    @Test
    void testTryMoveLineShapeRotateThreeTimes(){
        shape.setShape(Tetrominoe.LineShape);
        shape.rotateLeft();
        shape.rotateLeft();
        shape.rotateLeft();
        int row = test.getBoardHeight();
        int col = test.getBoardWidth();
        // System.out.println(col);
        assertTrue(test.tryMove(shape,0,0));
        assertFalse(test.tryMove(shape,-1,0));
        assertFalse(test.tryMove(shape,0,-1));
        assertTrue(test.tryMove(shape,6,6));
        assertFalse(test.tryMove(shape,row - 1,0));
        assertFalse(test.tryMove(shape,row - 2,0));
        assertFalse(test.tryMove(shape,row - 3,0));
        assertTrue(test.tryMove(shape,row - 4,0));
        assertFalse(test.tryMove(shape,6,col));
        assertTrue(test.tryMove(shape,6,col - 1));
        assertTrue(test.tryMove(shape,6,col - 2));
        assertTrue(test.tryMove(shape,6,col - 3));
        assertTrue(test.tryMove(shape,6,col - 4));
    }

    @Test
    void testDropDownZShapeEmptyBoard(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.ZShape);
        Tetrominoe fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0,0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0,0},
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
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
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
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.getCurPiece().rotateLeft();
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
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
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.TShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        // test.printOutBoard();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
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
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        // test.printOutBoard();
        boardTest = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
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
        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        // test.printOutBoard();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
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
//        // test.printOutBoard();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };

        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.MirroredLShape);
        fallingPiece = test.getCurPiece().getPieceShape();
        System.out.println(fallingPiece);
        test.dropDown();
        boardTest = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testOneLineDown(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.MirroredLShape);
        int aboveBottomOne = test.getBoardHeight() - 2;
        test.setCurX(aboveBottomOne);
        test.oneLineDown();
        System.out.println(test.getCurX());
        //test.printOutBoard();
        test.oneLineDown();
        System.out.println(test.getCurX());
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };
        //test.printOutBoard();
        Color shapeColor = test.getCurPiece().getColor();
        Color[][] colorTest = {
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        shapeColor, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                        shapeColor, shapeColor, shapeColor, Color.WHITE, Color.WHITE},
        };
        //printOutColor(test.getBackGroundBoard());
        assertTrue(compareColor(colorTest, test.getBackGroundBoard()));
        //printOutBoard(test.getBoard());
        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

//    @Test
//    void testDropPieceGameOver(){
//        int times = test.getBoardHeight() / 4;
//        for (int i=1;i<=times + 2;++i){
//            test.addNewPiece();
//            test.getCurPiece().setShape(Tetrominoe.LineShape);
//            test.getCurPiece().rotateLeft();
//            test.dropDown();
//        }
//        int[][] boardTest = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//        };
//        assertTrue(compareBoard(boardTest,test.getBoard()));
//        System.out.println(test.tryMove(test.getCurPiece(),test.getCurX(),test.getCurY()));
//        System.out.println(test.isGameFinished());
//        assertTrue(test.isGameFinished());
//    }

    @Test
    void testRemoveFullLineOnce(){
        for (int i=0;i<2;++i){
            test.addNewPiece();
            test.getCurPiece().setShape(Tetrominoe.LineShape);
            test.setCurY(4 * i);
            test.dropDown();
            test.removeFullLine();
        }
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        test.setCurY(8);
        test.dropDown();
        test.removeFullLine();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        };
        printOutBoard(test.getBoard());

        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testRemoveFullLineTwoLines(){
        for (int i=0;i<2;++i){
            test.addNewPiece();
            test.getCurPiece().setShape(Tetrominoe.LineShape);
            test.setCurY(4 * i);
            test.dropDown();
            test.addNewPiece();
            test.getCurPiece().setShape(Tetrominoe.LineShape);
            test.setCurY(4 * i);
            test.dropDown();
        }
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        test.setCurY(8);
        test.dropDown();
        test.removeFullLine();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        // test.printOutBoard();

        assertTrue(compareBoard(boardTest,test.getBoard()));
    }

    @Test
    void testRemoveSeveralLines(){
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        test.setCurY(0);
        test.dropDown();
        int[][] boardTest = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        // // test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LShape);
        test.setCurY(2);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
        };
        //// test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.setCurY(5);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        };
        //// test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.SquareShape);
        test.setCurY(2);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        };
        //// test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.setCurY(5);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        };
        // printOutBoard(test.getBoard());
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.setCurY(0);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        };
        //// test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));
        test.addNewPiece();
        test.getCurPiece().setShape(Tetrominoe.LineShape);
        test.getCurPiece().rotateRight();
        test.setCurY(9);
        test.dropDown();
        boardTest = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
        };
        //// test.printOutBoard();
        assertTrue(compareBoard(boardTest,test.getBoard()));

    }


    @Test
    void testIsGameFinished(){
        assertFalse(test.isGameFinished());
    }

    @Test
    void testIsFallingFinished(){
        assertTrue(test.isFallingFinished());
    }

    @Test
    void testGetCurX(){
        assertEquals(0,test.getCurX());
    }

    @Test
    void testGetCurY(){
        assertEquals(0,test.getCurY());
    }

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

    private boolean compareColor(Color A[][],Color B[][]){
        int boardWidth = test.getBoardWidth();
        int boardHeight = test.getBoardHeight();
        for (int i = 0;i < boardHeight;++i) {
            for (int j = 0;j < boardWidth;++j){
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    void testGetNumRemoved(){
        assertEquals(0,test.getNumRemoved());
    }

    @Test
    void testIsGamePaused(){
        assertFalse(test.isGamePaused());
    }

    @Test
    void testSetGameContinue(){
        test.setGameContinue();
        assertFalse(test.isGamePaused());
    }

    @Test
    void testSetGamePaused(){
        test.setGamePaused();
        assertTrue(test.isGamePaused());
    }

    @Test
    void testSetGameFinished(){
        test.setGameFinished();
        assertTrue(test.isGameFinished());
    }

    @Test
    void testGetScore(){
        assertEquals(0,test.getScore());
    }

    @Test
    void testSetFallingFinished(){
        test.setFallingFinished();
        assertFalse(test.isFallingFinished());
    }

    @Test
    void testSetNumRemoved(){
        test.setNumRemoved(2);
        assertEquals(2,test.getNumRemoved());
        test.updateScore();
        assertEquals(300,test.getScore());
        test.setNumRemoved(3);
        test.updateScore();
        assertEquals(300 + 700,test.getScore());
        assertEquals(3,test.getNumRemoved());
        test.setNumRemoved(4);
        test.updateScore();
        assertEquals(300 + 700 + 1500,test.getScore());
        assertEquals(4,test.getNumRemoved());
    }

    private void printOutColor(Color A[][]){
        int boardWidth = test.getBoardWidth();
        int boardHeight = test.getBoardHeight();
        for (int i = 0;i < boardHeight;++i) {
            for (int j = 0;j < boardWidth;++j){
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void printOutBoard(int A[][]){
        int boardWidth = test.getBoardWidth();
        int boardHeight = test.getBoardHeight();
        for (int i = 0;i < boardHeight;++i) {
            for (int j = 0;j < boardWidth;++j){
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
