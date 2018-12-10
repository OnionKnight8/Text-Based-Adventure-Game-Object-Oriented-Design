package finalproject;

/**
 *
 * @author patrick
 * @date 12/04/2018
 * @description: Command that allows to player to move backwards through rooms
 * they have already visited.
 */
public class BackCommand extends Command {
    
    public BackCommand() {
        super("back");
    }
    
    public boolean execute(Player player) {
        if(player.canBack() && !hasTarget()) {
            System.out.println("You retrace your steps. Perhaps you missed something?");
            player.moveBack();
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        else if(player.canBack() && hasTarget()) {
            System.out.println("You cannot go back to a specified room. (HINT: Enter \"back\" with no target to revisit your last location.");
        }
        else {
            System.out.println("You cannot go back any further.");
        }
        return false;
    }
}
