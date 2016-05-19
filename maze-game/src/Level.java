import java.awt.Graphics;
import javax.swing.*;

public class Level extends JComponent {    
    final int BREEDTE = 35, HOOGTE = 20, AFMETING = 35;              //hoogte en breedte van het doolhof in aantal velden
    Positie begin = new Positie(BREEDTE-1, HOOGTE-1); //begin positie, rechts onderin
    Positie eind = new Positie(0, 0);                 //eind positie, links bovenin
    int maxStappen = 100;                             //maximum aantal stappen
    int maxTijd = 300;                                //maximum tijd in aantal seconden 
    Veld[][] velden = new Veld[BREEDTE][HOOGTE];      //velden in het doolhof
    Speler speler;                                    //speler object 
    
    public Level() {
        for (int i=0; i<BREEDTE; i++) {
            for (int j=0; j<HOOGTE; j++) {                
                velden[i][j] = new Veld(true);
            }
        }
        speler = new Speler(begin);
    }
    
    public void verplaatsSpeler(Richting richting) {
        Positie positie = speler.getPositie();
        
        if (richting == Richting.omhoog && positie.y > 0) {
            positie.y--;
        }
        else if (richting == Richting.omlaag && positie.y < HOOGTE - 1) {
            positie.y++;
        }
        else if (richting == Richting.naarLinks && positie.x > 0) {
            positie.x--;
        }
        else if (richting == Richting.naarRechts && positie.x < BREEDTE - 1) {
            positie.x++;
        }
        
        if (velden[positie.x][positie.y].getToeganklijk() && speler.getGezetteStappen() < maxStappen) {
            speler.setPositie(positie);
            this.repaint();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int i=0; i<BREEDTE; i++) {
            for (int j=0; j<HOOGTE; j++) {                
                if (i == speler.getPositie().x && j == speler.getPositie().y) {
                    g.setColor(speler.getKleur());
                }
                else {
                    g.setColor(velden[i][j].getKleur());
                }
                g.fillRect(i * AFMETING, j * AFMETING, AFMETING, AFMETING);
            }
        }        
    }        
}
