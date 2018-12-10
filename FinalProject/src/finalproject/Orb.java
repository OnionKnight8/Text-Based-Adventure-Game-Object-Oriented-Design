package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An item that teleports you to a random room.
 */
public class Orb extends Item{
    
    public Orb() {
        super("orb", "The orb is very heavy, and it is surrounded by a"
                + "\nclear crust. The crust appears to be made of glass,"
                + "\nbut you get the feeling that it is not fragile at all. You occassionally"
                + "\nobserve what appear to be other locations in the orb, some"
                + "\nof which are rooms you've seen in the dungeon. They appear to be"
                + "\nso close, as if you could reach out and touch them...", 30);
    }
    
    public void use(Player player) {
        System.out.println("You gaze closely into the orb, you feel as it you are being"
                + " pulled in...");
        player.setUsedItem(this);
    }
}