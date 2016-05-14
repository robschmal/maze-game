import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 1000;
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("Doolhofspel");        
        JPanel startScreen = new StartScreen();        
        frame.add(startScreen);        
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);        
    }
}