//package ui;
//
//import model.PlayersList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//public class LeaderBoardUI extends JFrame {
//    private PlayersList playersList;
//    private DefaultListModel<String> model;
//    private JList<String> list;
//    private JFrame frame;
//
//    public LeaderBoardUI(PlayersList playersList) {
//        this.playersList = playersList;
//        // Create a new JList with a default list model
//        model = new DefaultListModel<>();
//        list = new JList<>(model);
//
//        for (int i = 0;i < playersList.length();++i) {
//            try {
//                int score = playersList.index(i).getScore();
//                model.addElement(String.valueOf(score));
//            } catch (Exception e) {
//                // all good.
//            }
//        }
//
//        frame = new JFrame("Tetris");
//        setSize(500,600);
//        frame.setLocationRelativeTo(null); // center the JFrame on the screen
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                frame.setVisible(false);
//            }
//        });
//        frame.setLayout(new BorderLayout());
//        frame.add(new JScrollPane(list), BorderLayout.CENTER);
//        frame.setVisible(true);
//    }
//
//
//}
