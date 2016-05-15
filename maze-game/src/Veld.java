import java.awt.Graphics;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorn
 */
public class Veld extends JComponent {
    int x, y, hoogteBreedte;
    String afbeelding;
    boolean toeganklijk;    
    
    public Veld(int x, int y, int hoogteBreedte, String afbeelding, boolean toeganklijk) {
        this.x = x;
        this.y = y;                
        this.hoogteBreedte = hoogteBreedte;
        this.afbeelding = afbeelding;
        this.toeganklijk = toeganklijk;
    }
       
    public String getAfbeelding() {
        return afbeelding;
    }
    
    public boolean getToeganklijk() {
        return toeganklijk;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(x * hoogteBreedte, y * hoogteBreedte, hoogteBreedte, hoogteBreedte);
    }
}