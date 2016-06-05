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
public class Speler {        
    private BufferedImage[] spelerAfbeelding = new BufferedImage[4];
    private Positie positie;
    private Richting richting = Richting.omhoog;
    private int gezetteStappen = 0;
    private int bazookas = 0;
    
    public Speler() {
        try {
            spelerAfbeelding[0] = ImageIO.read(new File("src/mazegame/resources/images/speler.bmp"));
            spelerAfbeelding[1] = ImageIO.read(new File("src/mazegame/resources/images/speler.bmp"));
            spelerAfbeelding[2] = ImageIO.read(new File("src/mazegame/resources/images/speler.bmp"));
            spelerAfbeelding[3] = ImageIO.read(new File("src/mazegame/resources/images/speler.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getAfbeelding() {
        return spelerAfbeelding[richting.ordinal()];
    }
    
    public void setPositie(Positie positie) {
        this.positie = positie;
    }
    
    public Positie getPositie() {
        return positie;
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
    
    public void setBazookas(int bazookas) {
        this.bazookas = bazookas;
    }
    
    public int getBazookas() {
        return bazookas;
    }   
}
