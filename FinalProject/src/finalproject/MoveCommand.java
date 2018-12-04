package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 11/23/18
 * @description: Command that allows player to move in a direction. 
 * Based on GoCommand.java by Micahel Kolling and Rodrigo Obando.
 */
public class MoveCommand extends Command {
   
    public MoveCommand() {
        super("move");
    }
    
    public boolean execute(Player player) {
        if(hasTarget()) {
            String direction = getTarget();
            player.go(direction);
        }
        else {
            System.out.println("What direction do you want to move in? (HINT: Enter \"move\" followed by a direction to choose where you want to go.");
        }
        return false;
    }
}
