/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: Implementation of the factory design pattern, use to generate items.
 */
public class ItemFactory {
    
    public ItemFactory() {
        
    }
    
    /**
     * Creates specified item from String.
     * @param itemName
     * @return returnedItem
     */
    public Item itemMaker(String itemName) {
        Item returnedItem = null;
        
        switch(itemName) {
            case "rock" :
                returnedItem = new Rock();
                break;
            case "potion" :
                returnedItem = new Potion();
                break;
            case "rune" :
                returnedItem = new Rune();
                break;
            case "note" :
                returnedItem = new Note();
                break;
            case "orb" :
                returnedItem = new Orb();
                break;
        }
        
        return returnedItem;
    }
}
