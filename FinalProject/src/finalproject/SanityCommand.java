package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Allows for the user to get a rough estimate of how many lives
 * they have left.
 */
public class SanityCommand extends Command{
    
    public SanityCommand() {
        super("sanity");
    }
    
    public boolean execute(Player player) {
        
        if(!hasTarget()) {
            
            int lives = player.getLives();
            if(lives >= 5) {
                System.out.println("You feel calm and collected. You take a deep breath"
                        + "\nand get ready to keep moving.");
            }
            else if(lives == 4) {
                System.out.println("You are in good health, but you have a nagging"
                        + "\nfeeling that something is wrong. You nervously continue forward.");
            }
            else if(lives == 3) {
                System.out.println("You are scared. You know you are being stalked. Your pace"
                        + "\nincreases as you continue.");
            }
            else if(lives == 2) {
                System.out.println("Your breath is ragged as you hyperventilate. You can feel"
                        + "\neyes watching you. Your walk turns into a jog as you desperately"
                        + "\ntry to find the exit.");
            }
            else if(lives == 1) {
                System.out.println("You are panicking. Strange sounds play in your head"
                        + "\nand indescribable colors flicker in your peripheral. Every shadow contains eyes."
                        + "\nYou are moving at full sprint now as you search for a way out.");
            }
            else {
                System.out.println("If you are seeing this something has gone wrong.");
            }
        }
        else {
            System.out.println("You cannot use that command on that! (HINT: Enter"
                    + "\n\"sanity\" with no target.");
        }
        
        return false;
    }
}
