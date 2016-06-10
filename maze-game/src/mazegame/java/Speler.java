package mazegame.java;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
public class Speler {        
    private BufferedImage spelerAfbeelding;
    private int positieX, positieY;
    private Richting richting = Richting.omlaag;
    private int gezetteStappen;
    private int bazookas;
    
    public Speler(String afbeelding) {
        try {
            spelerAfbeelding = ImageIO.read(new File("src/mazegame/resources/images/" + afbeelding + ".bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getAfbeelding() {
        AffineTransform rotatie = new AffineTransform();
        rotatie.rotate(richting.ordinal() * 0.5 * Math.PI, spelerAfbeelding.getWidth()/2, spelerAfbeelding.getHeight()/2);
        return new AffineTransformOp(rotatie, AffineTransformOp.TYPE_BILINEAR).filter(spelerAfbeelding, null);
    }
    
    public void setPositie(int x, int y) {
        positieX = x;
        positieY = y;
    }
    
    public int getX() {
        return positieX;
    }
    
    public int getY() {
        return positieY;
    }
    
    public void setRichting(Richting richting) {
        this.richting = richting;
    }
    
    public Richting getRichting() {
        return richting;
    }
    
    public void setGezetteStappen(int gezetteStappen) {
        this.gezetteStappen = gezetteStappen;
    }
    
    public int getGezetteStappen() {
        return gezetteStappen;
    }
    
    public void setAantalBazookas(int bazookas) {
        this.bazookas = bazookas;
    }
    
    public int getAantalBazookas() {
        return bazookas;
    }   
}
