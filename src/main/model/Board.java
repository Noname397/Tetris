package model;

public class Board {
    private static final int BOARD_WIDTH = 12;
    private static final int BOARD_HEIGHT = 12;

    private boolean isFallingFinished;
    private boolean isGameFinished;
    private boolean isGamePaused;
    private int curX;
    private int score;
    private int curY;
    private Shape curPiece;
    private int [][] board;

    public Board() {
        board = new int[BOARD_HEIGHT][BOARD_WIDTH];
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
        setCurrentPos(curX,curY,curX,curY);
        removeFullLine();
        isFallingFinished = true;
    }

    // MODIFIES: this
    // EFFECTS: remove every full 1 lines in the board.
    public void removeFullLine() {
        int numLineRemoved = 0;
        int row = BOARD_HEIGHT;
        int col = BOARD_WIDTH;
        int[][] newBoard = new int[row][col];
        int newRow = row - 1;

        for (int i = row - 1; i >= 0; i--) {
            if (!canRemoveLine(i)) {
                // Copy the current row to the new board
                for (int j = 0; j < col; j++) {
                    newBoard[newRow][j] = board[i][j];
                }
                newRow--;
            } else {
                ++numLineRemoved;
            }
        }

        // Fill the remaining rows with 0's
        while (newRow >= 0) {
            for (int j = 0; j < col; j++) {
                newBoard[newRow][j] = 0;
            }
            newRow--;
        }

        // Update the board
        board = newBoard;

        // Update the score
        updateScore(numLineRemoved);
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
        isFallingFinished = false;
        curPiece.setRandomShape();
        curX = 0;
        curY = BOARD_WIDTH / 2;
        System.out.println("type of shape:" + curPiece.getPieceShape().name());
        System.out.println("pos x:" + curX);
        System.out.println("pos y:" + curY);
        if (!tryMove(curPiece,curX,curY)) {
            isGameFinished = true;
        } else {
            setCurrentPos(curX,curY,curX,curY);
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
        setCurrentPos(curX,curY,newX,newY);
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

    // MODIFIES: this
    // EFFECTS: set isGamePaused = true;
    public void setGamePaused() {
        isGamePaused = true;
    }

    // MODIFIES: this
    // EFFECTS: set the game to be over
    public void setGameFinished() {
        isGameFinished = true;
    }

    // EFFECTS: return the score of the board.
    public int getScore() {
        return score;
    }

    // MODIFIES: this
    // EFFECTS:  change score
    public void updateScore(int numRemoved) {
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

    // EFFECTS: set the falling piece to the correct pos
    public void setCurrentPos(int oldX,int oldY,int newX,int newY) {
        int shapeHeight = curPiece.getRow();
        int shapeWidth = curPiece.getColumn();
        // reset old place with 0.
        for (int i = oldX; i < oldX + shapeHeight; ++i) {
            for (int j = oldY;j < oldY + shapeWidth;++j) {
                board[i][j] = 0;
            }
        }

        for (int i = newX; i < newX + shapeHeight; ++i) {
            for (int j = newY;j < newY + shapeWidth;++j) {
                board[i][j] += curPiece.getCoords()[i - newX][j - newY];
            }
        }
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
