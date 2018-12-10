package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.LinkedList;
import javax.swing.JFrame;
import java.util.ArrayList;

/**
 *
 * @author Patrick Dooley
 * @date 12/05/2018
 * @description: The games "director". Contains the loop that keeps the game
 * running and sets up the rooms within the game.
 */
public class GameManager {
    
    final InputParser parser;
    final Player player;
    final Monster monster;
    final Gui userInterface;
    final LinkedList<String> queue;
    ArrayList<Room> rooms;
    
    public GameManager() {
        rooms = new ArrayList<Room>();
        
        parser = new InputParser();
        player = new Player(gameSetup(), rooms);
        
        monster = new Monster(rooms.get(15));
        
        userInterface = new Gui();
        createGui(userInterface);

        queue = new LinkedList<String>();
    }
    
    /**
     * Creates rooms, adds exits and items.
     * @return starting room
     */
    public Room gameSetup() {
        
        Room entrance = new Room("entrance", "You are in some kind of stone cell. The gate is barrred, but left ajar.");
        Room room1 = new Room("room1", "This room looks much like the room you woke up in. There are doors in every direction."
                + "\nThe room you came from was some kind of cell with an iron gate. The northern exit appears to be well lit and"
                + "\nhas the largest door of the exits. To the east, the walls appear to get narrower and the lights dimmer."
                + "\nYou feel a cold draft from the exit. To the west, the stone hallway seems to continue uninterrupted.");
        Room room2 = new Room("room2", "The room is a large atrium. There are doors in all directions.");
        Room room3 = new Room("room3", "This room is a small hallway made of stone. The air is chill with moisture.");
        Room room4 = new Room("room4", "The atmosphere in this room is damp. The stone floor is slick with something, hopefully water.");
        Room room5 = new Room("room5" , "Suits of armor adorn the sides of this linear hallway. Could there be others here?");
        Room room6 = new Room("room6" ,"The hallway opens up into a circular room with three exits.");
        Room room7 = new Room("room7", "Another stone hallway, although at the north end of the hallway the stones are overgrown with moss.");
        Room room8 = new Room("room8", "A corner room with a high up window. You cannot hear anything though it, and no light"
                + "\nescapes from the outside. You consider scaling the wall briefly, but you feel that you are more likely to hurt yourself"
                + "\nthan make any progress.");
        Room room9 = new Room("room9", "You are in some sort of cathedral, although it does not resemble any you have"
                + "\never seen before. Peculiar symbols and letters adorn the ceiling and strange statues"
                + "\nstand guard against walls. Where could you possibly be?");
        Room room10 = new Room("room10", "If the walls in this room are made of stone, you cannot tell. Some sort of moss covers"
                + "\nevery surface in the room. You take care not to make contact with it as you shuffle onwards.");
        Room room11 = new Room("room11", "This room is some sort of mediator between the different sections of the dungeon."
                + "\nThe southern side of the room is stone while the northern side is wood. There is also an eastern exit, but"
                + "\nit is covered in some sort of strange plant growth.");
        Room room12 = new Room("room12", "The room is dimly lit and made of wood, as if you are in some kind of cabin."
                + "\nAre you above ground? You did not ascend any stairs to get here. You feel a humid breeze to the west, while to the north"
                + "\nthe hallway shrinks in size.");
        Room room13 = new Room("room13", "Plants and moss cover all corners of the room. To the east, the exit is made of rotted wood.");
        Room room14 = new Room("room14", "You wipe the sweat ofo of your brow. The air here is hot and humid. This room is not only covered"
                + "\nin moss, but an impenitrable row of trees line the walls. Is it possible there are hidden spaces behind them you cannot reach? "
                + "\nHow far on does this underground jungle spread?");
        Room room15 = new Room("room15", "You do not feel safe here. This is clearly something's lair. Unseen insects chirp in the"
                + "\ndistance. Behind the lines of trees you catch glimpses of light, just on your peripheral vision."
                + "You feel it would be a mistake to linger here for long.");
        Room room16 = new Room("room16", "You are in some sort of labratory. Vials of colorful fluid lie on stone tables around the room."
                + "\nIt is, however, quite obvious that the lab has not been used in a long time. A thick layer of dust has gathered"
                + "\non every surface in the room and the lighting is dim. Still, you hope there may be other people nearby that you can"
                + "\nask for help.");
        Room room17 = new Room("room17", "The wall collapse kicked up dust everywhere. After collecting yourself, you take a look around. There is a single torch on the wall giving a the room"
                + "\nfaint illumination. You appear to be in some sort of mine. The only way forward is down.");
        Room room18 = new Room("room18", "As you move east, the mine's floor declines slightly. You struggle to see in the"
                + "worsening darkness as you distance yourself from the torch.");
        Room room19 = new Room("room19", "After a steep decline, you find yourself in a small cavern. There is a skeleton in the corner with a note."
                + "\nFrom the north, you hear a strange pulsating noise. It comes and waves, each one you feel moving through you.");
        Room room20 = new Room("room20", "The room is pitch black. You nervously edge forward into the room. Just as you're about to turn back,"
                + "\na blinding white light fills the room.");
        Room room21 = new Room("room21", "The sound of running water is louder here.");
        Room room22 = new Room("room22", "The stones on the ground are covered in mud. You swear you hear"
                + "\nthe sound of distant running water, if only faintly.");
        Room room23 = new Room("room23", "The stone walls, ceiling, and floor give way to mud and dirt. The smell"
                + "\nof rot is almost unbearable. The western half of the room is a river, with black water and"
                + "\nquick moving currents. There is no way you could determine where it leads.");
        Room room24 = new Room("room24", "The wooden floor creaks as you make your way across it. To the north, the"
                + "\nhallway is barely larger than a crawlspace, while to the east and west it continues uninterrupted.");
        Room room25 = new Room("room25", "While most rooms so far have been somewhat dimly lit, this room is almost pitch"
                + "\nblack. You use the creaking of the floor boards to navigate. You freeze for moment when you think you"
                + "\nhear another set of footsteps, but you convince youself it was your mind playing tricks on you.");
        Room room26 = new Room("room26", "The wooden rooms give way to more stone. You are certain you can hear a breeze"
                + "\ncoming from the north...");
        Room room27 = new Room("room27", "A stone corner room. You are now certain that you can hear a breeze to the east. You even"
                + "\nswear that you can feel it now.");
        Room room28 = new Room("room28", "The room is small and claustrophobic. You have to hunch over to make your way through it."
                + "\nThe silence is shattered by the noisy creaking of wood as you bumb up against the floor and cieling.");
        Room room29 = new Room("room29", "Here, the have to crawl to continue. The room is completely dark other than some light"
                + "\nthat escapes the exits. You don't dare think of what could be in the shadows with you.");
        Room room30 = new Room("room30", "The room is some kind of lab. Strange equiptment of unknown use line the walls. You"
                + "\nrealise that it may be better that you are alone here...");
        Room room31 = new Room("room31", "This room mediates between the stone and wood sections of the dungeon. To the south, you feel a chill"
                + "\nmoisture. To the north, you can see a dimly lit wooden room. To the east, there is a small exit somewhat covered by"
                + "\nwooden beams, as if to warn you off...");
        Room exit = new Room("exit", "The hallway gives way to the outside.");
    
        //Entrance
        entrance.setExit("north", room1);
        rooms.add(entrance);
        
        //Room1
        room1.setExit("north", room2);
        room1.setExit("east", room4);
        room1.setExit("west", room5);
        rooms.add(room1);
        
        //Room2
        room2.setExit("north", room9);
        room2.setExit("east", room3);
        room2.setExit("south", room1);
        room2.setExit("west", room8);
        rooms.add(room2);
        
        //Room3
        room3.setExit("north", room31);
        room3.setExit("east", room22);
        room3.setExit("south", room4);
        room3.setExit("west", room2);
        rooms.add(room3);
        
        //Room4
        room4.setExit("north", room3);
        room4.setExit("east", room21);
        room4.setExit("west", room1);
        rooms.add(room4);
        
        //Room5
        room5.setExit("east", room1);
        room5.setExit("west", room6);
        rooms.add(room5);
        
        //Room6
        room6.setExit("north", room7);
        room6.setExit("east", room5);
        room6.setExit("west", room30);
        rooms.add(room6);
        
        //Room7
        room7.setExit("north", room10);
        room7.setExit("south", room6);
        room7.setExit("west", room16);
        rooms.add(room7);
        
        //Room8
        room8.setExit("north", room11);
        room8.setExit("east", room2);
        rooms.add(room8);
        
        //Room9
        room9.setExit("south", room2);
        rooms.add(room9);
        
        //Room10
        room10.setExit("north", room13);
        room10.setExit("east", room11);
        room10.setExit("south", room7);
        rooms.add(room10);
        
        //Room11
        room11.setExit("north", room12);
        room11.setExit("south", room8);
        room11.setExit("west", room10);
        rooms.add(room11);
        
        //Room12
        room12.setExit("north", room28);
        room12.setExit("east", room24);
        room12.setExit("south", room11);
        room12.setExit("west", room13);
        rooms.add(room12);
        
        //Room13
        room13.setExit("east", room12);
        room13.setExit("south", room10);
        room13.setExit("west", room14);
        rooms.add(room13);
        
        //Room14
        room14.setExit("north", room15);
        room14.setExit("east", room13);
        rooms.add(room14);
        
        //Room15
        room15.setExit("south", room14);
        rooms.add(room15);
        
        //Room16
        room16.setExit("east", room7);
        room16.setExit("south", room30);
        rooms.add(room16);
        
        //Room17
        room17.setExit("east", room18);
        rooms.add(room17);
        
        //Room18
        room18.setExit("east", room19);
        room18.setExit("west", room17);
        rooms.add(room18);
        
        //Room19
        room19.setExit("north", room20);
        room19.setExit("west", room18);
        rooms.add(room19);
        
        //Room20
        rooms.add(room20);
        
        //Room21
        room21.setExit("north", room22);
        room21.setExit("east", room23);
        room21.setExit("west", room4);
        rooms.add(room21);
        
        //Room22
        room22.setExit("south", room21);
        room22.setExit("west", room3);
        rooms.add(room22);
        
        //Room23
        room23.setExit("west", room21);
        rooms.add(room23);
        
        //Room24
        room24.setExit("north", room29);
        room24.setExit("east", room25);
        room24.setExit("west", room12);
        rooms.add(room24);
        
        //Room25
        room25.setExit("east", room26);
        room25.setExit("south", room31);
        room25.setExit("west", room24);
        rooms.add(room25);
        
        //Room26
        room26.setExit("north", room27);
        room26.setExit("west", room25);
        rooms.add(room26);
        
        //Room27
        room27.setExit("east", exit);
        room27.setExit("south", room26);
        rooms.add(room27);
        
        //Room28
        room28.setExit("east", room29);
        room28.setExit("south", room12);
        rooms.add(room28);
        
        //Room29
        room29.setExit("south", room24);
        room29.setExit("west", room28);
        rooms.add(room29);
        
        //Room30
        room30.setExit("north", room16);
        room30.setExit("east", room6);
        rooms.add(room30);
        
        //Room31
        room31.setExit("north", room25);
        room31.setExit("east", room17);
        room31.setExit("south", room3);
        rooms.add(room31);
        
        //Exit
        rooms.add(exit);
        
        return entrance;
    }
    
    /**
     * Makes the player choose their difficulty.
     * @throws Exception 
     */
    public void chooseDifficulty() throws Exception {
        boolean done = false;
        DifficultyContext context = new DifficultyContext();
        String choice;
        
        while(!done) {
            System.out.println("What difficulty would you like? Please enter either \"easy\" or \"hard\""
                    + "\nDifficulty affects how many items there are and how much health you start with."
                    + "\n(HINT: Quotations are not required for commands in this game.)");
            
            synchronized(queue) {
                while(queue.isEmpty()) {
                    queue.wait();
                }
                choice = queue.remove();
                
                if(choice.toLowerCase().equals("easy") || choice.toLowerCase().equals("hard")) {
                    if(choice.toLowerCase().equals("hard")) {
                        context.setStrategy(new HardDifficultyStrategy());
                    }
                    else {
                        context.setStrategy(new EasyDifficultyStrategy());
                    }
                    
                    context.setDifficulty(player, parser);
                    done = true;
                }
                else {
                    System.out.println("That is not a valid difficulty.\n");
                }
            }
        }  
    }
    
    public void createGui(Gui userInterface) {
        //Build GUI
        JFrame frame = new JFrame("The Dungeon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(userInterface);
        frame.pack();
        
        //Set print output area to GUI's outputArea
        PrintStream printStream = new PrintStream(new TextOutput(userInterface.outputArea));
        System.setOut(printStream);
        
        //Action listener in GUI's input area that reacts when enter is pressed.
        userInterface.inputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                synchronized(queue) {
                    queue.add(userInterface.inputArea.getText());
                    queue.notify();
                    userInterface.inputArea.setText("");
                }
            }
        });
    }
    
    public void printWelcome() {
        System.out.println("You awaken. \"Where am I?\", you think to yourself. You appear to be in some kind of cell."
                + "\nThe walls floor and cieling are all made of stone. To the north, there is an open barred gate.");
        System.out.println("(HINT: If you are lost, enter \"help\" for a list of commands.)");
    }
    
    public void printGoodEnd() {
        System.out.println("Your pace quickens as you near the exit. You are certain you are being persued. As you exit the dungeon,"
                + "the midday light blinds you, but you manage to shut the heavy stone door behind you. You sit down with your back against"
                + "\nthe wall and catch your breath.");
        System.out.println("Congratulations, you won!");
    }
    
    public void printBadEnd() {
        System.out.println("As it catches you, you finally get a good look at the monster. You can not describe it, however,"
                + "\nas it defies words. You scream.");
        System.out.println("Sorry, you lost.");
    }
    
    public void play() throws Exception {
        boolean finished = false;
        String userInput;
        
        //Add events
        Event observer = new Event();
        new Room1Observer(observer);
        new Room17Observer(observer);
        new Room20Observer(observer);
        new MonsterObserver(observer);
        new ItemObserver(observer);
        
        printWelcome();
        
        //Player cannot walk backwards in entrance
        player.deleteArchive();
        
        while(!finished) {
            System.out.println("\nWhat would you like to do?");
            synchronized(queue) {
                while(queue.isEmpty()) {
                    queue.wait();
                }
                userInput = queue.remove(0);
                Command command = parser.getCommand(userInput);
                
                if(command == null) {
                    System.out.println("That is not something you can do. (HINT: Enter \"help\" for a list of commands.)");
                }
                else {
                    finished = command.execute(player);
                    
                    //When player moves, monster moves.
                    if(command.getName().equals("move")) {
                        monster.go();
                    }
                    
                    //events
                    observer.notifyObservers(player, monster, observer);
                    
                    //win state
                    if(player.getCurrentRoom().getName().equals("exit")) {
                        printGoodEnd();
                        finished = true;
                    }
                    //lose state
                    else if(player.getLives() <= 0) {
                        printBadEnd();
                        finished = true;
                    }
                }
            }
        }
    }
}
