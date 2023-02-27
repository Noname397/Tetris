package model;

import static model.Shape.*;

public class Board {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 12;

    private boolean isFallingFinished;
    private boolean isPaused;
    private boolean isGameFinished;
    private int numLinesRemoved;
    private int curX;
    private int curY;
    private Shape curPiece;
    private Tetrominoe[] board;

    public Board() {
        // start();
        isFallingFinished = false;
        isPaused = false;
        isGameFinished = false;
        numLinesRemoved = 0;
        curX = 0;
        curY = 0;
    }

    // EFFECTS: return the coordinate of the shape at column x, row y
    public Tetrominoe shapeAt(int x, int y) {
        return board[(y * BOARD_WIDTH) + x];
    }

    // EFFECTS: start the tetris game.
    public void start() {
        curPiece = new Shape();
        board = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        clearBoard();
        newPiece();
    }

    // MODIFIES: this
    // EFFECTS: pause the game
    public void pause() {
        isPaused = !isPaused;
        if (isPaused) {
            System.out.println("Game paused");
        } else {
            System.out.println("Number of lines removed: " + numLinesRemoved);
        }
    }

    // MODIFIES: this
    // EFFECTS: drop the current piece down and return the y-position of the current shape.
    public int dropDown() {
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1)) {
                break;
            }
            newY--;
        }
        pieceDropped();
        return newY;
    }

    // EFFECTS: move the falling piece down one line until it is fully dropped.
    public void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1)) {
            pieceDropped();
        }
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {
            board[i] = Tetrominoe.NoShape;
        }
    }

    // EFFECTS: put the falling piece into the board array, then remove the lines if
    // possible and finally add a new piece after finished falling.
    public void pieceDropped() {
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

    // EFFECTS: add a new Tetrominoe to the game.
    public void newPiece() {
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

    // EFFECTS: returns false if it has reached the board boundaries, or it
    // is adjacent to the already fallen Tetris pieces.
    public boolean tryMove(Shape newPiece, int newX, int newY) {
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

    // EFFECTS: return true if the line i is fully fulfilled.
    public boolean isFullLine(int i) {
        for (int j = 0; j < BOARD_WIDTH; j++) {
            if (shapeAt(j, i) == Tetrominoe.NoShape) {
                return false;
            }
        }
        return true;
    }

    // EFFECTS: remove the line and increase the counter by 1 if it is full.
    public void removeFullLines() {
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

    // EFFECTS: return the next state of the game.
    public void update() {
        if (isGameFinished) {
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

    public boolean isFallingFinished() {
        return isFallingFinished;
    }

    public int getNumLinesRemoved() {
        return numLinesRemoved;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public int getCurX() {
        return curX;
    }

    public int getCurY() {
        return curY;
    }
}
