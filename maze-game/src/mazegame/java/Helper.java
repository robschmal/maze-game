package mazegame.java;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class Helper extends Veld implements SpeciaalVeld {
    //lijst met de velden die de optimale route vormen
    ArrayList<Veld> optimaleRoute = new ArrayList<>();
    
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
    public void doeSpecialeActie(Held speler) {
        BufferedImage veldAfbeelding;        
        //van elk veld op de optimale route wordt de afbeelding opgehaald, aangepast en teruggezet
        //de afbeelding van het veld krijgt een rand in een kleur naar keuze
        for (Veld veld : optimaleRoute) {
            veldAfbeelding = veld.getAfbeelding();            
            for (int x=0; x<veldAfbeelding.getWidth(); x++) {            
                //aan de meest linker en meest rechter zijde worden alle pixels
                //van boven naar beneden gekleurd, zodat je de linker en rechter rand krijgt
                if (x == 0 || x == veldAfbeelding.getWidth()-1) {
                    for (int y=0; y<veldAfbeelding.getHeight(); y++) {
                        veldAfbeelding.setRGB(x, y, Color.green.getRGB());
                    }
                }
                //daartussenin worden alleen de bovenste en onderste pixel gekleurd, zodat je
                //uiteindelijk de boven en onder rand krijgt
                else {
                    veldAfbeelding.setRGB(x, 0, Color.green.getRGB());
                    veldAfbeelding.setRGB(x, veldAfbeelding.getHeight()-1, Color.green.getRGB());
                }
            }
            veld.setAfbeelding(veldAfbeelding);
        }
    }
    
    public void setOptimaleRoute(ArrayList<Veld> optimaleRoute) {
        this.optimaleRoute = optimaleRoute;
    }
}
