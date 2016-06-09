package mazegame.java;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1250;
    private static final int HEIGHT = 700;
    static JFrame frame = new JFrame("Maze game");
    static JPanel frameBovenin = new JPanel();
    static JButton level01 = new JButton("Level 1");
    static JButton level02 = new JButton("Level 2");
    static JButton level03 = new JButton("Level 3");
    static JLabel stappen = new JLabel();
    static JLabel bazookas = new JLabel();
    static Level[] levels = new Level[3];
    static Level level = new Level();
    
    public static void main(String[] args) {
        levels[0] = new Level();
        levels[1] = new Level();
        levels[2] = new Level();        
        level01.addActionListener(new ClickListener());
        level02.addActionListener(new ClickListener());
        level03.addActionListener(new ClickListener());
        
        frameBovenin.add(level01);
        frameBovenin.add(level02);
        frameBovenin.add(level03);
        frameBovenin.add(stappen);
        frameBovenin.add(bazookas);
       
        frame.add(frameBovenin, BorderLayout.NORTH);        
        frame.add(levels[0], BorderLayout.CENTER);
        
        frame.addKeyListener(new pijltjesToets());
        frame.setSize(WIDTH, HEIGHT);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);              
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        
        level = levels[0];
        level.resetLevel();
        toonSpelerStatus();
        while(true) {}
    }
    
    static private void toonSpelerStatus() {
        switch (level.getResterendeStappen()) {
            case 0:
                stappen.setText("  Je hebt geen stappen meer over!  ");
            break;
                
            case 1:
                stappen.setText("  Je mag nog maar één stap zetten!  ");
            break;
                
            default:
                stappen.setText("  Je mag nog " + Integer.toString(levels[0].getResterendeStappen()) + " stappen zetten  ");
            break;    
        }
        
        switch (level.getSpelerZijnAantalBazookas()) {
            case 0:
                bazookas.setText("Je hebt geen bazooka's");
            break;
                
            case 1:
                bazookas.setText("Je hebt één bazooka");
            break;
                
            default:
                bazookas.setText("Je hebt " + Integer.toString(levels[0].getSpelerZijnAantalBazookas()) + " bazooka's");
            break;
        }       
    }
    
    static class ClickListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == level01) {
                                
            }
            else if (e.getSource() == level02) {
                
            }
            else {
                
            }
            level.resetLevel();
            toonSpelerStatus();
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
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                level.schietBazooka();
            }
            else {
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
                level.verplaatsSpeler(richting);                
            }
            toonSpelerStatus();
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    }
}