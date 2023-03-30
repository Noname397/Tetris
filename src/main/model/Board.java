package model;

import java.awt.*;

// Represent the board with pixels, shape, and states of the board.
public class Board {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 18;
    private boolean isFallingFinished; // state of the game whether finished falling or not
    private boolean isGameFinished;// state of the game whether ended or not
    private boolean isGamePaused; // state of the game whether paused or not
    private int numRemoved; // the number
    private int curX; // the current row position of falling piece.
    private int score;  // the current score of the board.
    private int curY;  // the current column position of falling piece.
    private Shape curPiece; // falling piece.
    private int [][] board; // coords of board.
    private Color [][] backGroundBoard; // color of the board.

    // EFFECTS: initiate the board with empty board coordinates,
    // and every state of the game is false except isFallingFinished = true
    public Board() {
        board = new int[BOARD_HEIGHT][BOARD_WIDTH];
        backGroundBoard = new Color[BOARD_HEIGHT][BOARD_WIDTH];
        curPiece = new Shape();
        isFallingFinished = true;
        isGameFinished = false;
        isGamePaused = false;
        curX = 0;
        curY = 0;
        score = 0;
        clearBoard();
    }

    // MODIFIES: this
    // EFFECTS: create a new board with every position being 0.
    public void clearBoard() {
        for (int i = 0;i < BOARD_HEIGHT;++i) {
            for (int j = 0;j < BOARD_WIDTH;++j) {
                board[i][j] = 0;
                backGroundBoard[i][j] = Color.WHITE;
            }
        }
    }


    // MODIFIES: this
    // EFFECTS: drop the shape to the furthest position down as possible.
    public void dropDown() {
        while (tryMove(curPiece, curX + 1, curY)) {
        }
        pieceDropped();
    }

    // MODIFIES: this
    // EFFECTS: drop the shape one line down.
    public void oneLineDown() {
        if (!tryMove(curPiece,curX + 1,curY)) {
            pieceDropped();
        }
    }

    // MODIFIES: this
    // EFFECTS: puts the falling piece into the board 2D array. Then remove all full lines and add a new piece.
    public void pieceDropped() {
        // set the falling piece to the correct pos
        setFallingPiece();
        removeFullLine();
        isFallingFinished = true;
    }

    // MODIFIES: this
    // EFFECTS: remove every full 1 lines in the board.
    public void removeFullLine() {
        int row = BOARD_HEIGHT;
        int col = BOARD_WIDTH;
        int[][] newBoard = new int[row][col];
        Color [][] newBackgroundBoard = new Color[row][col];
        int newRow = row - 1;

        for (int i = row - 1; i >= 0; i--) {
            if (!canRemoveLine(i)) {
                // Copy the current row to the new board
                for (int j = 0; j < col; j++) {
                    newBoard[newRow][j] = board[i][j];
                    newBackgroundBoard[newRow][j] = backGroundBoard[i][j];
                }
                newRow--;
            } else {
                ++numRemoved;
            }
        }

        // Fill the remaining rows with 0's
        while (newRow >= 0) {
            for (int j = 0; j < col; j++) {
                newBoard[newRow][j] = 0;
                newBackgroundBoard[newRow][j] = Color.WHITE;
            }
            newRow--;
        }
        board = newBoard; // Update the board
        backGroundBoard = newBackgroundBoard; // Update the background board;
        updateScore();// Update the score
    }


    // EFFECTS: return true if all values in row index is 1
    public boolean canRemoveLine(int index) {
        for (int i = 0;i < BOARD_WIDTH;++i) {
            if (board[index][i] == 0) {
                return false;
            }
        }
        return true;
    }

    // MODIFIES: this
    // EFFECTS: add a new random piece to the board. If can't add, game is over.
    public void addNewPiece() {
        numRemoved = 0;
        curPiece.setRandomShape();
        curX = 0;
        curY = BOARD_WIDTH / 2;
        if (!tryMove(curPiece,curX,curY)) {
            isGameFinished = true;
        }
    }

    // EFFECTS: return true if a piece can be placed at row newX and col newY.
    public boolean tryMove(Shape newPiece,int newX, int newY) {
        int shapeWidth = newPiece.getColumn();
        int shapeHeight = newPiece.getRow();

        // Check if the shape is out of bounds
        if (newX < 0 || newX + shapeHeight > BOARD_HEIGHT || newY < 0 || newY + shapeWidth > BOARD_WIDTH) {
            return false;
        }

        // Check if the shape overlaps with any existing blocks on the board
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                if (newPiece.getCoords()[i][j] == 1 && board[newX + i][newY + j] == 1) {
                    return false;
                }
            }
        }

        // If we get here, the shape can fit on the board
        curX = newX;
        curY = newY;
        return true;
    }

    // getter
    public Shape getCurPiece() {
        return curPiece;
    }

    // getter
    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    // getter
    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    // getter
    public int[][] getBoard() {
        return board;
    }

    // getter
    public int getCurX() {
        return curX;
    }

    // getter
    public int getCurY() {
        return curY;
    }

    // getter
    public int getNumRemoved() {
        return numRemoved;
    }

    // getter
    public boolean isGameFinished() {
        return isGameFinished;
    }

    // getter
    public boolean isFallingFinished() {
        return isFallingFinished;
    }

    // getter
    public boolean isGamePaused() {
        return isGamePaused;
    }

    // MODIFIES: this
    // EFFECTS: set the falling piece to a specific row
    public void setCurX(int curX) {
        this.curX = curX;
    }

    // MODIFIES: this
    // EFFECTS: set the falling piece to a specific col
    public void setCurY(int curY) {
        this.curY = curY;
    }

    // MODIFIES: this
    // EFFECTS: set isGamePaused to true
    public void setGamePaused() {
        isGamePaused = true;
    }

    // MODIFIES: this
    // EFFECTS: set isGamePaused to false
    public void setGameContinue() {
        isGamePaused = false;
    }

    // MODIFIES: this
    // EFFECTS: set the game to be over
    public void setGameFinished() {
        isGameFinished = true;
    }

    // MODIFIES: this
    // EFFECTS: set isFallingFinish = false;
    public void setFallingFinished() {
        isFallingFinished = false;
    }

    // EFFECTS: return the score of the board.
    public int getScore() {
        return score;
    }

    // MODIFIES: this
    // EFFECTS:  change score
    public void updateScore() {
        if (numRemoved == 1) {
            score += 100;
        } else if (numRemoved == 2) {
            score += 300;
        } else if (numRemoved == 3) {
            score += 700;
        } else if (numRemoved > 3) {
            score += 1500;
        }
    }

    // MODIFIES: this
    // EFFECTS: add current piece to the board coordinates.
    public void setFallingPiece() {
        int shapeHeight = curPiece.getRow();
        int shapeWidth = curPiece.getColumn();
        for (int i = curX; i < curX + shapeHeight;++i) {
            for (int j = curY; j < curY + shapeWidth;++j) {
                board[i][j] += curPiece.getCoords()[i - curX][j - curY];
                if (backGroundBoard[i][j] == Color.WHITE && curPiece.getCoords()[i - curX][j - curY] == 1) {
                    backGroundBoard[i][j] = curPiece.getColor();
                }
            }
        }
    }

    public Color[][] getBackGroundBoard() {
        return backGroundBoard;
    }

    // getter.
    public void setNumRemoved(int x) {
        numRemoved = x;
    }

}
