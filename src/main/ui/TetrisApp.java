package ui;


import model.BoardLinhTinh;
import model.Player;
import model.PlayersList;
import model.exceptions.EmptyListException;
import model.exceptions.EmptyNameException;
import model.exceptions.OutOfBoundException;

import java.util.Scanner;

public class TetrisApp {
    private Scanner input;
    boolean keepGoing;
    private PlayersList playersList;

    // EFFECTS: runs the tetris application
    public TetrisApp() {
        startTetris();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void startTetris() {
        keepGoing = true;
        String commend;

        init();

        while (keepGoing) {
            displayMenu();
            commend = input.next();
            commend = commend.toLowerCase();

            if (commend.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(commend);
            }
        }

        System.out.println("Thank you for using our game!\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "a":
                doAddPlayer();
                break;
            case "r":
                doRemovePlayer();
                break;
            case "v":
                doViewPlayer();
                break;
            case "s":
                doStartGame();
                break;
            case "hs":
                doViewScore();
                break;
            case "tutor":
                doTutorial();
                break;
            default:
                System.out.println("Selection invalid...");
                break;
        }
    }



    // MODIFIES: this
    // EFFECTS: initializes game
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        playersList = new PlayersList();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add new player");
        System.out.println("\tr -> remove existing player");
        System.out.println("\tv -> view the players in the game");
        System.out.println("\ths -> view the highscores in the game");
        System.out.println("\ts -> start game");
        System.out.println("\ttutor -> learn the tutorial of the game");
        System.out.println("\tq -> quit game");
    }

    // MODIFIES: this
    // EFFECTS: add a player into the list of players.
    private void doAddPlayer() {
        input = new Scanner(System.in);
        System.out.println("Enter the player name: ");
        String name = input.nextLine();
        try {
            playersList.addPlayer(new Player(name));
            System.out.print(name + " has been added to the list of players\n");
        } catch (EmptyNameException e) {
            System.out.println("Name must be at least a character long!!!!\n");
        }
        doViewPlayer();
    }

    // MODIFIES: this
    // EFFECTS: remove a player from the list of players, if there's no player in the list or index out of bound
    // printout unable to remove
    private void doRemovePlayer() {
        System.out.println("Enter the player's index to remove: \n(Note that the first player starts at position 1)");
        int pos = input.nextInt();
        try {
            playersList.removePlayer(pos - 1);
            System.out.print("Player " + pos  + " has been removed from the list of players\n");
        } catch (OutOfBoundException e) {
            System.out.println("Index out of bound\n");
        } catch (EmptyListException e) {
            System.out.print("Can't remove a player from an empty list!!!");
        }
        doViewPlayer();
    }

    private void doViewPlayer() {
        if (playersList.length() == 0) {
            System.out.print("There's no player in the list");
        } else {
            for (int i = 0; i < playersList.length(); ++i) {
                try {
                    System.out.println("Player " + (i + 1) + ": " + playersList.index(i).getName());
                } catch (OutOfBoundException e) {
                    throw new RuntimeException(e);
                } catch (EmptyListException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void doStartGame() {
        for (int i = 0;i < playersList.length();++i) {
            System.out.println("Player " + (i + 1) + "'s game starts now!!!");
            BoardLinhTinh b = new BoardLinhTinh();
            b.start();
            while (!b.isGameFinished()) {
                displayGameMenu();
                input = new Scanner(System.in);
                String cmd = input.nextLine();
                b.keyPressed(cmd);
                b.update();
            }
            try {
                playersList.index(i).newScore(b.getNumLinesRemoved());
                System.out.println("Game over!!! Score for player " + (i + 1) + "is" + playersList.index(i).getScore());
            } catch (OutOfBoundException e) {
                throw new RuntimeException(e);
            } catch (EmptyListException e) {
                throw new RuntimeException(e);
            }
        }
        keepGoing = false;
    }

    private void displayGameMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> left");
        System.out.println("\td -> right");
        System.out.println("\tw -> rotating right");
        System.out.println("\ts -> rotating left");
        System.out.println("\tl -> lower the piece");
        System.out.println("\tp -> pause game");
        System.out.println("\tq -> quit game");
    }

    private void doViewScore() {
        if (playersList.length() == 0) {
            System.out.print("There's no player in the list");
        } else {
            for (int i = 0; i < playersList.length(); ++i) {
                try {
                    System.out.println("Player " + (i + 1) + ": " + playersList.index(i).getScore());
                } catch (OutOfBoundException e) {
                    throw new RuntimeException(e);
                } catch (EmptyListException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void doTutorial() {
        System.out.println("If you're new at Tetris, try to avoid doing a Hard Drop as this can swiftly drop a "
                +  "Tetrimino to the bottom and prevent you from fixing a mistake. \nIn general, you should utilise"
                + " the typical pace at which Tetriminos decline.");
    }

}
