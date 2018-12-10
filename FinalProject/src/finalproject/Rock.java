package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An item that cannot be picked up.
 */
public class Rock extends Item{
    
    public Rock() {
        super("rock", "if you can see this something has gone wrong", 100);
    }
    
    public void use(Player player) {
        System.out.println("You should not be able to do this.");
    }
}
