package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: An event that occurs in room17, in which the wall caves in behind
 * the player so they cannot go back.
 */
public class Room17Observer implements EventObserver{
    
    public Room17Observer(Event event) {
        event.addObserver(this);
    }
    
    @Override
    public void onNotify(Player player, Monster monster, Event event) {
        if(player.getCurrentRoom().getName().equals("room17")) {
            stuck(player);
            event.deleteObserver(this);
        }
    }
    
    /**
     * Causes an event in which the wall caves in, disallowing the player from
     * walking backwards. Also deletes the exit in the previous room.
     * @param player 
     */
    public void stuck(Player player) {
        System.out.println("\nThe wall caves in behind you!");
        player.getAllRooms().get(31).removeExit("east");
        player.getAllRooms().get(31).setDescription("This room mediates between the stone and wood sections of the dungeon. To the south, you feel a chill"
                + "\nmoisture. To the north, you can see a dimly lit wooden room. To the east, the small exit has been"
                + "\ncovered by dirt and rock from the cave-in.");
        player.deleteArchive();
    }
}
