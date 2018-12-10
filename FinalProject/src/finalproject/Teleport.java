package finalproject;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Used to move the player or monster to a random room.
 */
public class Teleport {
    final int ROOM_COUNT = 31;
    final ArrayList<Room> rooms;
    Player player;
    Monster monster;
    Random rng;
    
    public Teleport(ArrayList<Room> rooms, Player player) {
        this.rooms = rooms;
        this.player = player;
        rng = new Random();
    }
    
    /**
     * Teleports the player. Player cannot be teleported to room 20 (the room with
     * the teleporter in it) or the exit.
     */
    public void execute() {
        boolean finished = false;
        int rand = 1;
        
        while(!finished) {
            rand = rng.nextInt(ROOM_COUNT + 1);
            
            if(rand != 20 && rand != 32) {
                finished = true;
            }
        }
        
        System.out.println("\nYou feel a wave of nausea come over you. Strange lights"
                + " and sounds assault you for what feels like hours, until it suddenly"
                + " stops. You are no longer where you were before...\n");
        player.setCurrentRoom(rooms.get(rand));
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
}
