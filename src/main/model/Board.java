package model;

public class Board {
    private static final int BOARD_WIDTH = 12;
    private static final int BOARD_HEIGHT = 12;

    private boolean isFallingFinished;
    private boolean isGameFinished;
    private int numLinesRemoved;
    private int curX;
    private int levelDiff;
    private int curY;
    private Shape curPiece;
    private int [][] board;

    public Board() {
        board = new int[BOARD_HEIGHT][BOARD_WIDTH];
        curPiece = new Shape();
        isFallingFinished = false;
        isGameFinished = false;
        curX = 0;
        curY = 0;
        clearBoard();
    }

    // MODIFIES: this
    // EFFECTS: create a new board with every position being 0.
    public void clearBoard() {
        for (int i = 0;i < BOARD_HEIGHT;++i) {
            for (int j = 0;j < BOARD_WIDTH;++j) {
                board[i][j] = 0;
            }
        }
    }


    // MODIFIES: this
    // EFFECTS: drop the shape to the furthest position down as possible.
    public void dropDown() {
        while (tryMove(curPiece, curX + 1, curY)) {
            ++curX;
        }
        System.out.println("Pos of x is " + curX);
        pieceDropped();
    }

    // MODIFIES: this
    // EFFECTS: drop the shape one line down.
    public void oneLineDown() {
        if (!tryMove(curPiece,curX + 1,curY)) {
            pieceDropped();
        } else {
            curX++;
        }
    }

    // MODIFIES: this
    // EFFECTS: puts the falling piece into the board 2D array. Then remove all full lines and add a new piece.
    public void pieceDropped() {
        // set the falling piece to the correct pos
        int shapeHeight = curPiece.getRow();
        int shapeWidth = curPiece.getColumn();
        for (int i = curX; i < curX + shapeHeight; ++i) {
            for (int j = curY;j < curY + shapeWidth;++j) {
                board[i][j] = curPiece.getCoords()[i - curX][j - curY];
            }
        }

        removeFullLine();
        isFallingFinished = true;
        if (!isFallingFinished) {
            addNewPiece();
        }
    }

    // MODIFIES: this
    // EFFECTS: remove every full 1 lines in the board.
    public void removeFullLine() {
        int numLineRemoved = 0;
        for (int i = BOARD_HEIGHT - 1; i >= 0;--i) {
            if (canRemoveLine(i)) {
                ++numLineRemoved;
            }
        }

        if (numLineRemoved > 0) {
            // drag all values down to the exact no of lines removed.
        }

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
        curPiece.setRandomShape();
        curX = 0;
        curY = BOARD_WIDTH / 2;
        if (!tryMove(curPiece,curX,curY)) {
            isGameFinished = true;
//            update();
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
        return true;
    }

    // EFFECTS: return the current falling shape.
    public Shape getCurPiece() {
        return curPiece;
    }

    // EFFECTS: return the board width
    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    // EFFECTS: return the board height
    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    // EFFECTS: return the board coordinates.
    public int[][] getBoard() {
        return board;
    }

    // EFFECTS: return the current row pos of falling piece.
    public int getCurX() {
        return curX;
    }

    // EFFECTS: return the current col pos of falling piece.
    public int getCurY() {
        return curY;
    }

    // EFFECTS: return true if the game is over.
    public boolean isGameFinished() {
        return isGameFinished;
    }

    // EFFECTS: return true if the piece has stopped falling.
    public boolean isFallingFinished() {
        return isFallingFinished;
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

    public void printOutBoard() {
        for (int i = 0;i < 12;++i) {
            for (int j = 0;j < 12;++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
