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
public class Veld {
    String afbeelding;
    boolean toeganklijk;    
    
    public Veld(String afbeelding, boolean toeganklijk) {
        this.afbeelding = afbeelding;
        this.toeganklijk = toeganklijk;
    }
       
    public String getAfbeelding() {
        return afbeelding;
    }
    
    public boolean getToeganklijk() {
        return toeganklijk;
    }        
}