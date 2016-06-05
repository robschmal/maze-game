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
public class Helper extends SpeciaalVeld {
    Veld[] optimaleRoute = new Veld[30];
    
    public Helper() {
        super(true); //een veld met een helper is altijd toeganklijk
        
        //laad de afbeelding van een helper
        try {
            afbeelding = ImageIO.read(new File("src/mazegame/resources/images/helper.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doeSpecialeActie(Veld[][] speelveld, Speler speler) {
        
    }
}
