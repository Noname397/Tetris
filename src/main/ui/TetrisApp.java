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
            while (!board.isGameFinished()) {
                if (board.isGamePaused()) {
                    continueOrStop();
                } else {
                    updateBoard();
                }
            }
            try {
                playersList.index(i).setScore(board.getScore());
            } catch (OutOfBoundException e) {
                System.out.println("Unexpected exception");
            } catch (EmptyListException e) {
                System.out.println("Unexpected exception");
            }
            System.out.println("Score: " + "- " + board.getScore());
        }
        keepGoing = false;
    }

    public void updateBoard() {
        if (board.isFallingFinished()) {
            board.setFallingFinished();
            if (board.getNumRemoved() == 1) {
                System.out.println("You've just removed 1 line!!");
            } else if (board.getNumRemoved() > 1) {
                System.out.println("You've just removed " + board.getNumRemoved() + " line!!");
            }
            System.out.println("Your score is " + board.getScore());
            board.addNewPiece();
            System.out.println("The following shape is " + board.getCurPiece().getPieceShape().name());
        } else if (!board.isGamePaused()) {
            System.out.println("Your score is " + board.getScore());
            System.out.println("The current shape is " + board.getCurPiece().getPieceShape().name());
        }
        printOutShape();
        System.out.println("pos x:" + board.getCurX());
        System.out.println("pos y:" + board.getCurY());
        printOutBoard();
        displayGameMenu();
        input = new Scanner(System.in);
        System.out.print(">>>");
        String cmd = input.nextLine();
        processGameMenu(cmd);
    }

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

    public void printOutShape() {
        int [][] shape = board.getCurPiece().getCoords();
        int row = board.getCurPiece().getRow();
        int column = board.getCurPiece().getColumn();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(shape[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void processGameMenu(String command) {
        switch (command) {
            case "left":
                board.tryMove(board.getCurPiece(),board.getCurX(),board.getCurY() - 1);
                break;
            case "right":
                board.tryMove(board.getCurPiece(), board.getCurX(), board.getCurY() + 1);
                break;
            case "rotate":
                board.getCurPiece().rotateRight();
                break;
            case "drop":
                board.dropDown();
                break;
            case "pause":
                board.setGamePaused();
                break;
            case "quit":
                board.setGameFinished();
                break;
            default:
                System.out.println("Selection invalid...");
                break;
        }
    }

    private void continueOrStop() {
        System.out.println("\nSelect from:");
        System.out.println("\tcontinue -> continue");
        System.out.println("\tquit -> quit");
        input = new Scanner(System.in);
        System.out.print(">>>");
        String cmd = input.nextLine();
        switch (cmd) {
            case "continue":
                board.setGameContinue();
                break;
            case "quit":
                board.setGameFinished();
                break;
            default:
                System.out.println("Invalid choice....");
                break;
        }
    }

    private void displayGameMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tleft -> left");
        System.out.println("\tright -> right");
        System.out.println("\trotate -> rotating right");
        System.out.println("\tdrop -> drop the piece");
        System.out.println("\tpause -> pause game");
        System.out.println("\tquit -> quit game");
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
