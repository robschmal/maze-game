package mazegame.java;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class Level extends JComponent {

    private final int BREEDTE = 35, HOOGTE = 18, AFMETING = 35, MARGE = 10;
    private final Positie BEGIN = new Positie(0, 0);
    private final Positie EIND = new Positie(BREEDTE - 1, HOOGTE - 1);
    private final int MAX_STAPPEN = 70;
    private final int MAX_TIJD = 300;       
    private final String LEVEL =   "RRmmmmmmmmmmmmmmrrrmrrrrrrrrrrrrrrr"
                                 + "mRmmmmmmmrrrrrrrrmHmrmmmmmmmrmmmmmm"
                                 + "mRRRRRRRmrmmmmrmmmrmrmmmrrrrrmmrrrm"
                                 + "mrmmmmmRmrrBrmrrrrrmrmmmrmmmmmmrmmm"
                                 + "mrrrrrmRmmmmrmmmmmmmrmmmrrrrrrrrmmm"
                                 + "mmmmmrmRrrrrrmRRRRRrrmmmmmmmmrmmmmm"
                                 + "mrrrmrmRmmmmmmRmmmRmmmmmmrrrrrmmmmm"
                                 + "mrmrVrmRRRRRRRRmmmRRRRRmmrmmmmmmmmm"
                                 + "mrmmmmmmmmmmmmmmmmmmmmRrrrrrrrrrrmm"
                                 + "mrmrrrrrmmrrrrrrrrmmmmRmmmmmmmmmrmm"
                                 + "mrmmmmmrmmrmmmmrmRRRRRRmmmmmmmmmrmm"
                                 + "mrrrrrrrrrrmrrrrmRmmrmmmmrrrrrrrrmm"
                                 + "mmmmmmmmmmmmrmmmmRmmrmmmmrmmmmmmrmm"
                                 + "rrrrrrrrrrrmrrrrmRmmrrrrrrrrmmmmrmm"
                                 + "rmmmmmmmmmrmmmmrmRmmmmmmmmmrmmmmrmm"
                                 + "rrrrrrrmmmrrrrrrmRmmmmmmmmmrrrrrrmm"
                                 + "mmmmmmrmmmmmmmmmmRRRRRRRRmmmmmmmmmm"
                                 + "mmmmmmrrrrrrrrrrmmmmmmmmRRRRRRRRRRR";    
    private final Speler speler;
    private final Veld[][] speelveld = new Veld[HOOGTE][BREEDTE];

    public Level() {
        speler = new Speler();
        ArrayList<Veld> optimaleRoute = new ArrayList<>();
        ArrayList<Helper> helpers = new ArrayList<>();
        for (int y=0; y<HOOGTE; y++) {
            for (int x=0; x<BREEDTE; x++) {
                switch (LEVEL.charAt((y * BREEDTE) + x)) {
                    case 'R':
                        //bij een hoofdletter r, voeg de positie van het veld toe aan de optimale route
                        speelveld[y][x] = new Veld(true);
                        optimaleRoute.add(speelveld[y][x]);
                    break;
                        
                    case 'r':
                        speelveld[y][x] = new Veld(true);
                    break;
                    
                    case 'B':
                        speelveld[y][x] = new Bazooka();
                    break;
                        
                    case 'H':
                        //voeg helpers toe aan de lijst met helpers
                        speelveld[y][x] = new Helper();
                        helpers.add((Helper) speelveld[y][x]);
                    break;
                        
                    case 'V':
                        speelveld[y][x] = new Valsspeler();
                    break;                                               
                        
                    default:
                        speelveld[y][x] = new Veld(false); //standaard een leeg veld waar je niet op mag
                    break;                        
                }                
            }
        }
        
        //stel alle helpers op de hoogte van de optimale route
        //kan pas aan het eind omdat dan de hele optimale route bekend is
        //wat doorgegeven wordt zijn pointers naar de veld objecten in speelveld
        for (Helper helper : helpers) {
            helper.setOptimaleRoute(optimaleRoute);
        }
    }

    public void verplaatsSpeler(Richting richting) {
        //als de speler geen stappen meer mag zetten of als hij aan de rand van het level is gebeurt er niks
        if (speler.getGezetteStappen() < MAX_STAPPEN) {
            Positie positie = new Positie(speler.getPositie()); //inhoud van de positie van de speler kopieeren
                                                                //zodat deze nog niet gelijk wordt aangepast
            //bepaal je toekomstige positie mits er in de gewenste richting nog een veld is
            if (richting == Richting.omhoog && positie.y > 0) {
                positie.y--;
            } else if (richting == Richting.omlaag && positie.y < HOOGTE - 1) {
                positie.y++;
            } else if (richting == Richting.naarLinks && positie.x > 0) {
                positie.x--;
            } else if (richting == Richting.naarRechts && positie.x < BREEDTE - 1) {
                positie.x++;
            } else {
                return;
            }

            //bepaal of je naar dat veld toe mag en wat er gebeurt als je daar op gaat staan
            if (speelveld[positie.y][positie.x].getToeganklijk()) {            
                speler.setPositie(positie);                
                speler.setGezetteStappen(speler.getGezetteStappen() + 1);
                //als het volgende veld geen gewoon veld is, doe de speciale actie
                if (!(speelveld[positie.y][positie.x].getClass().equals(Veld.class))) {
                    ((SpeciaalVeld) speelveld[positie.y][positie.x]).doeSpecialeActie(speelveld, speler, this);
                }                
                //geef een melding als de speler bij het eind van het level is of als zijn stappen op zijn
                if (positie.equals(EIND)) {
                    JOptionPane.showOptionDialog(this, "Je hebt het doolhof uitgespeeld!", null, 0, 2, null, new String[]{"OK"}, 0);
                    resetLevel();
                }
                else if (speler.getGezetteStappen() == MAX_STAPPEN) {
                    JOptionPane.showOptionDialog(this, "Je mag niet meer stappen zetten!", null, 0, 2, null, new String[]{"OK"}, 0);
                } 
            }
            //richting waarin je staat verandert altijd, ook als je niet naar dat veld toe kan
            //zo kan je je bazooka op een muur richting waar je al tegenaan staat
            speler.setRichting(richting);
            this.repaint();
        }
    }
    
    public void schietBazooka() {
        Bazooka.schietBazooka(speelveld, speler, BREEDTE, HOOGTE);
        this.repaint();
    }

    public int getResterendeStappen() {
        //maximum stappen en resterende stappen is iets van het level, gezette stappen iets van de speler
        return MAX_STAPPEN - speler.getGezetteStappen();
    }
    
    public int getAantalBazookas() {
        return speler.getAantalBazookas();
    }
    
    public void resetLevel() {
        speler.setPositie(BEGIN);
        speler.setGezetteStappen(0);
        speler.setAantalBazookas(0);
        this.repaint();
    }
    
    public void verzoekRepaint() {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int y = 0; y < HOOGTE; y++) {
            for (int x = 0; x < BREEDTE; x++) {
                if (y == speler.getPositie().y && x == speler.getPositie().x) {
                    //teken de afbeelding van de speler als op dit veld de speler staat
                    g.drawImage(speler.getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                } else {
                    //teken anders de afbeelding van het veld
                    g.drawImage(speelveld[y][x].getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                }                
            }
        }
    }
}
