package ui;

import model.Board;
import model.Shape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameArea extends JPanel {
    private GameUI gameUI;
    private int gridRow;
    private int gridCol;
    private int gridCellSize;
    private Timer timer;
    private Board board;
    private boolean isPaused;
    private int [] speed = {800,600,400,300,250,200,175};

    public GameArea(int width,int height,Board board, GameUI gameUI) {
        this.gameUI = gameUI;
        Rectangle r = new Rectangle(width,height);
        setBounds(r);
//        System.out.println(getHeight());
//        System.out.println(getWidth());
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new TAdapter());

        this.board = board;
        gridRow = this.board.getBoardHeight();
        gridCol = this.board.getBoardWidth();
        gridCellSize = getWidth() / gridCol;

//        System.out.println(gridCellSize);

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

    private void updateGame() {
        gameUI.updateScore(board.getScore());
        if (board.isGameFinished()) {
            timer.stop();
            int finalScore = board.getScore();
           // System.out.println("Score: " + finalScore);
            gameUI.transferFinalScoreToPlayer(finalScore);
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

    public void changeTimer() {
        if ((timer.isRunning())) {
            timer.stop();
        } else {
            timer.start();
        }
    }

}
