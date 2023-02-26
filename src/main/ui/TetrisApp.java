package ui;

import java.util.Scanner;

public class TetrisApp {
    private Scanner input;

    // EFFECTS: runs the tetris application
    public TetrisApp() {
        startTetris();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void startTetris() {
        boolean keepGoing = true;
        String commend = null;

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

        System.out.println("\nThank you for using our game!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("i")) {
             doIndividualPlayer();
        } else if (command.equals("w")) {
             doMultiplayer();
        } else {
            System.out.println("Selection invalid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes game
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ti -> start individual game");
        System.out.println("\tw -> start multiplayer game");
        System.out.println("\tq -> quit game");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doIndividualPlayer() {
//        Account selected = selectAccount();
//        System.out.print("Enter amount to deposit: $");
//        double amount = input.nextDouble();
//
//        if (amount >= 0.0) {
//            selected.deposit(amount);
//        } else {
//            System.out.println("Cannot deposit negative amount...\n");
//        }
//
//        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doMultiplayer() {
//        Account selected = selectAccount();
//        System.out.print("Enter amount to withdraw: $");
//        double amount = input.nextDouble();
//
//        if (amount < 0.0) {
//            System.out.println("Cannot withdraw negative amount...\n");
//        } else if (selected.getBalance() < amount) {
//            System.out.println("Insufficient balance on account...\n");
//        } else {
//            selected.withdraw(amount);
//        }
//
//        printBalance(selected);
    }



    // EFFECTS: prompts user to select chequing or savings account and returns it
//    private Account selectAccount() {
//        String selection = "";  // force entry into loop
//
//        while (!(selection.equals("c") || selection.equals("s"))) {
//            System.out.println("c for chequing");
//            System.out.println("s for savings");
//            selection = input.next();
//            selection = selection.toLowerCase();
//        }
//
//        if (selection.equals("c")) {
//            return cheq;
//        } else {
//            return sav;
//        }
//    }
//
//    // EFFECTS: prints balance of account to the screen
//    private void printBalance(Account selected) {
//        System.out.printf("Balance: $%.2f\n", selected.getBalance());
//    }
}
