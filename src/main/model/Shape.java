package model;

import java.util.Random;

public class Shape {
    private int [][][] coordTable = {
            {{0,0,0},{0,0,0}}, // NoShape
            {{1,1,0},{0,1,1}}, // ZShape
            {{0,1,1},{1,1,0}}, // SShape
            {{1,1,1,1}}, //LineShape
            {{0,1,0},{1,1,1}}, // TShape
            {{1,1},{1,1},{1,1},{1,1}}, // SquareShape
            {{0,0,1},{1,1,1}}, // LShape
            {{1,0,0},{1,1,1}}, // MirroredLShape
    };
    private int row;
    private int column;
//    private int size;
    private int[][] coords;
    private Tetrominoe pieceShape;

    // EFFECTS: create a new NoShape with given coordinates.
    public Shape() {
        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[0]);
    }

    // MODIFIES: this
    // EFFECTS: create shape
    public void setShape(Tetrominoe shape) {
        int pos = shape.ordinal();
        switch (shape) {
            case LineShape:
                row = 1;
                column = 4;
                break;
            case SquareShape:
                row = column = 2;
                break;
            default:
                row = 2;
                column = 3;
                break;
        }
        coords = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; ++j) {
                coords[i][j] = coordTable[shape.ordinal()][i][j];
            }
        }

        pieceShape = shape;

    }

    // MODIFIES: this
    // EFFECTS: set a random shape from ZShape to MirroredLShape.
    public void setRandomShape() {
        Random random = new Random();
        int randomNumber = random.nextInt(7) + 1;

        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[randomNumber]);
    }

    // MODIFIES: this
    // EFFECTS: rotate the shape to the left.
    public void rotateLeft() {
        int [][] rotatedArr = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedArr[column - j - 1][i] = coords[i][j];
            }
        }
        int tmp = column;
        column = row;
        row = tmp;
        coords = rotatedArr;

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                System.out.print(coords[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    // MODIFIES: this
    // EFFECTS: rotate the shape to the right.
    public void rotateRight() {
        int [][] rotatedArr = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedArr[j][row - 1 - i] = coords[i][j];
            }
        }

        int tmp = column;
        column = row;
        row = tmp;
        coords = rotatedArr;

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                System.out.print(coords[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    // EFFECT: return the int coordinates of the shape
    public int[][] getCoords() {
        return coords;
    }

    // EFFECT: return the Tetris type of shape.
    public Tetrominoe getPieceShape() {
        return pieceShape;
    }

    // EFFECTS: return the number of rows in shape
    public int getRow() {
        return row;
    }

    // EFFECTS: return the number of columns in shape.
    public int getColumn() {
        return column;
    }
}
