package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An item that makes the user "invisible" (makes the next "hide"
 * attempt 100% chance to succeed.
 */
public class Rune extends Item{
    
    public Rune() {
        super("rune", "A heavy rune with a peculiar \"Q\" shape on it."
                + " You cannot be sure exactly what it does, but you feel"
                + " a great power eminating from it...", 20);
    }
    
    public void use(Player player) {
        System.out.println("You touch the rune, and suddenly your hand dissapears! Just as you"
                + "\nbegin to panic, you realise your entire body is now invisible."
                + "\nThis may come in useful while you are here, but hopefully it's reversable...");
        player.setUsedItem(this);
    }
}