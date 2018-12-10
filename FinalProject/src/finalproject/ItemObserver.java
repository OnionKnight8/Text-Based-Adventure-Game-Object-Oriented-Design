package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/9/2018
 * @description: Something that happens when items are used.
 */
public class ItemObserver implements EventObserver{
    
    public ItemObserver(Event event) {
        event.addObserver(this);
    }
    
    @Override
    public void onNotify(Player player, Monster monster, Event event) {
        if(!player.hasUsedItem()) {
            switch(player.getUsedItem().getName()) {
                case("potion") :
                    player.addLives(1);
                    break;
                case("rune") :
                    player.setInvisible(true);
                    break;
                case("orb") :
                    player.teleport();
                    break;
            }
        }
    }
}
