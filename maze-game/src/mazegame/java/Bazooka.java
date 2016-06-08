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
public class Bazooka extends SpeciaalVeld {
    
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
    public void doeSpecialeActie(Veld[][] speelveld, Speler speler, Level level) {
        //verhoog het aantal bazookas van de speler met één
        speler.setAantalBazookas(speler.getAantalBazookas() + 1);
        
        //speciale dingen kan je maar één keer gebruiken dus vervang deze door een leeg veld als de speler er op is geweest 
        speelveld[speler.getPositie().y][speler.getPositie().x] = new Veld(true);
    }
    
    //static functie zodat je deze op de klasse aan kan roepen
    //een bazooka kan je immers pas later gebruiken als je al niet meer op het bazooka veld bent en geen bazooka object voorhanden hebt
    static public void schietBazooka(Veld[][] velden, Speler speler, final int BREEDTE, final int HOOGTE) {
        if (speler.getAantalBazookas() > 0) {                           //als de speler bazooka's heeft
            int begin = 0, eind = 0, stap = 0;
            Positie spelerPositie = speler.getPositie();                //variabele om niet steeds opnieuw speler.getPositie aan te hoeven roepen
            speler.setAantalBazookas(speler.getAantalBazookas() - 1);   //verminder het aantal bazooka's van de speler met één
            
            //bepaal begin en eind van de rij velden waarin je op en muur schiet
            switch (speler.getRichting()) {
                case omhoog:
                    begin = spelerPositie.y - 1;        //y positie van de speler
                    eind = 0;                           //bovenkant van het speelveld
                    stap = -1;                          //je schiet omhoog, dus y wordt minder
                break;
                    
                case omlaag:
                    begin = spelerPositie.y + 1;        //y psoitie van de speler
                    eind = HOOGTE;                      //onderkant van het speelveld
                    stap = 1;                           //je schiet omlaag, dus y wordt meer
                break;
                    
                case naarLinks:
                    begin = spelerPositie.x - 1;        //x positie van de speler
                    eind = 0;                           //linkerkant van het speelveld
                    stap = -1;                          //je schiet naar links, dus x wordt minder
                break;
                    
                case naarRechts:
                    begin = spelerPositie.x + 1;        //x positie van de speler
                    eind = BREEDTE;                     //rechterkant van het speelveld
                    stap = 1;                           //je schiet naar rechts, dus x wordt meer
                break;                 
            }
            
            //ga deze rij velden af tot je een muur tegenkomt
            //de loop stopt wanneer je bij een muur of één stap voorbij het eind bent (eind zelf moet ook worden bekeken)
            for (int n=begin; n!=eind+stap; n+=stap) {
                //als je omhoog of omlaag schiet verander je de y positie, x blijft constant
                if ((speler.getRichting() == Richting.omhoog || speler.getRichting() == Richting.omlaag)
                    && velden[n][spelerPositie.x].getToeganklijk() == false) {
                    //als je een veld tegenkomt dat niet toeganklijk is dan is dat een muur en wordt deze vervangen door een leeg veld
                    velden[n][spelerPositie.x] = new Veld(true);
                    break;
                }
                //als je naar links of naar rechts schiet verander je de x positie, y blijft constant
                else if ((speler.getRichting() == Richting.naarLinks || speler.getRichting() == Richting.naarRechts)
                    && velden[spelerPositie.y][n].getToeganklijk() == false) {
                    velden[spelerPositie.y][n] = new Veld(true);
                    break;
                }
            }
            
        }
    }
}
