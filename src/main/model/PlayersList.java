package model;

import model.exceptions.EmptyListException;
import model.exceptions.OutOfBoundException;

import java.util.ArrayList;

public class PlayersList {
    private ArrayList<Player> listOfPlayers;

    public PlayersList() {
        this.listOfPlayers = new ArrayList<Player>();
    }

    public void addPlayer(Player p) {
        this.listOfPlayers.add(p);
    }

    public void removePlayer(int index) throws OutOfBoundException, EmptyListException {
        if (listOfPlayers.size() == 0) {
            throw new EmptyListException();
        } else if (0 > index || index >= listOfPlayers.size()) {
            throw new OutOfBoundException();
        }
        this.listOfPlayers.remove(index);
    }

    public int length() {
        return listOfPlayers.size();
    }

    public Player index(int index) throws OutOfBoundException,EmptyListException {
        if (listOfPlayers.size() == 0) {
            throw new EmptyListException();
        } else if (0 > index || index >= listOfPlayers.size()) {
            throw new OutOfBoundException();
        }
        return listOfPlayers.get(index);
    }

    public void printOut() {
        if (listOfPlayers.size() == 0) {
            System.out.print("There's no player in the list");
        } else {
            for (int i = 0; i < listOfPlayers.size(); ++i) {
                System.out.println("Player " + (i + 1) + ": " + listOfPlayers.get(i).getName() + "\n");
            }
        }
    }
}
