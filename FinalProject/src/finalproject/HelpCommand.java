package finalproject;

import java.util.Random;

/**
 *
 * @author Patrick Dooley
 * @date 11/30/2018
 * @destription: Help command gives the player a list of commands that they can use.
 * Based on HelpCommand.java by Michael Kolling and Rodrigo Obando.
 */
public class HelpCommand extends Command {
    private UserCommands userCommands;
    
    public HelpCommand(UserCommands input) {
        super("help");
        userCommands = input;
    }
    
    /**
     * Returns some random flavor text for when the help command is called.
     * @return 
     */
    private String getFlavorText() {
        String flavorText = "";
        Random rng = new Random();
        int rand = rng.nextInt(4) + 1;
        
        if(rand == 1){
            flavorText = ("A chill runs down your spine. You turn around, but there is nothing there other than the oppressive darkness. "
                + "\nYou are certain that something is watching you, just out of sight.");
        }
        else if(rand == 2) {
            flavorText = ("You are not sure where you are or how you got here. It appears to be some sort of dungeon, "
                + "\nwith stone walls and a damp atmosphere. After a short rest, You decide to press onwards.");
        }
        else if(rand == 3) {
            flavorText = ("The sound of footsteps echoes of the walls, louder than before. You immediately freeze, and the footsteps cease. "
                    + "\nYou assure yourself that they were your own.");
        }
        else if(rand == 4) {
            flavorText = ("An unintelligible whisper periodically breaks the heavy silence. You cannot tell if it is your mind deceiving you... "
                    + "\nor something worse. Regardless, you feel encouraged to quicken your pace.");
        }
        
        return flavorText;
    }
    
    /**
     * Prints some flavor text and a list of commands the user can use.
     * @param player
     * @return false
     */
    public boolean execute(Player player) {
        System.out.println(getFlavorText());
        System.out.println();
        System.out.println("Your options are:");
        userCommands.showAll();
        return false;
    }
}
