package ui;

import model.Board;
import model.Shape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The panel where game happens.
public class GameArea extends JPanel {
    private GameUI gameUI;
    private int gridRow;
    private int gridCol;
    private int gridCellSize;
    private Timer timer;
    private Board board;
    private boolean isPaused;
    private int [] speed = {800,600,400,300,250,200,175};

    // EFFECTS: create a game area.
    public GameArea(int width,int height,Board board, GameUI gameUI) {
        this.gameUI = gameUI;
        Rectangle r = new Rectangle(width,height);
        setBounds(r);
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new TAdapter());

        this.board = board;
        gridRow = this.board.getBoardHeight();
        gridCol = this.board.getBoardWidth();
        gridCellSize = getWidth() / gridCol;

        timer = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        timer.start();

        isPaused = false;
    }


    // EFFECTS: paint the game with grid, draw the background and current falling piece.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0;i < gridRow;++i) {
            for (int j = 0; j < gridCol; ++j) {
                g.drawRect(j * gridCellSize, i * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        drawBackGround(g);
        drawCurrentPiece(g);
    }

    // EFFECTS: paint the already fallen tetris pieces.
    private void drawBackGround(Graphics g) {
        for (int i = 0;i < gridRow;++i) {
            for (int j = 0;j < gridCol;++j) {
                Color color = board.getBackGroundBoard()[i][j];
                if (color != null) {
                    g.setColor(color);
                    g.fillRect(j * gridCellSize,i * gridCellSize, gridCellSize,gridCellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * gridCellSize,i * gridCellSize, gridCellSize,gridCellSize);
                }
            }
        }
    }

    // EFFECTS: update the current state of the game.
    private void updateGame() {
        gameUI.updateScore(board.getScore());
        if (board.isGameFinished()) {
            timer.stop();
            int finalScore = board.getScore();
            // window pop up game is over.
            gameUI.transferFinalScoreToPlayer(finalScore);
            JOptionPane.showMessageDialog(this, "Game Over");
        }
        if (board.isGamePaused()) {
            return;
        }
        if (board.isFallingFinished()) {
            board.setFallingFinished();
            board.addNewPiece();
        } else {
            board.oneLineDown();
        }
    }

    // EFFECTS: draw the current falling piece.
    private void drawCurrentPiece(Graphics g) {
        Shape shape = board.getCurPiece();
        int row = shape.getRow();
        int col = shape.getColumn();
        int curX = board.getCurX();
        int curY = board.getCurY();
        for (int i = 0;i < row;++i) {
            for (int j = 0;j < col; ++j) {
                if (shape.getCoords()[i][j] == 1) {
                    g.setColor(shape.getColor());
                    g.fillRect((j + curY) * gridCellSize,(i + curX) * gridCellSize, gridCellSize,gridCellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect((j + curY) * gridCellSize,(i + curX) * gridCellSize, gridCellSize,gridCellSize);
                }
            }
        }
    }

    // EFFECTS: process the state of the board on keypressed.
    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    board.tryMove(board.getCurPiece(),board.getCurX(),board.getCurY() - 1);
                    break;
                case KeyEvent.VK_RIGHT:
                    board.tryMove(board.getCurPiece(), board.getCurX(), board.getCurY() + 1);
                    break;
                case KeyEvent.VK_UP:
                    board.getCurPiece().rotateLeft();
                    if (!board.tryMove(board.getCurPiece(),board.getCurX(),board.getCurY())) {
                        board.getCurPiece().rotateRight();
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    board.dropDown();
                    break;
                case KeyEvent.VK_P:
                    changeTimer();
                    break;
            }
            repaint();
        }
    }

    // EFFECTS: convert the timer to the opposite state.
    public void changeTimer() {
        if ((timer.isRunning())) {
            timer.stop();
        } else {
            timer.start();
        }
    }

}
