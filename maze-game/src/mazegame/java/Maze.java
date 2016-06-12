package mazegame.java;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1250;
    private static final int HEIGHT = 700;
    static JFrame frame = new JFrame("Maze game");
    static JPanel frameBovenin = new JPanel();
    static JButton buttonlevel01 = new JButton("Level 1");
    static JButton buttonLevel02 = new JButton("Level 2");
    static JButton buttonLevel03 = new JButton("Level 3");
    static JLabel stappen = new JLabel();
    static JLabel bazookas = new JLabel();
    static Level[] levels = new Level[4];
    static Level currentLevel = new Level(01);
    
    public static void main(String[] args) {
        levels[0] = currentLevel;
        Level level01 = new Level(01);
        Level level02 = new Level(02);
        Level level03 = new Level(03);
        levels[0] = currentLevel;
        levels[1] = level01;
        levels[2] = level02;
        levels[3] = level03;
        buttonlevel01.addActionListener(new ClickListener());
        buttonLevel02.addActionListener(new ClickListener());
        buttonLevel03.addActionListener(new ClickListener());
        
        frameBovenin.add(buttonlevel01);
        frameBovenin.add(buttonLevel02);
        frameBovenin.add(buttonLevel03);
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
        
        currentLevel = levels[0];
        currentLevel.resetLevel();
        toonSpelerStatus();
        while(true) {}
    }
    
    static private void toonSpelerStatus() {
        switch (currentLevel.getResterendeStappen()) {
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
        
        switch (currentLevel.getSpelerZijnAantalBazookas()) {
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
            if (e.getSource() == buttonlevel01) {
                
            }
            else if (e.getSource() == buttonLevel02) {
                
            }
            else {
                
            }
            currentLevel.resetLevel();
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
                currentLevel.schietBazooka();
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
                currentLevel.verplaatsSpeler(richting);                
            }
            toonSpelerStatus();
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    }
}