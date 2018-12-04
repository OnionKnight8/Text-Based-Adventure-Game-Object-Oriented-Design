package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author Patrick Dooley
 * @date 12/05/2018
 * @description: The games "director". Contains the loop that keeps the game
 * running and sets up the rooms within the game.
 */
public class GameManager {
    
    private InputParser parser;
    private Player player;
    private Gui userInterface;
    final LinkedList<String> queue;
    
    public GameManager() {
        player = new Player(gameSetup());
        parser = new InputParser();
        
        userInterface = new Gui();
        createGui(userInterface);
        
        queue = new LinkedList<String>();
    }
    
    public Room gameSetup() {
        
        Room entrance = new Room("The entrance");
        Room room1 = new Room("The 1st room");
        Room room2 = new Room("The 2nd room");
        Room room3 = new Room("The 3rd room");
        Room room4 = new Room("The 4th room");
        Room room5 = new Room("The 5th room");
        Room room6 = new Room("The 6th room");
        Room room7 = new Room("The 7th room");
        Room room8 = new Room("The 8th room");
        Room room9 = new Room("The 9th room");
        Room room10 = new Room("The 10th room");
        Room room11 = new Room("The 11th room");
        Room room12 = new Room("The 12th room");
        Room room13 = new Room("The 13th room");
        Room room14 = new Room("The 14th room");
        Room room15 = new Room("The 15th room");
        Room room16 = new Room("The 16th room");
        Room room17 = new Room("The 17th room");
        Room room18 = new Room("The 18th room");
        Room room19 = new Room("The 19th room");
        Room room20 = new Room("The 20th room");
        Room room21 = new Room("The 21st room");
        Room room22 = new Room("The 22nd room");
        Room room23 = new Room("The 23rd room");
        Room room24 = new Room("The 24th room");
        Room room25 = new Room("The 25th room");
        Room room26 = new Room("The 26th room");
        Room room27 = new Room("The 27th room");
        Room room28 = new Room("The 28th room");
        Room room29 = new Room("The 29th room");
        Room room30 = new Room("The 30th room");
        Room room31 = new Room("The 31st room");
        Room exit = new Room("The exit");
    
        //Entrance
        entrance.setExit("north", room1);
        
        //Room1
        room1.setExit("north", room2);
        room1.setExit("east", room4);
        room1.setExit("west", room5);
        
        //Room2
        room2.setExit("south", room1);
        room2.setExit("east", room3);
        room2.setExit("west", room8);
        room2.setExit("north", room9);
        
        //Room3
        room3.setExit("west", room2);
        room3.setExit("south", room4);
        room3.setExit("north", room31);
        room3.setExit("east", room22);
        
        //Room4
        room4.setExit("west", room1);
        room4.setExit("north", room3);
        room4.setExit("east", room21);
        
        //Room5
        room5.setExit("east", room1);
        room5.setExit("west", room6);
        
        //Room6
        room6.setExit("east", room5);
        room6.setExit("north", room7);
        room6.setExit("west", room30);
        
        //Room7
        room7.setExit("south", room6);
        room7.setExit("north", room10);
        room7.setExit("west", room16);
        
        //Room8
        room8.setExit("east", room2);
        room8.setExit("north", room11);
        
        //Room9
        room9.setExit("south", room2);
        
        //Room10
        room10.setExit("south", room7);
        room10.setExit("east", room11);
        room10.setExit("north", room13);
        
        //Room11
        room11.setExit("south", room8);
        room11.setExit("west", room10);
        room11.setExit("north", room12);
        
        //Room12
        room12.setExit("south", room11);
        room12.setExit("west", room13);
        room12.setExit("east", room24);
        room12.setExit("north", room28);
        
        //Room13
        room13.setExit("south", room10);
        room13.setExit("east", room12);
        room13.setExit("west", room14);
        
        //Room14
        room14.setExit("east", room13);
        room14.setExit("north", room15);
        
        //Room15
        room15.setExit("south", room14);
        
        //Room16
        room16.setExit("east", room7);
        room16.setExit("south", room30);
        
        //Room17
        room17.setExit("east", room18);
        
        //Room18
        room18.setExit("west", room17);
        room19.setExit("east", room19);
        
        //Room19
        room19.setExit("west", room18);
        room19.setExit("north", room20);
        
        //Room20
        
        //Room21
        room21.setExit("west", room4);
        room21.setExit("north", room22);
        room21.setExit("east", room23);
        
        //Room22
        room22.setExit("west", room3);
        room22.setExit("south", room21);
        
        //Room23
        room23.setExit("west", room21);
        
        //Room24
        room24.setExit("west", room12);
        room24.setExit("east", room25);
        room24.setExit("north", room29);
        
        //Room25
        room25.setExit("west", room24);
        room25.setExit("east", room26);
        room25.setExit("south", room31);
        
        //Room26
        room26.setExit("west", room25);
        room26.setExit("north", room27);
        
        //Room27
        room27.setExit("south", room26);
        room27.setExit("east", exit);
        
        //Room28
        room28.setExit("south", room12);
        room28.setExit("west", room29);
        
        //Room29
        room29.setExit("south", room24);
        room29.setExit("west", room28);
        
        //Room30
        room30.setExit("east", room6);
        room30.setExit("north", room16);
        
        //Room31
        room31.setExit("south", room3);
        room31.setExit("east", room17);
        room31.setExit("north", room25);
        
        return entrance;
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
        System.out.println("todo: add a greeting");
        System.out.println("If you are lost, enter \"help\" for a list of commands.");
    }
    
    public void play() throws Exception {
        boolean finished = false;
        String userInput;
        
        printWelcome();
        
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
                }
            }
        }
    }
}
