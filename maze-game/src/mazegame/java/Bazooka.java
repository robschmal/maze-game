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
public class Bazooka extends Veld implements SpeciaalVeld {
    
    public Bazooka() {
        super(true); //een veld met een bazooka is altijd toeganklijk
        
        //laad de afbeelding van een bazooka
        try {
            afbeelding = ImageIO.read(new File("src/mazegame/resources/images/bazooka.bmp"));
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doeSpecialeActie(Speler speler) {
        //verhoog het aantal bazookas van de speler met één
        speler.setAantalBazookas(speler.getAantalBazookas() + 1);
    }
    
    //static functie zodat deze op de klasse kan worden aangeroepen
    //een bazooka kan pas later worden gebruikt als er geen bazooka object voorhanden is
    static public void schietBazooka(Veld[][] velden, int x, int y, Richting richting, final int BREEDTE, final int HOOGTE) {        
            int begin = 0, eind = 0, stap = 0;           
            
            //bepaal begin en eind van de rij velden waarin de speler op een muur schiet
            switch (richting) {
                case omhoog:
                    begin = y - 1;                      //y positie van de speler
                    eind = 0;                           //bovenkant van het speelveld
                    stap = -1;                          //de speler schiet omhoog, dus y wordt minder
                break;
                    
                case omlaag:
                    begin = y + 1;                      //y psoitie van de speler
                    eind = HOOGTE;                      //onderkant van het speelveld
                    stap = 1;                           //de speler schiet omlaag, dus y wordt meer
                break;
                    
                case naarLinks:
                    begin = x - 1;                      //x positie van de speler
                    eind = 0;                           //linkerkant van het speelveld
                    stap = -1;                          //de speler schiet naar links, dus x wordt minder
                break;
                    
                case naarRechts:
                    begin = x + 1;                      //x positie van de speler
                    eind = BREEDTE;                     //rechterkant van het speelveld
                    stap = 1;                           //de speler schiet naar rechts, dus x wordt meer
                break;                 
            }
            
            //ga deze rij velden af tot je een muur tegenkomt
            //als je een veld tegenkomt dat niet toeganklijk is is dat een muur en wordt deze vervangen door een leeg veld
            for (int n=begin; n!=eind+stap; n+=stap) {
                if ((richting == Richting.omhoog || richting == Richting.omlaag) && velden[n][x].getToeganklijk() == false) {                    
                    velden[n][x] = new Veld(true);
                    break;
                }
                else if ((richting == Richting.naarLinks || richting == Richting.naarRechts) && velden[y][n].getToeganklijk() == false) {
                    velden[y][n] = new Veld(true);
                    break;
                }
            }            
        }
}
