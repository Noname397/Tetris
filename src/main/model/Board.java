package model;

import static model.Shape.*;

import java.util.Timer;

public class Board {
//    private final int BOARD_WIDTH = 10;
//    private final int BOARD_HEIGHT = 22;
//    private final int PERIOD_INTERVAL = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    //private JLabel statusbar;
    private Shape curPiece;
    private Tetrominoe[] board;

//    private int squareWidth() {
//        return (int) getSize().getWidth() / BOARD_WIDTH;
//    }
//
//    private int squareHeight() {
//        return (int) getSize().getHeight() / BOARD_HEIGHT;
//    }

 //   private Tetrominoe shapeAt(int x, int y) {
 //       return board[(y * BOARD_WIDTH) + x];
 //   }

}
