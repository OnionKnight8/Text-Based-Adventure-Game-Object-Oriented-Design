package finalproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Patrick Dooley
 * @date 12/03/2018
 * @description: Takes the user's input and parses it (ex: splits a two word command
 * into a command and target). Based on Parser.java by Michael Kolling, David J. Barnes, and
 * Rodigo Obando.
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
    
    public Command getCommand() {
        String inputLine = "";
        String word1;
        String word2;
        
        System.out.print("> ");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println("Error reading input: " + exc.getMessage());
        }
        
        StringTokenizer tokenizer = new StringTokenizer(inputLine);
        
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
    
    public void showCommands() {
        commands.showAll();
    }
}
