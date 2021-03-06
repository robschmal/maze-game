package mazegame.java;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class Level extends JComponent {
    private final int BREEDTE = 35, HOOGTE = 18, AFMETING = 35, MARGE = 10;
    private final int BEGIN_X = 0, BEGIN_Y = 0, EIND_X = BREEDTE-1, EIND_Y = HOOGTE-1;
    private final int MAX_STAPPEN = 70, MAX_TIJD = 60;    
    private final Held held;
    private final Held vriend;
    private final Veld[][] speelveld = new Veld[HOOGTE][BREEDTE];
    private int level;
    private int verstrekenTijd;

    public Level() {
        held = new Held("held");
        vriend = new Held("vriend");
        level = 1;
        laadLevel();
    }

    private void laadLevel() {
        String levelLayoutString = LevelLayout.getLevelLayoutString(level);
        ArrayList<Veld> optimaleRoute = new ArrayList<>();
        ArrayList<Helper> helpers = new ArrayList<>();
        for (int y=0; y<HOOGTE; y++) {
            for (int x=0; x<BREEDTE; x++) {
                switch (levelLayoutString.charAt((y * BREEDTE) + x)) {
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
        
        held.setPositie(BEGIN_X, BEGIN_Y);
        vriend.setPositie(EIND_X, EIND_Y);
        held.setGezetteStappen(0);
        held.setRichting(Richting.omlaag);
        held.setAantalBazookas(0);
        verstrekenTijd = 0;
        this.repaint();
    }

    public void laadLevel(int level) {
        this.level = level;
        laadLevel();
    }    
    
    public void verplaatsHeld(Richting richting) {
        //als de held geen stappen meer mag zetten of als hij aan de rand van het level is gebeurt er niks
        if (held.getGezetteStappen() < MAX_STAPPEN && verstrekenTijd < MAX_TIJD) {
            int x = held.getX(), y = held.getY();
            //richting waarin de held staat verandert altijd
            //zo kan hij de bazooka op een muur richting waar hij al tegenaan staat
            held.setRichting(richting);
            
            //bepaal de held zijn toekomstige positie
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

            //bepaal of de held naar dat veld toe mag en wat er gebeurt als hij daar op gaat staan
            if (speelveld[y][x].getToeganklijk()) {            
                held.setPositie(x, y);                
                held.setGezetteStappen(held.getGezetteStappen() + 1);
                //als het volgende veld geen gewoon veld is, doe de speciale actie
                if (speelveld[y][x].getClass().equals(Veld.class) == false) {
                    ((SpeciaalVeld) speelveld[y][x]).doeSpecialeActie(held);
                    //speciale dingen kan je maar één keer gebruiken dus vervang deze door een leeg veld als de held er op is geweest
                    speelveld[y][x] = new Veld(true);
                }                
                //geef een melding als de held bij het eind van het level is of als zijn stappen op zijn
                if (x == EIND_X && y == EIND_Y) {
                    JOptionPane.showOptionDialog(this, "Je hebt het doolhof uitgespeeld!", null, 0, 2, null, new String[]{"OK"}, 0);
                    //als de held het level heeft uitgespeeld gaat hij door naar het volgende of weer naar het eerste
                    level = (level < 3? level++: 1);
                    laadLevel();
                }
                else if (held.getGezetteStappen() == MAX_STAPPEN) {
                    JOptionPane.showOptionDialog(this, "Je mag niet meer stappen zetten!", null, 0, 2, null, new String[]{"OK"}, 0);
                } 
            }
            
            this.repaint();
        }
    }
    
    public void schietBazooka() {
        if (held.getAantalBazookas() > 0) {
            held.setAantalBazookas(held.getAantalBazookas() - 1);
            Timer timer = new Timer(200, new BazookaTimer());
            timer.setRepeats(false);            
            Bazooka.richtBazooka(held.getX(), held.getY(), held.getRichting(), BREEDTE, HOOGTE);
            do {
                Bazooka.schietBazooka();
                if (Bazooka.getActief()) {
                    //als de raket een muur raakt wordt de muur vervangen door een leeg veld en wordt de bazooka gestopt
                    //zo niet dan wordt even gewacht en vliegt de raket verder
                    if (speelveld[Bazooka.getY()][Bazooka.getX()].getToeganklijk() == false) {
                        speelveld[Bazooka.getY()][Bazooka.getX()] = new Veld(true);
                        Bazooka.stopBazooka();
                    }
                    else {
                        timer.start();
                        while (timer.isRunning()) {}
                    }                    
                }
                //het level wordt altijd opnieuw getekend, ook als de bazooka niet meer actief is,
                //zodat je ziet dat er een muur is verdwenen of dat de bazooka van het veld is gevlogen
                this.update(this.getGraphics());
            } while (Bazooka.getActief());            
        }
    }

    public void setVerstrekenTijd(int verstrekenTijd) {
        this.verstrekenTijd = verstrekenTijd;
        if (verstrekenTijd >= MAX_TIJD) {
            JOptionPane.showOptionDialog(this, "Je tijd is om!", null, 0, 2, null, new String[]{"OK"}, 0);
        }
    }
    
    public int getVerstrekenTijd() {
        return verstrekenTijd;
    }
    
    public int getResterendeStappen() {
        //maximum stappen en resterende stappen is iets van het level, gezette stappen iets van de held
        return MAX_STAPPEN - held.getGezetteStappen();
    }
    
    public int getResterendeTijd() {
        return MAX_TIJD - verstrekenTijd;
    }
    
    public int getHeldZijnAantalBazookas() {
        //geeft het aantal bazooka's van de held (niet van het level)
        return held.getAantalBazookas();
    }    

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage afbeelding;
        for (int y = 0; y < HOOGTE; y++) {
            for (int x = 0; x < BREEDTE; x++) {
                if (y == held.getY() && x == held.getX()) {
                    //teken de afbeelding van de held als op dit veld de held staat
                    afbeelding = held.getAfbeelding();
                }
                else if (Bazooka.getActief() && y == Bazooka.getY() && x == Bazooka.getX()) {
                    //teken de afbeelding van de bazooka raket als op dit veld een raket voorbij komt
                    afbeelding = Bazooka.getRaketAfbeelding();
                }                
                else if (y == vriend.getY() && x == vriend.getX()) {
                    //teken de afbeelding van de vriend als op dit veld de vriend staat
                    afbeelding = vriend.getAfbeelding();
                }                
                else {
                    //teken anders de afbeelding van het veld
                    afbeelding = speelveld[y][x].getAfbeelding();
                }
                g.drawImage(afbeelding, x * AFMETING + MARGE, y * AFMETING, this);
            }
        }
    }        
            
    class BazookaTimer implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
