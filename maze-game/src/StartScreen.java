import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartScreen extends JPanel implements ActionListener {
        
    JButton level01 = new JButton("Level 1");
    JButton level02 = new JButton("Level 2");
    JButton level03 = new JButton("Level 3");
    
    public StartScreen() {
        this.add(level01);
        this.add(level02);
        this.add(level03);
        level01.addActionListener(this);
        level02.addActionListener(this);
        level03.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
