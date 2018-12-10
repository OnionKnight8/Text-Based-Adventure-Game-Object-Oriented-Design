package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: Allows the player to use an item in their inventory.
 */
public class UseCommand extends Command {
    
    public UseCommand() {
        super("use");
    }
    
    public boolean execute(Player player) {
        if(hasTarget()) {
            Item useItem = player.getItem(getTarget());
            if(useItem != null) {
                useItem.use(player);
                player.subEncumbrance(useItem.getWeight());
            }
            else {
                System.out.println("You do not currently posses that item.");
            }
        }
        else {
            System.out.println("Use what? (HINT: Enter \"use\" followed by an item"
                    + "in your inventory that you want to use.");
        }
        
        return false;
    }
}
