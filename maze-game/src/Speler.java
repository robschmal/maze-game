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
public class Speler {    
    private final Color KLEUR = Color.red;
    private Positie positie;
    private int gezetteStappen=0;
    
    public Speler(Positie positie) {
        this.positie = positie;
    }
    
    public void setPositie(Positie positie) {
        this.positie = positie;
        gezetteStappen++;
    }
    
    public Positie getPositie() {
        return positie;
    }
    
    public Color getKleur() {
        return KLEUR;
    }
    
    public int getGezetteStappen() {
        return gezetteStappen;
    }
}
