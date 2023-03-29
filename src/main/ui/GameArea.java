package ui;

import model.Board;
import model.Shape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameArea extends JPanel {
    private int gridRow;
    private int gridCol;
    private int gridCellSize;
    private Board board;

    public GameArea(int width,int height,Board board) {
        setBounds(new Rectangle(width,height));
//        System.out.println(getHeight());
//        System.out.println(getWidth());
        setBackground(Color.WHITE);

        this.board = board;
        gridRow = this.board.getBoardHeight();
        gridCol = this.board.getBoardWidth();
        gridCellSize = getWidth() / gridCol;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0;i < gridRow;++i) {
            for (int j = 0; j < gridCol; ++j) {
                g.drawRect(j * gridCellSize, i * gridCellSize, gridCellSize, gridCellSize);
            }
        }

        drawCurrentPiece(g);
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

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                board.tryMove(board.getCurPiece(),board.getCurX(),board.getCurY() - 1);
                break;
            case KeyEvent.VK_RIGHT:
                board.tryMove(board.getCurPiece(), board.getCurX(), board.getCurY() + 1);
                break;
            case KeyEvent.VK_DOWN:
                board.getCurPiece().rotateRight();
                break;
            case KeyEvent.VK_UP:
                board.getCurPiece().rotateLeft();
                break;
            case KeyEvent.VK_P:
                board.setGamePaused();
                break;
            case KeyEvent.VK_SPACE:
                board.dropDown();
                break;
            default:
                board.oneLineDown();
                break;
        }
        repaint();
    }



}
