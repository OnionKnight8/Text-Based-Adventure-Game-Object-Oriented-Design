package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: When room 20 is entered, player is teleported to a random room.
 */
public class Room20Observer implements EventObserver{
    public Room20Observer(final Event event){
        event.addObserver(this);
    }
    
    @Override
    public void onNotify(Player player, Monster monster, Event event) {
        if(player.getCurrentRoom().getName().equals("room20")) {
            player.teleport();
        }
    }
}
