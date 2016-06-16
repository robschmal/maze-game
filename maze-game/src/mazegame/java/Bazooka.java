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
public class Bazooka extends Veld implements SpeciaalVeld {
    private static int n, eind, stap, positieX, positieY;
    private static Richting richting;
    private static boolean actief = false;
    private static BufferedImage raketAfbeelding;
    
    public Bazooka() {
        super(true); //een veld met een bazooka is altijd toeganklijk
        
        //laad de afbeelding van een bazooka
        try {
            afbeelding = ImageIO.read(new File("src/mazegame/resources/images/bazooka.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //laad de afbeelding van een bazooka raket als dit nog niet gebeurd is
        if (raketAfbeelding == null) {
            try {
                raketAfbeelding = ImageIO.read(new File("src/mazegame/resources/images/raket.bmp"));
            } catch (IOException ex) {
                Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void doeSpecialeActie(Held held) {
        //verhoog het aantal bazookas van de held met één
        held.setAantalBazookas(held.getAantalBazookas() + 1);
    }
    
    //static functies zodat deze op de klasse kunnen worden aangeroepen
    //een bazooka zou pas later kunnen worden gebruikt als er geen bazooka object voorhanden is
    static public void richtBazooka(int spelerPositieX, int spelerPositieY, Richting spelerRichting, int speelveldBreedte, int speelveldHoogte) {
        int begin;            

        //de raket van de bazooka begint op de plek waar de held staat en vliegt in de richting waarin hij kijkt
        positieX = spelerPositieX;
        positieY = spelerPositieY;
        richting = spelerRichting;

        //bepaal het begin en eind van de rij velden waarin de held schiet
        switch (richting) {
            case omhoog:
                begin = positieY;                   //y positie van de held
                eind = 0;                           //bovenkant van het speelveld
                stap = -1;                          //de held schiet omhoog, dus y wordt minder
            break;

            case omlaag:
                begin = positieY;                   //y positie van de held
                eind = speelveldHoogte;             //onderkant van het speelveld
                stap = 1;                           //de held schiet omlaag, dus y wordt meer
            break;

            case naarLinks:
                begin = positieX;                   //x positie van de held
                eind = 0;                           //linkerkant van het speelveld
                stap = -1;                          //de held schiet naar links, dus x wordt minder
            break;

            default:
                begin = positieX;                   //x positie van de held
                eind = speelveldBreedte;            //rechterkant van het speelveld
                stap = 1;                           //de held schiet naar rechts, dus x wordt meer
            break;                 
        }        
        n = begin;                                  //teller die bijhoudt waar de raket is in de rij met velden
        actief = true;                              //vlag die aangeeft dat de held aan het schieten is
    }
    
    static public void schietBazooka() {                             
        if (actief) {
            //ga de eerder bepaalde rij velden af
            n += stap;

            //als de held omhoog of omlaag schiet gaat de y positie van de raket mee met de teller, anders de x positie
            //de ander van de twee verandert niet
            if (richting == Richting.omhoog || richting == Richting.omlaag) {                    
                positieY = n;
            }
            else if (richting == Richting.naarLinks || richting == Richting.naarRechts) {
                positieX = n;
            }

            //als de raket voorbij de rand van het veld komt stopt het schieten van de bazooka
            //of er wel of niet een muur wordt geraakt houdt het aanroepende level object bij omdat
            //het veld dan moet worden aangepast en dat is iets dat het level doet
            if (n == eind + stap) {
                actief = false;
            }
        }
    }
    
    static public void stopBazooka() {
        actief = false;
    }
    
    static public boolean getActief() {
        return actief;
    }
    
    static public BufferedImage getRaketAfbeelding() {
        AffineTransform rotatie = new AffineTransform();
        rotatie.rotate(richting.ordinal() * 0.5 * Math.PI, raketAfbeelding.getWidth()/2, raketAfbeelding.getHeight()/2);
        return new AffineTransformOp(rotatie, AffineTransformOp.TYPE_BILINEAR).filter(raketAfbeelding, null);
    }
    
    static public int getX() {
        return positieX;
    }
    
    static public int getY() {
        return positieY;
    }
}