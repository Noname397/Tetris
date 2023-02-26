package model;

import model.exceptions.EmptyNameException;

public class Player {
    private String name;

    public Player(String name) throws EmptyNameException {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new EmptyNameException();
        }
    }

    public String getName() {
        return name;
    }
}
