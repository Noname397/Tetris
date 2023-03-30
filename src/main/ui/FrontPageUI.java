package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPageUI {
    private JButton startBtn;
    private JFrame frame;
    private JButton quitBtn;
    private JPanel btnPanel;

    public FrontPageUI() {
//        JFrame frame = new JFrame("Tetris");
        frame = new JFrame("Tetris");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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


    private void setStartButton() {
        startBtn = new JButton("Start");
        //startBtn.setBounds(50,50,100,100);
        //startBtn.setBackground(Color.YELLOW);
        btnPanel.add(startBtn); //frame.getContentPane().add(startButton);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                // new PlayersUI(); uncomment for checkStyle error.
            }
        });
    }

    private void setQuitButton() {
        quitBtn = new JButton("Quit");
        //quitBtn.setBounds(250,50,100,100);
        //quitBtn.setBackground(Color.blue);
        btnPanel.add(quitBtn);//frame.getContentPane().add(quitBtn);
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
