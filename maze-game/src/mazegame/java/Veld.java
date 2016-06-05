package mazegame.java;

import java.awt.image.BufferedImage;
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
public class Veld {
    private boolean toeganklijk;
    protected BufferedImage afbeelding;
    
    public Veld(boolean toeganklijk) {
        this.toeganklijk = toeganklijk; //geeft aan of je op het veld mag staan of niet
        setAfbeelding();
        //laad de afbeelding van een veld
        //wordt in overerverende klassen overnieuw gedaan
        
    }
    
    public void setToeganklijk(boolean toeganklijk) {
        this.toeganklijk = toeganklijk;
        setAfbeelding();
    }
    
    public boolean getToeganklijk() {
        return toeganklijk;
    }
    
    private void setAfbeelding() {
        try {
            if (toeganklijk) {
                //een toeganklijk veld zonder iets bijzonders is een leeg veld
                afbeelding = ImageIO.read(new File("src/mazegame/resources/images/veld.bmp"));
            }
            else {
                //een ontoeganklijk veld is een muur
                afbeelding = ImageIO.read(new File("src/mazegame/resources/images/muur1.bmp"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getAfbeelding() {
        return afbeelding;
    }       
}