package finalproject;

import java.util.LinkedList;

/**
 *
 * @author Patrick
 * @date 11/13/2018
 * @description: Represents the Player, keeps track of where they are and how much health they have.
 */
public class Player {
    
    private Room currentRoom;
    private LinkedList<Room> roomArchive;
    
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
        roomArchive = new LinkedList<Room>();
        roomArchive.add(currentRoom);
    }
    
    /**
     * Return room user is currently in.
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * Sets the room user is currently in.
     * @param newRoom 
     */
    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
        roomArchive.add(currentRoom);
    }
    /**
     * For use with the "back" command. Let's the user move to a previously
     * visited room without adding it to the list of visited rooms.
     * @param newRoom 
     */
    public void moveBack() {
        currentRoom = roomArchive.remove(0);
    }
    
    /**
     * Checks if the user can move back. (Only returns false once the user has
     * moved all the way back to the starting room.)
     * @return if user can "back".
     */
    public boolean canBack() {
        if(roomArchive.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * Allows user to move between rooms.
     * @param direction 
     */
    public void go(String direction) {
        Room newRoom = currentRoom.getExit(direction);
        
        if(newRoom == null) {
            System.out.println("There is no exit in that direction.");
        }
        else {
            setCurrentRoom(newRoom);
            System.out.println(newRoom.getLongDescription());
        }
    }
}
