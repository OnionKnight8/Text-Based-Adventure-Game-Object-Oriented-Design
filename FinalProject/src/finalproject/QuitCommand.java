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
        if(getTarget() == null) {
            return true;
        }
        else {
            System.out.println("You cannot quit that! (Try \"quit\" with no target if you want to exit the game.)");
            return false;
        }
    }
}
