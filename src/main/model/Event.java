package model;

import java.util.Calendar;
import java.util.Date;

// Represents an alarm system event.
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // EFFECTS: Creates an event with the given description and the current date/time stamp.
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    // EFFECTS: return the date of the event
    public Date getDate() {
        return dateLogged;
    }

    // EFFECTS: return the description of the event
    public String getDescription() {
        return description;
    }

    // EFFECTS: override the original equals method.
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged) && this.description.equals(otherEvent.description));
    }

    // EFFECTS: override the original hashCode method.
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    // EFFECTS: override the original toString method.
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}