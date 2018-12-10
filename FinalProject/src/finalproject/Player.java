package finalproject;

import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 * @date 11/13/2018
 * @description: Represents the Player, keeps track of where they are and how much health they have.
 */
public class Player {
    
    final int MAX_WEIGHT = 40;
  
    private int encumbrance;
    private int lives = 2;
    private boolean invisible;
    private Room currentRoom;
    private Stack<Room> roomArchive;
    private Stack<Item> usedItem;
    private HashMap<String, Item> inventory;
    private ArrayList<Room> rooms;
    
    public Player(Room startingRoom, ArrayList<Room> rooms) {
        currentRoom = startingRoom;
        roomArchive = new Stack<Room>();
        roomArchive.add(currentRoom);
        usedItem = new Stack<Item>();
        inventory = new HashMap<String, Item>();
        this.rooms = rooms;
        encumbrance = 0;
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
        roomArchive.add(currentRoom);
        currentRoom = newRoom;
    }
    /**
     * For use with the "back" command. Let's the user move to a previously
     * visited room without adding it to the list of visited rooms.
     * @param newRoom 
     */
    public void moveBack() {
        currentRoom = roomArchive.pop();
    }
    /**
     * Some events in the game cause the player to be unable to move back. This
     * method clears the roomArchive so the back command cannot be used.
     */
    public void deleteArchive() {
        roomArchive.clear();
    }
    
    /**
     * Sets an item in the inventory.
     * @param name
     * @param item 
     */
    public void setItem(String name, Item item) {
        inventory.put(name, item);
    }
    /**
     * Retrieves an item and removes it from the inventory.
     * @param name
     * @return item
     */
    public Item getItem(String name) {
        Item returnItem = inventory.get(name);
        if(returnItem != null) {
            inventory.remove(name);
        }
        return returnItem;
    }
    /**
     * Returns an item without removing it from the player's inventory.
     * @param name
     * @return 
     */
    public Item lookItem(String name) {
        Item returnItem = inventory.get(name);
        return returnItem;
    }
    /**
     * Returns all items in the inventory
     * @return string containing names of all items in a room
     */
    public String getItemsString() {
        String itemsString = "Inventory:";
        for(String name : inventory.keySet()) {
            itemsString += " " + name;
        }
        return itemsString;
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
     * Adds weight to the player.
     * @param encumbrance 
     */
    public void addEncumbrance(int encumbrance) {
        this.encumbrance += encumbrance;
    }
    /**
     * Removes weight from the play.
     * @param encumbrance 
     */
    public void subEncumbrance(int encumbrance) {
        this.encumbrance -= encumbrance;
    }
    /**
     * Returns how much weight the player is carrying.
     * @return encumbrance
     */
    public int getEncumbrance() {
        return encumbrance;
    }
    /**
     * Returns the maximum weight the player can carry
     * @return 
     */
    public int getMaxWeight() {
        return MAX_WEIGHT;
    }
    
    /**
     * Add a life to the player.
     * @param lives 
     */
    public void addLives(int lives) {
        this.lives += lives;
    }
    /**
     * Removes a life from the player.
     * @param lives 
     */
    public void subLives(int lives) {
        this.lives -= lives;
    }
    /**
     * Returns how many lives the player has.
     * @return lives
     */
    public int getLives() {
        return lives;
    } 
    
    /**
     * Sets if the player is invisible.
     */
    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }
    /**
     * Checks if player is invisible.
     * @return invisible
     */
    public boolean getInvisible() {
        return invisible;
    }
    
    /**
     * Used to teleport player.
     */
    public void teleport() {
        Teleport teleporter = new Teleport(rooms, this);
        teleporter.execute();
    }
    
    /**
     * Returns list of all rooms. Used for event observers.
     * @return 
     */
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }
    
    /**
     * Adds item to the queue.
     * @param item 
     */
    public void setUsedItem(Item item) {
        usedItem.add(item);
    }
    /**
     * Gets item from queue.
     * @return item
     */
    public Item getUsedItem() {
        return usedItem.pop();
    }
    /**
     * Checks if player has used an item.
     * @return true if item was used, false otherwise
     */
    public boolean hasUsedItem() {
        return usedItem.isEmpty();
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
