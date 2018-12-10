package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 11/7/2018
 * @description: Driver class. Contains main(), which constructs the GameManager
 * and begins the game.
 */
public class FinalProject {

    public static void main(String[] args) throws Exception {
        GameManager game = new GameManager();
        game.chooseDifficulty();
        game.play();
        System.out.println("\nThank you for playing!");
    }
}
