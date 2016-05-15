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
    static Veld test = new Veld(0, 0, 50, "", false);
    static Level[] levels = new Level[3];
    
    public static void main(String[] args) {        
        level01.addActionListener(new ClickListener());
        level02.addActionListener(new ClickListener());
        level03.addActionListener(new ClickListener());
        levelKeuzes.add(level01);
        levelKeuzes.add(level02);
        levelKeuzes.add(level03);
        levelKeuzes.add(test);
        frame.add(levelKeuzes);
        
        levels[0] = new Level();
        levels[1] = new Level();
        levels[2] = new Level();
        
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
                levels[0].laadDoolhof(frame);
            }
            else if (e.getSource() == level02) {
                levels[1].laadDoolhof(frame);
            }
            else {
                levels[2].laadDoolhof(frame);
            }
        }
    }
}