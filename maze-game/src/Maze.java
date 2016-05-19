import java.awt.event.*;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 1000;
    static JFrame frame = new JFrame("Doolhofspel");
    static JPanel levelKeuzes = new JPanel();
    static JButton level01 = new JButton("Level 1");
    static JButton level02 = new JButton("Level 2");
    static JButton level03 = new JButton("Level 3");
    static Level[] levels = new Level[3];
    
    public static void main(String[] args) {
        levels[0] = new Level();
        levels[1] = new Level();
        levels[2] = new Level();
        
        level01.addActionListener(new ClickListener());
        level02.addActionListener(new ClickListener());
        level03.addActionListener(new ClickListener());
        levelKeuzes.add(level01);        
        levelKeuzes.add(level02);
        levelKeuzes.add(level03);     
        
        frame.addKeyListener(new pijltjesToets());        
        frame.add(levels[0]);        
        frame.setSize(WIDTH, HEIGHT);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        while(true) {}
    }
    
    static class ClickListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == level01) {
                frame.add(levels[0]);               
            }
            else if (e.getSource() == level02) {
                frame.add(levels[1]);
            }
            else {
                frame.add(levels[2]);
            }
        }
    }
    
    static class pijltjesToets implements KeyListener {
        Richting richting;
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    richting = Richting.omhoog;
                break;
              
                case KeyEvent.VK_DOWN:
                    richting = Richting.omlaag;
                break;
                    
                case KeyEvent.VK_LEFT:
                    richting = Richting.naarLinks;
                break;
                    
                case KeyEvent.VK_RIGHT:
                    richting = Richting.naarRechts;
                break;
            }
            levels[0].verplaatsSpeler(richting);
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    }
}