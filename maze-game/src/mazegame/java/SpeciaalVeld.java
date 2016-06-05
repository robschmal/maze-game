/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.java;

/**
 *
 * @author Jorn
 */
//abstracte tussenklasse tussen Veld en Bazooka, Helper en Valsspeler
//om te zorgen dat deze drie doeSpecialeActie implementeren maar Veld zelf niet
public abstract class SpeciaalVeld extends Veld {
    
    public SpeciaalVeld(boolean toeganklijk) {
        super(toeganklijk);
    }
    
    public abstract void doeSpecialeActie(Veld[][] velden, Speler speler);
}
