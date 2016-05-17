import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Level extends JComponent {    
    final int BREEDTE = 40, HOOGTE = 20, AFMETING = 35;              //hoogte en breedte van het doolhof in aantal velden
    Positie begin = new Positie(BREEDTE-1, HOOGTE-1); //begin positie, rechts onderin
    Positie eind = new Positie(0, 0);                 //eind positie, links bovenin
    int maxStappen = 40;                              //maximum aantal stappen
    int maxTijd = 300;                                //maximum tijd in aantal seconden 
    Veld[][] velden = new Veld[BREEDTE][HOOGTE];      //velden in het doolhof
    Speler speler;                                    //speler object 
    
    public Level(JFrame frame) {
        for (int i=0; i<BREEDTE; i++) {
            for (int j=0; j<HOOGTE; j++) {                
                velden[i][j] = new Veld("", true);
            }
        }
        velden[3][4].toeganklijk = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int i=0; i<BREEDTE; i++) {
            for (int j=0; j<HOOGTE; j++) {                
                if (velden[i][j].getToeganklijk()) {
                    g.setColor(Color.green);
                }
                else {
                    g.setColor(Color.gray);
                }
                g.fillRect(i * AFMETING, j * AFMETING, AFMETING, AFMETING);
            }
        }
    }
}
