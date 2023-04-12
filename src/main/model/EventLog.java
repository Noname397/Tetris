package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a log of alarm system events.
 * We use the Singleton Design Pattern to ensure that there is only
 * one EventLog in the system and that the system has global access
 * to the single instance of the EventLog.
 */
public class EventLog implements Iterable<Event> {
    /** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: create a new list of events.
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: create a new instance of EventLog if it doesn't already exist
    // else return the already existing EventLog.
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // EFFECTS: add event to EventLog
    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: clear the event log and logs the log.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS:
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }

}
