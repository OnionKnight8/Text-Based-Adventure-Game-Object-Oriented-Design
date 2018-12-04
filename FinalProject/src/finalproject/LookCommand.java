package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date Dec 5, 2018
 * @description: Allows the user to look around their current room. 
 */

public class LookCommand extends Command {
    
    public LookCommand() {
        super("look");
    }
    
    public boolean execute(Player player) {
        if(hasTarget()) {
            System.out.println("You cannot look at that! (HINT: If you want to"
                    + "\nlook at an item, use \"check\". To look around your current room,"
                    + "\nuse \"look\" with no target.");
        }
        else {
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        
        return false;
    }

}
