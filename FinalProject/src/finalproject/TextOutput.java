package finalproject;

import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Patrick Dooley
 * @date 12/04/2018
 * @description: This class allows System.out to be printed to the output area
 * in the GUI.
 */
public class TextOutput extends java.io.OutputStream {
    private JTextArea outputArea;
    
    public TextOutput(JTextArea outputArea) {
        this.outputArea = outputArea;
    }
    
    /**
     * Redirects all output to the output area and scrolls the output area down
     * when new output is printed.
     * @param length
     * @throws IOException 
     */
    @Override
    public void write(int x) throws IOException {
        outputArea.append(String.valueOf((char)x));
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
}
