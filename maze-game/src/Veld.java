import java.awt.Color;

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
    private final Color KLEUR_TOEGANKLIJK = Color.green;
    private final Color KLEUR_ONTOEGANKLIJK = Color.gray;
    private boolean toeganklijk;    
    
    public Veld(boolean toeganklijk) {
        this.toeganklijk = toeganklijk;
    }
    
    public boolean getToeganklijk() {
        return toeganklijk;
    }
    
    public Color getKleur() {
        if (toeganklijk) {
            return KLEUR_TOEGANKLIJK;            
        }
        else {
            return KLEUR_ONTOEGANKLIJK;
        } 
    }        
}