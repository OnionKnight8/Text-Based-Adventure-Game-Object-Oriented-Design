package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Implementation of the strategy pattern. Used to change details
 * in the world based on chosen difficulty.
 */
public interface DifficultyStrategy {
    
    public void setDifficulty(Player player, InputParser parser);
}
