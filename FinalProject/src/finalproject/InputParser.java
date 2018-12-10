package finalproject;

import java.util.StringTokenizer;

/**
 *
 * @author Patrick Dooley
 * @date 12/03/2018
 * @description: Takes the user's input and parses it (ex: splits a two word command
 * into a command and target). Based on Parser.java by Michael Kolling, David J. Barnes, and
 * Rodrigo Obando.
 */
public class InputParser {
    
    private UserCommands commands;
    
    /**
     * Constructor with no commands.
     */
    public InputParser() {
        this(new UserCommands());
    }
    /**
     * Constructor with commands
     * @param commands 
     */
    public InputParser(UserCommands commands) {
        this.commands = commands;
    }
    
    public Command getCommand(String userInput) {
        String word1;
        String word2;
        
        System.out.print("> ");
        
        StringTokenizer tokenizer = new StringTokenizer(userInput.toLowerCase());
        
        if(tokenizer.hasMoreTokens()) {
            word1 = tokenizer.nextToken();
        }
        else {
            word1 = null;
        }
        if(tokenizer.hasMoreTokens()) {
            word2 = tokenizer.nextToken();
        }
        else {
            word2 = null;
        }
        
        Command command = commands.getCommand(word1);
        if(command != null) {
            command.setTarget(word2);
        }
        return command;
    }
    
    /**
     * Returns the UserCommands. Used if another class needs to add a new command.
     * @return 
     */
    public UserCommands getUserCommands() {
        return commands;
    }
    
    public void showCommands() {
        commands.showAll();
    }
}
