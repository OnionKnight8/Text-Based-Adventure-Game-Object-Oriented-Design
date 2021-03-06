package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 11/23/2018
 * @description: Ends game.
 */
public class QuitCommand extends Command {
    
    public QuitCommand() {
        super("quit");
    }
    
    public boolean execute(Player player) {
        if(!hasTarget()) {
            System.out.println("You decide to take the easy way out...");
            return true;
        }
        else {
            System.out.println("You cannot quit that! (HINT: Enter \"quit\" with no target if you want to exit the game.)");
            return false;
        }
    }
}
