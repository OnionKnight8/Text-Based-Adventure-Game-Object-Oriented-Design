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
        command = new LookCommand();
        commands.put(command.getName(), command);
        command = new PickupCommand();
        commands.put(command.getName(), command);
        command = new DropCommand();
        commands.put(command.getName(), command);
        command = new UseCommand();
        commands.put(command.getName(), command);
        command = new InspectCommand();
        commands.put(command.getName(), command);
        command = new SanityCommand();
        commands.put(command.getName(), command);
        command = new BackCommand();
        commands.put(command.getName(), command);
        command = new HelpCommand(this);
        commands.put(command.getName(), command);
        command = new QuitCommand();
        commands.put(command.getName(), command);
    }
    
    public void setCommand(Command command) {
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
    }
}
