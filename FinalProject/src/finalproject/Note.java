package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An item that cannot be picked up.
 */
public class Note extends Item{
    
    public Note() {
        super("note", "The note is dirty and torn, making it"
                + "\nextremely difficult to desipher. Even if it were not, the"
                + "\nauthor did not appear to be in a sound state of mind while"
                + "\npenning it. Strange and otherworldly symbols fill all corners"
                + "\nof the parchment, while what you can read is nonsensical. Perhaps,"
                + "\nhowever, it was writen by someone in a similar situation to yours."
                + "\nIn that case, it may be useful to research it more...", 10);
    }
    
    public void use(Player player) {
        System.out.println("Although much of the note is completely illegible,"
                + "\nyou manage to find a passage that you can translate. It says:"
                + "\n\"I cannot tell how long I have been trapped here. Whatever the"
                + "\nthing that lurks these halls is, it's too terrible to gaze upon. I feel"
                + "\nmy mind slipping away the longer I stay here, but I am too"
                + "\nparalyzed by fear to go any further. The next room gives off"
                + "\na strange pulsating noise, and I am too afraid to enter. I've thrown rocks"
                + "\ninto it and they seem to just... dissapear. What is happening to them? Before"
                + "\nI came to rest here, I noticed what may be the exit in the northeastern"
                + "\npart of the dungeon, but the beast was standing guard. I managed to avoid detection, "
                + "\nbut I cannot bear the thought of trying to sneak past it."
                + "\nMaybe this note can help someone else, I don't"
                + "\nthink I have the will to go any further.\"");
        System.out.println("\nThere is nothing else that can help you on the note. You"
                + "\ndecide to leave it behind.");
    }
}