package finalproject;

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
     * Prints some flavor text and a list of commands the user can use.
     * @param player
     * @return false
     */
    public boolean execute(Player player) {
        System.out.println("todo: put some stuff here idiot");
        System.out.println("Your command words are:");
        userCommands.showAll();
        return false;
    }
}
