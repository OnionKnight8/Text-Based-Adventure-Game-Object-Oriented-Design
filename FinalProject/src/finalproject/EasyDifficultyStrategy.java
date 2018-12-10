package finalproject;

import java.util.Random;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: The easy difficulty.
 */
public class EasyDifficultyStrategy implements DifficultyStrategy{  
    
    final int ROOM_COUNT = 31;
    
    public void setDifficulty(Player player, InputParser parser) {
        
        System.out.println("\nStarting \"easy\" game...");
        
        ItemFactory itemFactory = new ItemFactory();
        Random rng = new Random();
        int rand = 0;
        boolean finished;
        
        //Item Generation
        Map map = new Map(parser.getUserCommands());
        Item[] rocks = new Item[14];
        Item[] potions = new Item[7];
        Item[] orbs = new Item[2];
        
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
        player.getAllRooms().get(1).setItem("map", map);
        player.getAllRooms().get(15).setItem(itemFactory.itemMaker("rune").getName(), itemFactory.itemMaker("rune"));
        player.getAllRooms().get(19).setItem(itemFactory.itemMaker("note").getName(), itemFactory.itemMaker("note"));
        
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
                    finished = true;
                }
            }
        }
        
        //Other 
        player.addLives(2);
    }
}
