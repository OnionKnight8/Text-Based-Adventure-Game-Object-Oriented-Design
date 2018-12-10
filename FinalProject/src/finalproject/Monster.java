package finalproject;

import java.util.Random;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: The enemy of the game. Moves in a random direction when the player
 * moves. If the player and the monster land on the same space, the player must make
 * an attempt to hide. If they fail, they lose a life.
 */
public class Monster{
    
    private Room currentRoom;
    private Random rng;
    
    public Monster(Room startingRoom) {
        currentRoom = startingRoom;
        rng = new Random();
    }
    
    /**
     * Sets the room the monster is in.
     * @param currentRoom 
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    /**
     * Gets the room the monster is in.
     * @return 
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Allows the monster to move. Has a 25% chance of staying in it's current room.
     */
    public void go() {
        int rand;
        String direction = "north";
        boolean finished = false;
        
        rand = rng.nextInt(4);      
        if(rand >= 1) {
        
            while(!finished) {
                rand = rng.nextInt(4);
                if(rand == 0) {
                    direction = "north";
                }
                else if(rand == 1) {
                    direction = "east";
                }
                else if(rand == 2) {
                    direction = "south";
                }
                else if(rand == 3) {
                    direction = "west";
                }
        
                if(currentRoom.getExit(direction) != null && !currentRoom.getExit(direction).getName().equals("exit") && !currentRoom.getExit(direction).getName().equals("room17")) {
                    setCurrentRoom(currentRoom.getExit(direction));   
                    finished = true;
                }
            }
        }
    }
}
