package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: Allows the user to remove an item from their inventory and set it
 * on the ground.
 */
public class DropCommand extends Command{
    
    public DropCommand() {
        super("drop");
    }
    
    public boolean execute(Player player) {
        if(hasTarget()) {
            Item itemDrop = player.getItem(getTarget());
            if(itemDrop != null) {
                player.getCurrentRoom().setItem(itemDrop.getName(), itemDrop);
                System.out.println("You drop the " + itemDrop.getName() + "."); 
            }
            else {
                System.out.println("You do not currently posses that item.");
            }
        }
        else {
            System.out.println("Drop what? (HINT: Enter \"drop\" and then the name"
                    + "of the item that you would like to drop.");
        }
        
        return false;
    }
}
