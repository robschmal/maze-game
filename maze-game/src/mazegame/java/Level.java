package mazegame.java;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class Level extends JComponent {

    private final int BREEDTE = 35, HOOGTE = 18, AFMETING = 35, MARGE = 10;
    private final int BEGIN_X = 0;
    private final int BEGIN_Y = 0;
    private final int EIND_X = BREEDTE - 1;
    private final int EIND_Y = HOOGTE - 1;
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
    private final Speler vriend;
    private final Veld[][] speelveld = new Veld[HOOGTE][BREEDTE];

    public Level() {
        speler = new Speler();
        vriend = new Speler();
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
                        speelveld[y][x] = new Veld(false); //een veld is standaard een leeg veld waar je niet op mag
                    break;                        
                }                
            }
        }
        
        //stel alle helpers op de hoogte van de gevonden optimale route
        for (Helper helper : helpers) {
            helper.setOptimaleRoute(optimaleRoute);
        }
    }

    public void verplaatsSpeler(Richting richting) {
        //als de speler geen stappen meer mag zetten of als hij aan de rand van het level is gebeurt er niks
        if (speler.getGezetteStappen() < MAX_STAPPEN) {
            int x = speler.getX(), y = speler.getY();
            
            //bepaal de speler zijn toekomstige positie
            if (richting == Richting.omhoog && y > 0) {
                y--;
            } else if (richting == Richting.omlaag && y < HOOGTE - 1) {
                y++;
            } else if (richting == Richting.naarLinks && x > 0) {
                x--;
            } else if (richting == Richting.naarRechts && x < BREEDTE - 1) {
                x++;
            } else {
                return;
            }

            //bepaal of de speler naar dat veld toe mag en wat er gebeurt als hij daar op gaat staan
            if (speelveld[y][x].getToeganklijk()) {            
                speler.setPositie(x, y);                
                speler.setGezetteStappen(speler.getGezetteStappen() + 1);
                //als het volgende veld geen gewoon veld is, doe de speciale actie
                if (speelveld[y][x].getClass().equals(Veld.class) == false) {
                    ((SpeciaalVeld) speelveld[y][x]).doeSpecialeActie(speler);
                    //speciale dingen kan je maar één keer gebruiken dus vervang deze door een leeg veld als de speler er op is geweest
                    speelveld[y][x] = new Veld(true);
                }                
                //geef een melding als de speler bij het eind van het level is of als zijn stappen op zijn
                if (x == EIND_X && y == EIND_Y) {
                    JOptionPane.showOptionDialog(this, "Je hebt het doolhof uitgespeeld!", null, 0, 2, null, new String[]{"OK"}, 0);
                    resetLevel();
                }
                else if (speler.getGezetteStappen() == MAX_STAPPEN) {
                    JOptionPane.showOptionDialog(this, "Je mag niet meer stappen zetten!", null, 0, 2, null, new String[]{"OK"}, 0);
                } 
            }
            //richting waarin de speler staat verandert altijd, ook als hij niet naar dat veld toe kan
            //zo kan je je bazooka op een muur richting waar je al tegenaan staat
            speler.setRichting(richting);
            this.repaint();
        }
    }
    
    public void schietBazooka() {
        if (speler.getAantalBazookas() > 0) {
            speler.setAantalBazookas(speler.getAantalBazookas() - 1);
            Bazooka.schietBazooka(speelveld, speler.getX(), speler.getY(), speler.getRichting(), BREEDTE, HOOGTE);
            this.repaint();
        }
    }

    public int getResterendeStappen() {
        //maximum stappen en resterende stappen is iets van het level, gezette stappen iets van de speler
        return MAX_STAPPEN - speler.getGezetteStappen();
    }
    
    public int getSpelerZijnAantalBazookas() {
        //geeft het aantal bazooka's van de speler (niet van het level)
        return speler.getAantalBazookas();
    }
    
    public void resetLevel() {
        speler.setPositie(BEGIN_X, BEGIN_Y);
        vriend.setPositie(EIND_X, EIND_Y);
        speler.setGezetteStappen(0);
        speler.setAantalBazookas(0);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int y = 0; y < HOOGTE; y++) {
            for (int x = 0; x < BREEDTE; x++) {
                if (y == speler.getY() && x == speler.getX()) {
                    //teken de afbeelding van de speler als op dit veld de speler staat
                    g.drawImage(speler.getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                }
                else if (y == vriend.getY() && x == vriend.getX()) {
                    //teken de afbeelding van de vriend als op dit veld de vriend staat
                    g.drawImage(vriend.getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                }                
                else {
                    //teken anders de afbeelding van het veld
                    g.drawImage(speelveld[y][x].getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                }                
            }
        }
    }
}
