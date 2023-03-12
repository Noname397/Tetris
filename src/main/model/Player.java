package model;

import model.exceptions.EmptyNameException;
import org.json.JSONObject;
import persistence.Writable;

// Representing a player with name and score.
public class Player implements Writable {
    private String name; // name of the player
    private int score; // score of the player

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

    // getter
    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: add a new score to the player.
    public void setScore(int x) {
        this.score = x;
    }

    // getter
    public int getScore() {
        return score;
    }

    // EFFECTS: returns player as a JSON array
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("score", score);
        return json;
    }
}
