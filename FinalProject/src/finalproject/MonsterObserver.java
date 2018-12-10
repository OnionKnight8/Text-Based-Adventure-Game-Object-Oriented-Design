package finalproject;

import java.util.Random;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Checks if the player and monster collide.
 */
public class MonsterObserver implements EventObserver{
    
    final int ROOM_COUNT = 31;
    Random rng;
    
    public MonsterObserver(Event event) {
        event.addObserver(this);
        rng = new Random();
    }
    
    @Override
    public void onNotify(Player player, Monster monster, Event event) {
        if(player.getCurrentRoom() == monster.getCurrentRoom()) {
            System.out.println("\nSomething is different here. Something is in the"
                    + " room with you. You need to hide!");
            System.out.println("You make an attempt to hide and...\n");
            
            if(player.getInvisible()) {
                System.out.println("Before you can attempt to hide, the monster enters the room."
                        + "\nYou stand perfectly still as it scans it's surroundings. For a moment, it"
                        + "\nalmost looks like it can see you. You fight the urge to run away with all of your"
                        + "\nwillpower. A couple moments later, it goes away. You exhale, finally safe"
                        + "\nfor the time being. As you collect yourself, you realise that you are no longer invisible."
                        + "\nYou will need to be more careful in the future.");
                
                player.setInvisible(false);
            }
            else {
                int rand = rng.nextInt(2);
                if(rand == 1) {
                    System.out.println("You hide successfully. The monster leaves... for now.");
                }
                else {
                    System.out.println("The monster spots you!\n");
                    player.subLives(1);
                    if(player.getLives() > 0) {
                        System.out.println("You break into a sprint, your lungs burn and your legs ache"
                                + "\nbut you keep going until you can run no more. You collapse to the ground,"
                                + "\ngasping for air. Somehow you managed to escape. You aren't sure if you can"
                                + "\nsurvive another encounter with the monster.");
                    }
                }
            }
            
            teleportMonster(player, monster);
        }
    }
    
    /**
     * Teleports the monster to a new room (with some exceptions).
     */
    public void teleportMonster(Player player, Monster monster) {
        int rand2;
        boolean finished = false;
        while(!finished) {
            rand2 = rng.nextInt(ROOM_COUNT);
            if(rand2 != 32 && rand2 != 17 && rand2 != 18 && rand2 != 19 && rand2 != 20)
                if(player.getAllRooms().get(rand2) != monster.getCurrentRoom()) {
                    monster.setCurrentRoom(player.getAllRooms().get(rand2));
                    finished = true;
                }
        }
    }
}
