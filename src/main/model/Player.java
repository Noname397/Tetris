package model;

import model.exceptions.EmptyNameException;

public class Player {
    private String name;
    private int score;

    // EFFECTS: construct a player with name and 0 score, if name is empty, throw
    // EmptyNameException.
    public Player(String name) throws EmptyNameException {
        if (!name.isEmpty()) {
            this.name = name;
            this.score = 0;
        } else {
            throw new EmptyNameException();
        }
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: add a new score to the player.
    public void setScore(int x) {
        this.score = x;
    }

    public int getScore() {
        return score;
    }


}
