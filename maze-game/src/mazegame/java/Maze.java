package mazegame.java;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Maze {
    
    private static final int WIDTH = 1250;
    private static final int HEIGHT = 700;
    static JFrame frame = new JFrame("Maze game");
    static JPanel frameBovenin = new JPanel();
    static JButton level1 = new JButton("Level 1");
    static JButton level2 = new JButton("Level 2");
    static JButton level3 = new JButton("Level 3");
    static JLabel stappen = new JLabel();
    static JLabel bazookas = new JLabel();
    static JLabel tijd = new JLabel();
    static Level speelveld = new Level();
    static Timer speeltijdTimer = new Timer(1000, new SpeeltijdTimerEvent());
    static boolean spelActief;
    
    public static void main(String[] args) {       
        level1.addActionListener(new LevelKnop());
        level2.addActionListener(new LevelKnop());
        level3.addActionListener(new LevelKnop());
        
        frameBovenin.add(level1);
        frameBovenin.add(level2);
        frameBovenin.add(level3);
        frameBovenin.add(stappen);
        frameBovenin.add(bazookas);
        frameBovenin.add(tijd);
       
        frame.add(frameBovenin, BorderLayout.NORTH);        
        frame.add(speelveld, BorderLayout.CENTER);
        
        speeltijdTimer.setRepeats(true); 
        frame.addKeyListener(new PijltjesToets());
        frame.setSize(WIDTH, HEIGHT);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);              
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        
        toonSpelerStatus();
        spelActief = true;
        speeltijdTimer.start();
        while(true) {}
    }
    
    static private void toonSpelerStatus() {
        switch (speelveld.getResterendeStappen()) {
            case 0:
                stappen.setText("    Je hebt geen stappen meer over!  ");
            break;
                
            case 1:
                stappen.setText("    Je mag nog maar één stap zetten!  ");
            break;
                
            default:
                stappen.setText("    Je mag nog " + Integer.toString(speelveld.getResterendeStappen()) + " stappen zetten  ");
            break;    
        }
        
        switch (speelveld.getHeldZijnAantalBazookas()) {
            case 0:
                bazookas.setText("  Je hebt geen bazooka's  ");
            break;
                
            case 1:
                bazookas.setText("  Je hebt één bazooka  ");
            break;
                
            default:
                bazookas.setText("  Je hebt " + Integer.toString(speelveld.getHeldZijnAantalBazookas()) + " bazooka's  ");
            break;
        }
        
        if (speelveld.getResterendeTijd() > 0) {
            tijd.setText("  Je hebt nog " + Integer.toString(speelveld.getResterendeTijd()) + " seconden de tijd  ");
        }
        else {
            tijd.setText("  Je tijd is om!  ");
        }
    }
    
    //nodig om te kunnen testen
    static Level getLevel() {
        return speelveld;
    }
    
    static class LevelKnop implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == level1) {
                speelveld.laadLevel(1);
            }
            else if (e.getSource() == level2) {
                speelveld.laadLevel(2);
            }
            else {
                speelveld.laadLevel(3);
            }
            
            frame.requestFocus();
            toonSpelerStatus();            
            spelActief = true;
            speeltijdTimer.restart();
        }
    }
    
    static class PijltjesToets implements KeyListener {        
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (spelActief &&
                (e.getKeyCode() == KeyEvent.VK_SPACE ||
                 e.getKeyCode() == KeyEvent.VK_UP || 
                 e.getKeyCode() == KeyEvent.VK_DOWN || 
                 e.getKeyCode() == KeyEvent.VK_LEFT || 
                 e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                
                Richting richting = Richting.omhoog;
                spelActief = false;
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                   speelveld.schietBazooka();
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
                    speelveld.verplaatsHeld(richting);                
                }
                toonSpelerStatus();                
                if (speelveld.getResterendeStappen() > 0) {
                    spelActief = true;
                }
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
                speelveld.setVerstrekenTijd(speelveld.getVerstrekenTijd() + speeltijdTimer.getDelay() / 1000);
                toonSpelerStatus();
                if (speelveld.getResterendeTijd() > 0) {
                    spelActief = true;
                }
            }
        }
    }
}