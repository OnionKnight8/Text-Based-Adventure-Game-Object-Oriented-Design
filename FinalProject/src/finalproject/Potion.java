package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: Gives the player another "life".
 */
public class Potion extends Item{
    
    public Potion() {
        super("potion", "You are not quite sure what it does, but the way"
                + " the colors swirl inside the vial is mesmerizing...", 10);
    }
    
    public void use(Player player) {
        System.out.println("The potion is tasteless. After you drink it, however,"
                + "\nyou feel calmer. Your will restored, you continue forth.");
        player.setUsedItem(this);
    }
}