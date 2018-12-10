package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/6/2018
 * @description: An event in the first room of the game in which a gate closes
 * behind the player, disallowing them from moving back into the "lobby" area.
 */
public class Room1Observer implements EventObserver {

    public Room1Observer(final Event event){
        event.addObserver(this);
    }
    
    @Override
    public void onNotify(Player player, Monster monster, Event event) {
        if(player.getCurrentRoom().getName().equals("room1")) {
            gateClose(player);
            event.deleteObserver(this);
        }
    }
    
    /**
     * An event in which a gate closes behind the player, disallowing them from
     * moving backwards.
     * @param player 
     */
    public void gateClose(Player player) {
        System.out.println("\nA gate slams shut behind you. You cannot return.");
        player.getAllRooms().get(1).setDescription("This room looks much like the room you woke up in. There are doors in every direction."
                + "\nThe room you came from was some kind of cell with an iron gate. The northern exit appears to be well lit and"
                + "\nhas the largest door of the exits. To the east, the walls appear to get narrower and the lights dimmer."
                + "\nYou feel a cold draft from the exit. To the west, the stone hallway seems to continue uninterrupted."
                + "\nThe gate you entered through is still closed.");
        player.deleteArchive();
    }
}
