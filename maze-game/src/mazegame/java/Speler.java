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
    private Positie positie;
    private int gezetteStappen=0;
    private BufferedImage spelerAfbeelding;
    
    public Speler() {
        try {
            spelerAfbeelding = ImageIO.read(new File("speler.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void setPositie(Positie positie) {
        this.positie = positie;
        gezetteStappen++;
    }
    
    public Positie getPositie() {
        return positie;
    }
    
    public BufferedImage getAfbeelding() {
        return spelerAfbeelding;
    }
    
    public void setGezetteStappen(int gezetteStappen) {
        this.gezetteStappen = gezetteStappen;
    }
    
    public int getGezetteStappen() {
        return gezetteStappen;
    }
}
