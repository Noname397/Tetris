package model;

import java.util.Random;

public class Shape {
    protected enum Tetrominoe {
        NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape;
    }

    private Tetrominoe pieceShape;
    private int[][] coords;

    // EFFECTS: create new NoShape
    public Shape() {
        coords = new int[4][2];
        setShape(Tetrominoe.NoShape);
    }

    // MODIFIES: this
    // EFFECTS: create shape
    public void setShape(Tetrominoe shape) {

        int[][][] coordTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordTable[shape.ordinal()][i][j];
            }
        }

        pieceShape = shape;
    }

    // EFFECTS: return the x-coordinate of shape at row index.
    public int coordX(int index) {
        return coords[index][0];
    }

    // EFFECTS: return the y-coordinate of shape at row index.
    public int coordY(int index) {
        return coords[index][1];
    }

    // EFFECTS: return the Tetrominoe shape.
    public Tetrominoe getShape() {
        return pieceShape;
    }

    // MODIFIES: this
    // EFFECTS: set a new Shape.
    public void setRandomShape() {
        Random random = new Random();
        int randomNumber = random.nextInt(7) + 1;

        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[randomNumber]);
    }

    // MODIFIES: this
    // EFFECTS: rotate the shape to the left.
    Shape rotateLeft() {
        if (pieceShape == Tetrominoe.SquareShape) {
            return this;
        }

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        int transit;
        for (int i = 0; i < 4; i++) {
            transit = -coords[i][0];
            coords[i][0] = coords[i][1];
            coords[i][1] = transit;
        }

        return result;
    }

    // MODIFIES: this
    // EFFECTS: rotate the shape to the right.
    Shape rotateRight() {
        if (pieceShape == Tetrominoe.SquareShape) {
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = pieceShape;
        int transit;
        for (int i = 0; i < 4; i++) {
            transit = coords[i][0];
            coords[i][0] = -coords[i][1];
            coords[i][1] = transit;
        }

        return result;
    }
}
