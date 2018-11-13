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
    
    public boolean execute() {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
        }
        else {
            System.out.println("What direction do you want to move in?");
        }
    }
}
