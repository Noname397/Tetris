package model;

public class Board {
    private static final int BOARD_WIDTH = 12;
    private static final int BOARD_HEIGHT = 12;

    private boolean isFallingFinished;
    private boolean isPaused;
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

    public void setPaused() {
        isPaused = true;
        update();
    }

    public void update() {

    }

    // MODIFIES: this
    // EFFECTS: drop the shape to the furthest position down as possible.
    public void dropDown() {
        int newX = curX;
//        while (newX < BOARD_HEIGHT) {
//            if (!tryMove(curPiece, newX + 1, curY)) {
//                break;
//            }
//            newX++;
//        }
        while (tryMove(curPiece, newX + 1, curY)) {
            ++newX;
        }
        curX = newX;
        System.out.println("Pos of x is " + newX);
        pieceDropped();
    }

    public void oneLineDown() {
        if (!tryMove(curPiece,curX + 1,curY)) {
            pieceDropped();
        }
    }

    // MODIFIES: this
    // EFFECTS: puts the falling piece into the board 2D array. Then remove all full lines and add a new piece.
    public void pieceDropped() {
        // set the falling piece to the correct pos


        removeFullLine();
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
            if (board[index][i] == 1) {
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
            update();
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
        System.out.println(curPiece.getPieceShape());
        return curPiece;
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
