package finalproject;

/**
 *
 * @author Patrick
 * @date 11/13/2018
 * @description: Represents the Player, keeps track of where they are and how much health they have.
 */
public class Player {
    
    private Room currentRoom;
    
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
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
