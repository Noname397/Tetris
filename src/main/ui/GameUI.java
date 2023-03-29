package ui;

import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameUI extends JFrame implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int CONTROL_PANEL_WIDTH = 200;
    private static final int BOARD_WIDTH = WIDTH - CONTROL_PANEL_WIDTH;

    private JPanel boardPanel;
    private JPanel controlPanel;
    private JLabel scoreLabel;
    private JButton pauseButton;
    private PauseDialog pauseDialog;

    public GameUI() {
        setTitle("My Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // create board panel
//        boardPanel = new JPanel();
//        boardPanel.setPreferredSize(new Dimension(BOARD_WIDTH, HEIGHT));
//        boardPanel.setBackground(Color.WHITE);
        setBoardPanel();

        // create control panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, HEIGHT));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        // create score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(scoreLabel);

        // create pause button
        pauseButton = new JButton("Pause");
        pauseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pauseButton.addActionListener(this);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        controlPanel.add(pauseButton);

        // add board panel and control panel to frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(boardPanel, BorderLayout.WEST);
        getContentPane().add(controlPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseButton) {
            pauseDialog = new PauseDialog(this);
            pauseDialog.setVisible(true);
        }
    }

    private void setBoardPanel() {
        //boardPanel = new JPanel();
        boardPanel = new BoardPanel();
        boardPanel.setPreferredSize(new Dimension(BOARD_WIDTH, HEIGHT));
        boardPanel.setBackground(Color.WHITE);

    }


    private class PauseDialog extends JDialog implements ActionListener {

        private JButton quitButton;
        private JButton continueButton;

        public PauseDialog(JFrame parent) {
            super(parent, "Paused", true);
            setPreferredSize(new Dimension(300, 150));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            quitButton = new JButton("Quit");
            quitButton.addActionListener(this);
            buttonPanel.add(Box.createHorizontalGlue());
            buttonPanel.add(quitButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));

            continueButton = new JButton("Continue");
            continueButton.addActionListener(this);
            buttonPanel.add(continueButton);
            buttonPanel.add(Box.createHorizontalGlue());

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            pack();
            setLocationRelativeTo(parent);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitButton) {
                dispose();
                System.exit(0);
            } else if (e.getSource() == continueButton) {
                dispose();
            }
        }
    }
}
