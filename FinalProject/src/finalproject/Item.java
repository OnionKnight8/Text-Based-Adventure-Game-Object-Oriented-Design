package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An item is something the player can use to help them in the game.
 * Contains the item's name and it's weight.
 */
public abstract class Item {
    
    private String itemName;
    private String itemDesc;
    private int itemWeight;
    
    public Item(String itemName, String itemDesc, int itemWeight) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemWeight = itemWeight;
    }
    
    /**
     * Returns the name of an item.
     * @return itemName
     */
    public String getName() {
        return itemName;
    }
    
    /**
     * Returns a description of the item.
     * @return itemDesc
     */
    public String getDesc() {
        return itemDesc;
    }
    
    /**
     * Returns how much an item weighs.
     * @return itemWeight
     */
    public int getWeight() {
        return itemWeight;
    }
    
    /**
     * Allows the player to use an item.
     * @param player
     */
    public abstract void use(Player player);
}
