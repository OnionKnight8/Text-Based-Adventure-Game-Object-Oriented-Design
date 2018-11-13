package finalproject;

/**
 *
 * @author Patrick
 * @date 11/13/2018
 * @description: Command interface. Based on Command.java by Michael Kolling, David J. Barns,
 * and Rodrigo Obando.
 */
public abstract class Command {
    
    private String target;
    private String name;
    
    public Command(String name) {
        target = null;
        this.name = name;
    }
    
    /**
     * The target is the second word in a command,
     * or what the user wants to affect.
     */
    public boolean hasTarget() {
       return target != null; 
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * The name of the command.
     * @return name of command
     */
    public String getName() {
        return name;
    }
    
    /**
     * Checks if the game has ended.
     * @param player
     * @return true if the game is over, false if not.
     */
    public abstract boolean execute(Player player);
}
