package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Patrick Dooley
 * @date 12/6/2018
 * @description: Used to notify observers.
 */
public class Event {
    private ArrayList<EventObserver> eventObservers;
    private ArrayList<EventObserver> eventBuffer;
    
    public Event() {
        eventObservers = new ArrayList<EventObserver>();
        eventBuffer = new ArrayList<EventObserver>();
    }
    
    /**
     * Adds observer to the list of observers.
     * @param observer 
     */
    public void addObserver(EventObserver observer) {
        eventObservers.add(observer);
        eventBuffer = eventObservers;
    }
    
    /**
     * Deleted observer from list. Actually adds to a buffer list that updates
     * the real list after notifications are sent in order to prevent conflicts.
     * @param observer 
     */
    public void deleteObserver(EventObserver observer) {
        eventBuffer.remove(observer);
    }
    
    public void notifyObservers(Player player, Monster monster, Event event) {
        eventObservers = eventBuffer;
        for(int i = 0; i < eventObservers.size(); i++) {
            eventObservers.get(i).onNotify(player, monster, event);
        }
    }
}
