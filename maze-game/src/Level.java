import java.awt.event.*;
import javax.swing.*;

public class Level extends JPanel {    
    final int BREEDTE = 20, HOOGTE = 20;              //hoogte en breedte van het doolhof in aantal velden
    Positie begin = new Positie(BREEDTE-1, HOOGTE-1); //begin positie, rechts onderin
    Positie eind = new Positie(0, 0);                 //eind positie, links bovenin
    int maxStappen = 40;                              //maximum aantal stappen
    int maxTijd = 300;                                //maximum tijd in aantal seconden 
    Veld[][] velden = new Veld[BREEDTE][HOOGTE];      //velden in het doolhof
    Speler speler;                                    //speler object
    JFrame frame;                                     //frame waar het doolhof op getekend wordt
    
    public Level(JFrame frame) {
        this.frame = frame;
    }
    
    public void laadDoolhof() {
        JPanel doolhof = new JPanel();        
        for (int i=0; i<BREEDTE; i++) {
            for (int j=0; j<HOOGTE; j++) {                
                velden[i][j] = new Veld(i, j, frame.getWidth()/BREEDTE, "", true);
                doolhof.add(velden[i][j]);
            }
        }
        frame.add(doolhof);
    }
    
    class KeyListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent event) {
            
        }
    }
}
