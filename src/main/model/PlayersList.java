package model;

import model.exceptions.EmptyListException;
import model.exceptions.OutOfBoundException;

import java.util.ArrayList;

public class PlayersList {
    private ArrayList<Player> listOfPlayers;

    // EFFECTS: create a new players list
    public PlayersList() {
        this.listOfPlayers = new ArrayList<Player>();
    }

    // MODIFIES: this
    // EFFECTS: add a new player to the end of the list.
    public void addPlayer(Player p) {
        this.listOfPlayers.add(p);
    }

    // MODIFIES: this
    // EFFECTS: if the list is empty, throw new EmptyListException, or if the index is out of
    // bound, throw new OutOfBoundException(), otherwise remove player from the list based on
    // the index.
    public void removePlayer(int index) throws OutOfBoundException, EmptyListException {
        if (listOfPlayers.size() == 0) {
            throw new EmptyListException();
        } else if (0 > index || index >= listOfPlayers.size()) {
            throw new OutOfBoundException();
        }
        this.listOfPlayers.remove(index);
    }

    // EFFECTS: return the size of the list.
    public int length() {
        return listOfPlayers.size();
    }

    // EFFECTS: if the list is empty, throw new EmptyListException, or if the index is out of
    // bound, throw new OutOfBoundException(), otherwise return the player with given
    // the index.
    public Player index(int index) throws OutOfBoundException,EmptyListException {
        if (listOfPlayers.size() == 0) {
            throw new EmptyListException();
        } else if (0 > index || index >= listOfPlayers.size()) {
            throw new OutOfBoundException();
        }
        return listOfPlayers.get(index);
    }
}
