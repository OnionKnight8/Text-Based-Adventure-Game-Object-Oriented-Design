package finalproject;

import java.util.LinkedList;
import java.io.PrintStream;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Patrick Dooley
 * @date 11/7/2018
 * @description: Driver class. Contains main(). Program is multithreaded so "logic"
 * thread can run parallel to swing thread. This allows the program to output everything
 * to the gui and to wait for input from the gui to progress.
 */
public class FinalProject {
    
    String userInput;

    public static void main(String[] args) throws Exception {
        new FinalProject();
    }
    
    public FinalProject() throws Exception {
        Gui userInterface = new Gui();
        boolean finished = false;
        final LinkedList<String> queue = new LinkedList<String>();
        
        JFrame frame = new JFrame("Dungeon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(userInterface);
        frame.pack();
        
        PrintStream printStream = new PrintStream(new TextOutput(userInterface.outputArea));
        System.setOut(printStream);
        
        /**
         * This is the Action Listener that takes the user's input
         * from the input area when enter is pressed.
         */
        userInterface.inputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                synchronized(queue) {
                    queue.add(userInterface.inputArea.getText());
                    queue.notify();
                }
            }
        });
        
        System.out.println("TODO: Add prompt");
        while(!finished) {
            synchronized(queue) {
                while(queue.isEmpty()) {
                    queue.wait();
                }
                userInput = queue.remove(0);
            }
        }
    }
    
}
