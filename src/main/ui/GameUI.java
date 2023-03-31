package ui;

import model.Board;
import model.PlayersList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Game User Interface.
public class GameUI extends JFrame {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 540;
    private static final int CONTROL_PANEL_WIDTH = 150;
    private static final int BOARD_WIDTH = WIDTH - CONTROL_PANEL_WIDTH;

    private PlayersList playersList;
    private int playerIndex;
    private JPanel boardPanel;
    private Board board;
    private JPanel controlPanel;
    private JLabel scoreLabel;
    private static JLabel stateLabel;
    private JButton pauseButton;

    // EFFECTS: create GameUI
    public GameUI(PlayersList pl, int index) {
        setTitle("Tetris");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // create board panel
        board = new Board();
        setGameArea(board);
        playersList = pl;
        playerIndex = index;

        // create control panel.
        createControlPanel();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // EFFECTS: set game area.
    public void setGameArea(Board board) {
        boardPanel = new GameArea(BOARD_WIDTH,HEIGHT, board, this);
        boardPanel.setPreferredSize(new Dimension(BOARD_WIDTH, HEIGHT));
        boardPanel.setBackground(Color.WHITE);
    }

    // EFFECTS: update the current score of the player.
    public void updateScore(int score) {
        scoreLabel.setText("Score : " + String.valueOf(score));
    }

    // EFFECTS: transfer the final score to the player.
    public void transferFinalScoreToPlayer(int score) {
        try {
            System.out.println("Score has been updated");
            playersList.index(playerIndex).setScore(score);
        } catch (Exception e) {
          // all good.
        }
    }

    // EFFECTS: create a control panel.
    public void createControlPanel() {
        // create control panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, HEIGHT));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        // create score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(scoreLabel);

        // add board panel and control panel to frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(boardPanel, BorderLayout.WEST);
        getContentPane().add(controlPanel, BorderLayout.EAST);
    }
}
