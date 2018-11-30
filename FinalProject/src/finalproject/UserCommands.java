package finalproject;

import java.util.HashMap;

/**
 *
 * @author Patrick Dooley
 * @date 11/23/18
 * @description: A hashmap that stores all commands the player can use. Based on
 * CommandWords.java by Michael Kolling, David J. Barns, and Rodrigo Obando.
 */
public class UserCommands {
    
    private HashMap<String, Command> commands;
    
    public UserCommands() {
        commands = new HashMap<String, Command>();
        Command command = new MoveCommand();
        commands.put(command.getName(), command);
        command = new QuitCommand();
        commands.put(command.getName(), command);
    }
    
    /**
     * Converts command word into command object
     * @param userCommand
     * @return command object
     */
    public Command getCommand(String userCommand) {
        return commands.get(userCommand);
    }
    
    /**
     * Displays all commands
     */
    public void showAll() {
        for(String commandName : commands.keySet()) {
            System.out.println(commandName + "  ");
        }
        System.out.println();
    }
}
