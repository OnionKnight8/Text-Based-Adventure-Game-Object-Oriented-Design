package finalproject;

/**
 *
 * @author Patrick Dooley
 * @date 12/8/2018
 * @description: A map gives a small ASCII map for the user to look at to get their bearings.
 * ASCII map drawn using ASCIIFlow Infinity [http://asciiflow.com/].
 */
public class Map extends Item{
    
    private UserCommands commands;
    
    public Map(UserCommands commands) {
        super("map", "A map of the dungeon. Most of it is illegible, but you can"
                + " get a basic idea of the layout.", 10);
        this.commands = commands;
    }
    
    public void use(Player player) {
        System.out.println("\n+--------------+\n" +
"|                     |\n" +
"|                     |\n" +
"|                     | <----+DANGER!!!\n" +
"|                     |\n" +
"|                     |\n" +
"|                     |\n" +
"|                     |\n" +
"+------+-------+\n" +
"           |\n" +
"           |\n" +
"           |\n" +
"+------+-------+                      +--------------+\n" +
"|                     |                       |                     |\n" +
"|                     |                       |                     |\n" +
"|                     |                       |                     |\n" +
"|                     +----------------+                    |\n" +
"|                     |                       |                     |\n" +
"|                     |                       |                     |\n" +
"|                     |                       |                     |\n" +
"+--------------+                      +------+-------+\n" +
"                                                          |                                               ^                                                                                             ^\n" +
"                                                          |                                               |                                                                                              |\n" +
"                                                          |                                               |                                                                                              |\n" +
"                                                          |                                               |                                                                                              |\n" +
"                                               +------+-------+                       +------+-------+                                                                       +-------+-------+\n" +
"                                               |                      |                        |                      |                                                                       |                       |\n" +
"                                               |                      |                        |                      |                                                                       |                       |\n" +
"                                               |                      |                        |                      |                                                                       |                       |                            +---+\n" +
"                                               |                      +----------------+                      |                                                                       |                      +---------------->    |  !!!  |\n" +                       
"                                               |                      |                        |                      |                                                                       |                       |                            +---+\n" +
"                                               |                      |                        |                      |                                                                       |                       |\n" +
"                                               |                      |                        |                      |                                                                       |                       |\n" +
"                                               +------+-------+                       +------+-------+                                                                       +-------+-------+\n" +
"                                                                                                          |                                               ^                                              ^\n" +
"                                                                                                          |                                               |                                               |\n" +
"                                                                                                          |                                               |                                               |\n" +
"                                                                                                          |                                               |                                               |\n" +
"                                                                                               +------+-------+                       +------+-------+                       +------+-------+\n" +
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               |                      +----------------+                      +---------------+                     +---------------->\n" +                            
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               |                      |                        |                       |                      |                     |\n" +
"                                                                                               +------+-------+                       +------+-------+                       +------+-------+\n" +
"                                                                                                                                                          |                                               |\n" +
"                                                                                                                                                          |                                               |\n" +
"                                                                                                                                                          |                                               |\n" +
"                                                                                                                                              +------+-------+                                   v\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                <---------+                    +--------->\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                               |                     |\n" +
"                                                                                                                                               +--------------+\n" +
"                                                                                                                                               THE GATE?");
        commands.setCommand(new MapCommand());
        System.out.println("Just as you finish reading it, the map suddenly"
                + "\ndisappears. Before you even begin to worry about it, however,"
                + "\nyou realize that you have commited it to memory somehow."
                + "\n(HINT: You can now use the \"map\" command.)");
    }
}
