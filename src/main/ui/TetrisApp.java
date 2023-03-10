package ui;


import model.Board;
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
    private Board board;

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
        for (int i = 0; i < playersList.length(); ++i) {
            try {
                System.out.println("Player " + (i + 1) + ": " + playersList.index(i).getName());
            } catch (OutOfBoundException e) {
                System.out.println("Index out of bound");
            } catch (EmptyListException e) {
                System.out.print("There's no player in the list");
            }
        }
    }

    private void doStartGame() {
        for (int i = 0;i < playersList.length();++i) {
            System.out.println("Player " + (i + 1) + "'s game starts now!!!");
            board = new Board();

        }
        keepGoing = false;
    }

//    private void update(Board board) {
//        displayGameMenu();
//        input = new Scanner(System.in);
//        String commend = input.next();
//        if (board.isGameFinished()) {
//            System.out.println("Game over!! Score: " + "1");
//        } else if (board.isFallingFinished()) {
//            board.addNewPiece();
//            board.setCurrentPos();
//            printOutBoard(board);
//        } else {
//            processGameMenu(board,commend);
//            board.setCurrentPos();
//            printOutBoard(board);
//            // processGameMenu(board);
//            // board.oneLineDown();
//        }
//    }

    public void printOutBoard() {
        int [][] b = board.getBoard();
        int height = board.getBoardHeight();
        int width = board.getBoardWidth();
        for (int i = 0;i < height;++i) {
            for (int j = 0;j < width;++j) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void processGameMenu(String command) {
        switch (command) {
            case "a":
                System.out.println("Turning left");
                board.tryMove(board.getCurPiece(),board.getCurX(),board.getCurY() - 1);
                break;
            case "d":
                System.out.println("Turning right");
                board.tryMove(board.getCurPiece(), board.getCurX(), board.getCurY() + 1);
                break;
            case "w":
                System.out.println("rotating right");
                board.getCurPiece().rotateRight();
                break;
//            case "s":
//                board.getCurPiece().rotateLeft();
//                break;
            case "l":
                System.out.println("One line down");
                board.oneLineDown();
                break;
            case "p":
                System.out.println("paused");
                board.setGamePaused();
                break;
            case "q":
                System.out.println("finished");
                board.setGameFinished();
                break;
            default:
                System.out.println("Selection invalid...");
                break;
        }
    }

    private void displayGameMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> left");
        System.out.println("\td -> right");
        System.out.println("\tw -> rotating right");
//        System.out.println("\ts -> rotating left");
        System.out.println("\tl -> lower the piece");
        System.out.println("\tp -> pause game");
        System.out.println("\tq -> quit game");
    }

    private void doViewScore() {
        for (int i = 0; i < playersList.length(); ++i) {
            try {
                System.out.println("Player " + (i + 1) + ": " + playersList.index(i).getScore());
            } catch (OutOfBoundException e) {
                System.out.println("Index out of bound");
            } catch (EmptyListException e) {
                System.out.println("There's no player in the list");
            }
        }
    }

    private void doTutorial() {
        System.out.println("If you're new at Tetris, try to avoid doing a Hard Drop as this can swiftly drop a "
                +  "Tetrimino to the bottom and prevent you from fixing a mistake. \nIn general, you should utilise"
                + " the typical pace at which Tetriminos decline.");
    }

}
