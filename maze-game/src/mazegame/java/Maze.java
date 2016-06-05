package mazegame.java;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1250;
    private static final int HEIGHT = 700;
    static JFrame frame = new JFrame("Doolhofspel");
    static JPanel levelKeuzes = new JPanel(), speelVeld = new JPanel();
    static JButton level01 = new JButton("Level 1");
    static JButton level02 = new JButton("Level 2");
    static JButton level03 = new JButton("Level 3");
    static JLabel stappen = new JLabel("Resterende stappen:");
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
        levelKeuzes.add(stappen);
        levels[0].resetLevel();
        toonResterendeStappen(levels[0].berekenResterendeStappen());
        
        speelVeld.setLayout(new BorderLayout());
        speelVeld.add(levelKeuzes, BorderLayout.NORTH);        
        speelVeld.add(levels[0], BorderLayout.CENTER);
        
        frame.addKeyListener(new pijltjesToets());        
        frame.add(speelVeld);
        frame.setSize(WIDTH, HEIGHT);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);              
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        while(true) {}
    }
    
    static private void toonResterendeStappen(int aantalStappen) {
        stappen.setText("Je mag nog " + Integer.toString(aantalStappen) + " stappen zetten");
    }
    
    static class ClickListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == level01) {
                levels[0].resetLevel();
                toonResterendeStappen(levels[0].berekenResterendeStappen());
            }
            else if (e.getSource() == level02) {
                
            }
            else {
                
            }
            frame.requestFocus();
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
            toonResterendeStappen(levels[0].berekenResterendeStappen());            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    }
}