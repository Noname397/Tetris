package ui;

import model.Player;
import model.PlayersList;
import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayersUI {
    private JFrame frame;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton saveBtn;
    private JButton loadBtn;
    private JButton scoreBtn;
    private JButton startGameBtn;
    private JList<String> list;
    private DefaultListModel<String> model;
    private JPanel btnPanel;

    private PlayersList playersList;
    private static final String JSON_STORE = "./data/tetris.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public PlayersUI() {
        // Create a new JList with a default list model
        model = new DefaultListModel<>();
        list = new JList<>(model);

        playersList = new PlayersList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        frame = new JFrame("Tetris");
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null); // center the JFrame on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.setVisible(true);

        btnPanel = new JPanel(new FlowLayout());
        setAddButton();
        setRemoveButton();
        setSaveButton();
        setLoadButton();
        setStartGameBtn();
        setScoresButton();
        frame.add(btnPanel, BorderLayout.SOUTH);

    }

    private void setStartGameBtn() {
        startGameBtn = new JButton("Start game");
        startGameBtn.setBounds(350,50,30,30);
        //startGameBtn.setBackground(Color.ORANGE);
        btnPanel.add(startGameBtn);
        startGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // start game;
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    // new game;
                    new GameUI(playersList, selectedIndex);
                }
            }
        });
    }

    private void setAddButton() {
        addBtn = new JButton("Add");
        addBtn.setBounds(50,50,30,30);
        //addBtn.setBackground(Color.YELLOW);
        btnPanel.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter player name:");
                try {
                    playersList.addPlayer(new Player(input));
                    model.addElement(input);
                    System.out.println(input + "'s added to the list");
                } catch (EmptyNameException ex) {
                    System.out.println("Name must be not empty");
                    JOptionPane.showMessageDialog(frame, "Please enter some text.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setRemoveButton() {
        removeBtn = new JButton("Remove");
        removeBtn.setBounds(100,50,30,30);
        //removeBtn.setBackground(Color.blue);
        btnPanel.add(removeBtn);
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                try {
                    playersList.removePlayer(selectedIndex);
                    model.remove(selectedIndex);
                } catch (OutOfBoundException ex) {
                    System.out.println("Out of bound");
                    JOptionPane.showMessageDialog(frame, "Out of bound", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (EmptyListException ex) {
                    System.out.println("Empty list");
                    JOptionPane.showMessageDialog(frame, "Empty list", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setSaveButton() {
        saveBtn = new JButton("Save");
        saveBtn.setBounds(150,50,30,30);
        //saveBtn.setBackground(Color.GREEN);
        btnPanel.add(saveBtn);

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(playersList);
                    jsonWriter.close();
                    System.out.println("Saved players list to " + JSON_STORE);
                } catch (FileNotFoundException exception) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    private void setLoadButton() {
        loadBtn = new JButton("Load");
        loadBtn.setBounds(250,50,50,50);
        //loadBtn.setBackground(Color.PINK);
        btnPanel.add(loadBtn);
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playersList = jsonReader.read();
                    System.out.println("Loaded players list from " + JSON_STORE);
                    addPlayersToModel();
                } catch (IOException exception) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }

    private void addPlayersToModel() {
        model.clear();
        for (int i = 0; i < playersList.length(); ++i) {
            try {
                model.addElement(playersList.index(i).getName());
            } catch (OutOfBoundException ex) {
                System.out.println("Out of bound");
            } catch (EmptyListException ex) {
                System.out.println("Empty list");
            }
        }
    }

    private void setScoresButton() {
        scoreBtn = new JButton("View score");
        scoreBtn.setBounds(250,50,50,50);
        //loadBtn.setBackground(Color.PINK);
        btnPanel.add(scoreBtn);
        scoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                JList<String> scoreList = new JList<>(model);

                JFrame scoreBoard = new JFrame("Leaderboard");
                scoreBoard.setSize(500,600);
                scoreBoard.setVisible(true);
                scoreBoard.setLayout(new BorderLayout());
                scoreBoard.add(new JScrollPane(scoreList), BorderLayout.CENTER);


                for (int i = 0;i < playersList.length();++i) {
                    try {
                        int score = playersList.index(i).getScore();
                        model.addElement("Player " + (i + 1) + ": " + String.valueOf(score));
                    } catch (Exception exception) {
                        // all good.
                    }
                }

                scoreBoard.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        scoreBoard.setVisible(false);
                    }
                });
            }
        });
    }
}