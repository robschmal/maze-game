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
<<<<<<< HEAD
    static JLabel tijd = new JLabel();
    static Level level = new Level();
    static Timer speeltijdTimer = new Timer(1000, new SpeeltijdTimerEvent());
    static boolean spelActief;
    
    public static void main(String[] args) {       
        level01.addActionListener(new LevelKnop());
        level02.addActionListener(new LevelKnop());
        level03.addActionListener(new LevelKnop());
=======
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
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a
        
        frameBovenin.add(buttonlevel01);
        frameBovenin.add(buttonLevel02);
        frameBovenin.add(buttonLevel03);
        frameBovenin.add(stappen);
        frameBovenin.add(bazookas);
        frameBovenin.add(tijd);
       
        frame.add(frameBovenin, BorderLayout.NORTH);        
        frame.add(level, BorderLayout.CENTER);
        
        speeltijdTimer.setRepeats(true); 
        frame.addKeyListener(new PijltjesToets());
        frame.setSize(WIDTH, HEIGHT);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);              
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        
<<<<<<< HEAD
=======
        currentLevel = levels[0];
        currentLevel.resetLevel();
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a
        toonSpelerStatus();
        spelActief = true;
        speeltijdTimer.start();
        while(true) {}
    }
    
    static private void toonSpelerStatus() {
        switch (currentLevel.getResterendeStappen()) {
            case 0:
                stappen.setText("    Je hebt geen stappen meer over!  ");
            break;
                
            case 1:
                stappen.setText("    Je mag nog maar één stap zetten!  ");
            break;
                
            default:
                stappen.setText("    Je mag nog " + Integer.toString(level.getResterendeStappen()) + " stappen zetten  ");
            break;    
        }
        
        switch (currentLevel.getSpelerZijnAantalBazookas()) {
            case 0:
                bazookas.setText("  Je hebt geen bazooka's  ");
            break;
                
            case 1:
                bazookas.setText("  Je hebt één bazooka  ");
            break;
                
            default:
                bazookas.setText("  Je hebt " + Integer.toString(level.getSpelerZijnAantalBazookas()) + " bazooka's  ");
            break;
        }
        
        if (level.getResterendeTijd() > 0) {
            tijd.setText("  Je hebt nog " + Integer.toString(level.getResterendeTijd()) + " seconden de tijd  ");
        }
        else {
            tijd.setText("  Je tijd is om!  ");
        }
    }
    
    static class LevelKnop implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
            if (e.getSource() == level01) {
                level.laadLevel(1);
            }
            else if (e.getSource() == level02) {
                level.laadLevel(2);
=======
            if (e.getSource() == buttonlevel01) {
                
            }
            else if (e.getSource() == buttonLevel02) {
                
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a
            }
            else {
                level.laadLevel(3);
            }
<<<<<<< HEAD
=======
            currentLevel.resetLevel();
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a
            toonSpelerStatus();
            frame.requestFocus();
            spelActief = true;
            speeltijdTimer.restart();
        }
    }
    
    static class PijltjesToets implements KeyListener {
        Richting richting;
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
            if (spelActief &&
                (e.getKeyCode() == KeyEvent.VK_SPACE ||
                 e.getKeyCode() == KeyEvent.VK_UP || 
                 e.getKeyCode() == KeyEvent.VK_DOWN || 
                 e.getKeyCode() == KeyEvent.VK_LEFT || 
                 e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                
                spelActief = false;
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    level.schietBazooka();
                }
                else {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            richting = Richting.omhoog;
                        break;
=======
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                currentLevel.schietBazooka();
            }
            else {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        richting = Richting.omhoog;
                    break;
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a

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
                if (level.getResterendeStappen() > 0) {
                    spelActief = true;
                }
<<<<<<< HEAD
=======
                currentLevel.verplaatsSpeler(richting);                
>>>>>>> eac3b7e03ecc677ea8b54f293e73c93a4e787c2a
            }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    }
    
    static class SpeeltijdTimerEvent implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (spelActief) {
                spelActief = false;
                level.setVerstrekenTijd(level.getVerstrekenTijd() + speeltijdTimer.getDelay() / 1000);
                toonSpelerStatus();
                if (level.getResterendeTijd() > 0) {
                    spelActief = true;
                }
            }
        }
    }
}