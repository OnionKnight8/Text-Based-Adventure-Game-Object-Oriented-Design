package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/6/2018
 * @description: Used to monitor events that are triggered when certain rooms
 * are entered.
 */
public interface EventObserver {
    public abstract void onNotify(Player player, Monster monster, Event event);
}
