package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The first page when user enter the game.
public class FrontPageUI {
    private JButton startBtn;
    private JFrame frame;
    private JButton quitBtn;
    private JPanel btnPanel;

    // MODIFIES: this
    // EFFECTS: create a window frame with specified size and button panel (start and quit buttons).
    public FrontPageUI() {
        frame = new JFrame("Tetris");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // center the JFrame on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        btnPanel = new JPanel(new FlowLayout());
        setStartButton();
        setQuitButton();
        frame.add(btnPanel,BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: set up the start button.
    private void setStartButton() {
        startBtn = new JButton("Start");
        btnPanel.add(startBtn);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new PlayersUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: set up quit button.
    private void setQuitButton() {
        quitBtn = new JButton("Quit");
        btnPanel.add(quitBtn);
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
