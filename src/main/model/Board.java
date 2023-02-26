package model;

import static model.Shape.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class Board {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 22;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private boolean isGameFinished = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private Shape curPiece;
    private Tetrominoe[] board;

    public Board() {
        start();
    }

    // EFFECT: return the coordinate of the shape at column x, row y ???
    private Tetrominoe shapeAt(int x, int y) {
        return board[(y * BOARD_WIDTH) + x];
    }

    // EFFECT: start the tetris game.
    public void start() {
        curPiece = new Shape();
        board = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        clearBoard();
        newPiece();
    }

    // MODIFIES: this
    // EFFECT: pause the game
    public void pause() {
        isPaused = !isPaused;
        if (isPaused) {
            System.out.println("Game paused");
        } else {
            System.out.println("Number of lines removed: " + numLinesRemoved);
        }
    }

    // MODIFIES: this
    // EFFECT: drop the current piece down.
    private void dropDown() {
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1)) {
                break;
            }
            newY--;
        }
        pieceDropped();
    }

    // EFFECT: move the falling piece down one line until it is fully dropped.
    private void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1)) {
            pieceDropped();
        }
    }

    private void clearBoard() {
        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {
            board[i] = Tetrominoe.NoShape;
        }
    }

    // EFFECT: put the falling piece into the board array, then remove the lines if
    // possible and finally add a new piece after finished falling.
    private void pieceDropped() {
        for (int i = 0; i < 4; i++) {
            int x = curX + curPiece.coordX(i);
            int y = curY - curPiece.coordY(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.getShape();
        }
        removeFullLines();
        if (!isFallingFinished) {
            newPiece();
        }
    }

    // EFFECT: add a new Tetrominoe to the game.
    private void newPiece() {
        curPiece.setRandomShape();
        int m = curPiece.coordY(0);
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, curPiece.coordY(i));
        }
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + m;
        if (!tryMove(curPiece, curX, curY)) {
            curPiece.setShape(Tetrominoe.NoShape);
            isGameFinished = true;
            update();
        }
    }

    // EFFECT: returns false if it has reached the board boundaries, or it
    // is adjacent to the already fallen Tetris pieces.
    private boolean tryMove(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.coordX(i);
            int y = newY - newPiece.coordY(i);
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
                return false;
            }
            if (shapeAt(x, y) != Tetrominoe.NoShape) {
                return false;
            }
        }
        curPiece = newPiece;
        curX = newX;
        curY = newY;
        return true;
    }

    // EFFECT: return true if the line i is fully fulfilled.
    private boolean isFullLine(int i) {
        for (int j = 0; j < BOARD_WIDTH; j++) {
            if (shapeAt(j, i) == Tetrominoe.NoShape) {
                return false;
            }
        }
        return true;
    }

    // EFFECT: remove the line and increase the counter by 1 if it is full.
    private void removeFullLines() {
        int numFullLines = 0;
        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
            if (isFullLine(i)) {
                numFullLines++;
                for (int k = i; k < BOARD_HEIGHT - 1; k++) {
                    for (int j = 0; j < BOARD_WIDTH; j++) {
                        board[(k * BOARD_WIDTH) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            System.out.print(numLinesRemoved);
            isFallingFinished = true;
            curPiece.setShape(Tetrominoe.NoShape);
        }
    }


    private void doGameCycle() {
        update();
    }

    // EFFECT: return the next state of the game.
    public void update() {
        if (isGameFinished) {
            System.out.println("Game over. Your score is " + numLinesRemoved);
            return;
        } else if (isPaused) {
            return;
        } else if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    public void keyPressed(String cmd) {
        switch (cmd) {
            case "p":
                pause();
                break;
            case "a":
                tryMove(curPiece, curX - 1, curY);
                break;
            case "d":
                tryMove(curPiece, curX + 1, curY);
                break;
            case "s":
                tryMove(curPiece.rotateRight(), curX, curY);
                break;
            case "w":
                tryMove(curPiece.rotateLeft(), curX, curY);
                break;
            case " ":
                dropDown();
                break;
            case "l":
                oneLineDown();
                break;
        }
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }
}
