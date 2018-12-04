package finalproject;

import java.util.HashMap;

/**
 *
 * @author Patrick Dooley
 * @date 11/13/2018
 * @description: A location in the game that the player can move to.
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    
    /**
     * Sets an exit to a room.
     * @param direction
     * @param neighbor 
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }
    /**
     * Return room in specified direction.
     * @param direction
     * @return Room
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    /**
     * For removing exits.
     * @param direction 
     */
    public void removeExit(String direction) {
        exits.remove(direction);
    }
    
    /**
     * Returns description without listing exits.
     * @return description defined in contructor.
     */
    public String getShortDescription() {
        return description;
    }
    
    /**
     * Gets full description of a room, including exits the user can use.
     * @return long description
     */
    public String getLongDescription() {
        return(description + "\n" + getExitString());
    }
    
    /**
     * Returns a string including the exits a room has, for use with getLongDescription class.
     * @return Exits: (Insert Exits)
     */
    private String getExitString() {
        String exitString = "Exits:";
        for(String exitName : exits.keySet()) {
            exitString += " " + exitName;
        }
        return exitString;
    }
}
