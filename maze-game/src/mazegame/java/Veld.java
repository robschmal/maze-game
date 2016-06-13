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
    private boolean toegankelijk;
    protected BufferedImage afbeelding;
    
    public Veld(boolean toegankelijk) {
        this.toegankelijk = toegankelijk; //geeft aan of je op het veld mag staan of niet
        
        //laad de afbeelding van een veld
        //wordt in overerverende klassen overnieuw gedaan
        try {
            if (toegankelijk) {
                //een toegankelijk veld zonder iets bijzonders is een leeg veld
                afbeelding = ImageIO.read(new File("src/mazegame/resources/images/veld.bmp"));
            }
            else {
                //een ontoegankelijk veld is een muur
                afbeelding = ImageIO.read(new File("src/mazegame/resources/images/muur1.bmp"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void setAfbeelding(BufferedImage afbeelding) {
        this.afbeelding = afbeelding;
    }
    
    public BufferedImage getAfbeelding() {
        return afbeelding;
    } 
    
    public void setToeganklijk(boolean toegankelijk) {
        this.toegankelijk = toegankelijk;
    }
    
    public boolean getToeganklijk() {
        return toegankelijk;
    }              
}