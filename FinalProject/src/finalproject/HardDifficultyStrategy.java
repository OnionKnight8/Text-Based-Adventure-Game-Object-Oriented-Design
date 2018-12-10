package finalproject;

import java.util.Random;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: The hard difficulty.
 */
public class HardDifficultyStrategy implements DifficultyStrategy{  
    
    final int ROOM_COUNT = 31;
    
    public void setDifficulty(Player player, InputParser parser) {
        
        System.out.println("\nStarting \"hard\" game...");
        
        ItemFactory itemFactory = new ItemFactory();
        Random rng = new Random();
        int rand = 0;
        boolean finished;
        
        //Item Generation
        Map map = new Map(parser.getUserCommands());
        Item[] rocks = new Item[17];
        Item[] potions = new Item[4];
        Item[] orbs = new Item[1];
        
        for(int i = 0; i < rocks.length; i++) {
            rocks[i] = itemFactory.itemMaker("rock");
        }
        for(int i = 0; i < potions.length; i++) {
            potions[i] = itemFactory.itemMaker("potion");
        }
        for(int i = 0; i < orbs.length; i++) {
            orbs[i] = itemFactory.itemMaker("orb");
        }
        
        //Item placement
        player.getAllRooms().get(15).setItem(itemFactory.itemMaker("rune").getName(), itemFactory.itemMaker("rune"));
        player.getAllRooms().get(19).setItem(itemFactory.itemMaker("note").getName(), itemFactory.itemMaker("note"));
        
        finished = false;
        while(!finished) {
            rand = rng.nextInt(ROOM_COUNT) + 1;
            if(rand != 32 && rand != 20) {
                player.getAllRooms().get(rand).setItem("map", map);
                finished = true;
            }
        }
        
        for(int i = 0; i < rocks.length; i++) {
            finished = false;
            while(!finished) {
            rand = rng.nextInt(ROOM_COUNT) + 1;
                if(rand != 32 && rand != 20){
                    player.getAllRooms().get(rand).setItem("rock", rocks[i]);
                    finished = true;
                }
            }
        }
        for(int i = 0; i < potions.length; i++) {
            finished = false;
            while(!finished) {
                rand = rng.nextInt(ROOM_COUNT) + 1;
                if(rand != 32 && rand != 20){
                    player.getAllRooms().get(rand).setItem("potion", potions[i]);
                    finished = true;
                } 
            }
        }
        for(int i = 0; i < orbs.length; i++) {
            finished = false;
            while(!finished) {
                rand = rng.nextInt(ROOM_COUNT) + 1;
                if(rand != 32 && rand != 20){
                    player.getAllRooms().get(rand).setItem("orb", orbs[i]);
                    finished =  true;
                }
            }
        }
    }
}
