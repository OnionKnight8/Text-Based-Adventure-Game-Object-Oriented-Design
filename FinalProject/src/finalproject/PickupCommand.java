package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: Allows the user to pick up an item off the ground.
 */
public class PickupCommand extends Command{
    
    public PickupCommand() {
        super("pickup");
    }
    
    public boolean execute(Player player) {
        
        if(hasTarget()) {
            String itemName = getTarget();
            Item itemPickUp = player.getCurrentRoom().getItem(itemName);
            
            if(itemPickUp != null) {
                if((player.getEncumbrance() + itemPickUp.getWeight()) > player.getMaxWeight()) {
                    System.out.println("It is too heavy to pick up. (HINT: Try "
                            + "getting rid of some items that you are carrying.)");
                }
                else {
                    player.setItem(itemPickUp.getName(), itemPickUp);
                    player.addEncumbrance(itemPickUp.getWeight());
                    System.out.println("You pick up the " + itemPickUp.getName() + "."); 
                }
            }
            else {
                System.out.println("There is no such item here.");
            }
        }
        else {
            System.out.println("What do you want to pick up? (HINT: Enter \"pickup\""
                    + "followed by the name of the item that you want to pick up.");
        }
        
        return false;
    }
}
