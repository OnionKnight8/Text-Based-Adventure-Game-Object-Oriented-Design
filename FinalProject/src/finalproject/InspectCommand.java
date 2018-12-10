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
 * @description: Allows the user to inspect an item they are carrying, printing 
 * the item's description. If the user enters it with no target, it lists the
 * items in their inventory.
 */
public class InspectCommand extends Command{
    
    public InspectCommand() {
        super("inspect");
    }
    
    public boolean execute(Player player) {
        
        if(hasTarget()) {
            Item itemInspect = player.lookItem(getTarget());
            if(itemInspect != null) {
                System.out.println(itemInspect.getDesc());
            }
            else {
                System.out.println("You do not currently posses that item.");
            }
        }
        
        else {
            System.out.println(player.getItemsString());
            System.out.println("HINT: Enter \"inspect\" followed by the name of"
                    + "\nan item in your inventory to inspect the item.");
        }
        
        return false;
    }
}
