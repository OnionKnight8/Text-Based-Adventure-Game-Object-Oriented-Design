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
    private String name;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
    }
    
    /**
     * Sets the room's name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the room's name
     * @return name
     */
    public String getName() {
        return name;
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
     * Sets an item in the room.
     * @param name
     * @param item 
     */
    public void setItem(String name, Item item) {
        items.put(name, item);
    }
    
    /**
     * Allows the player to remove an item from the room by picking it up.
     * @param name
     * @return item
     */
    public Item getItem(String name) {
        Item returnItem = items.get(name);
        if(returnItem != null) {
            items.remove(name);
        }
        return returnItem;
    }
    
    /**
     * Returns all items in a room
     * @return string containing names of all items in a room
     */
    public String getItemsString() {
        String itemsString = "Items:";
        for(String name : items.keySet()) {
            itemsString += " " + name;
        }
        return itemsString;
    }
    
    /**
     * Resets the description of a room.
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns description without listing exits.
     * @return description defined in contructor.
     */
    public String getShortDescription() {
        return description;
    }
    
    /**
     * Gets full description of a room, including exits the user can use and items
     * in the room.
     * @return long description
     */
    public String getLongDescription() {
        return(description + "\n" + getExitString() + "\n" + getItemsString());
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
