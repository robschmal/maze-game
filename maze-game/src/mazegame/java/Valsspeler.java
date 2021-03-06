
package mazegame.java;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorn
 */
public class Valsspeler extends Veld implements SpeciaalVeld {
    int waarde = 20;
    
    public Valsspeler() {
        super(true);  //een veld met een valsspeler is altijd toeganklijk
        
        //laad de afbeelding van een valsspeler
        try {
            afbeelding = ImageIO.read(new File("src/mazegame/resources/images/valsspeler.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doeSpecialeActie(Held held) {
        //verminder het aantal gezette stappen van de held met de waarde van de valsspeler
        if (held.getGezetteStappen() >= waarde) {
            held.setGezetteStappen(held.getGezetteStappen()-waarde);
        }
    }
}
