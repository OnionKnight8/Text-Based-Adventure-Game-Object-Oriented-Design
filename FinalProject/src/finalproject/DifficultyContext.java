package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Used to change difficulty.
 */
public class DifficultyContext {
    
    private DifficultyStrategy strategy;
    
    public void setStrategy(DifficultyStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setDifficulty(Player player, InputParser parser) {
        strategy.setDifficulty(player, parser);
    }
}
