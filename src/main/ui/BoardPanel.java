package ui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private int row;
    private int col;

    public BoardPanel() {
        this.row = 15;
        this.col = 15;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / col;
        int cellHeight = height / row;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = j * cellWidth;
                int y = i * cellHeight;
                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }


    }
}