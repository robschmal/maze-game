package mazegame.java;

import java.awt.Graphics;
import javax.swing.*;

public class Level extends JComponent {

    private final int BREEDTE = 35, HOOGTE = 18, AFMETING = 35, MARGE = 10;
    private final Positie BEGIN = new Positie(0, 0);
    private final Positie EIND = new Positie(BREEDTE - 1, HOOGTE - 1);
    private final int MAX_STAPPEN = 70;
    private final int MAX_TIJD = 300;
    private final Veld[][] VELDEN = new Veld[HOOGTE][BREEDTE];
    private final Speler SPELER;
    private final String ROUTE = "RRmmmmmmmmmmmmmmRRRmRRRRRRRRRRRRRRR"
                                 + "mRmmmmmmmRRRRRRmRmRmRmmmmmmmRmmmmmm"
                                 + "mRRRRRRRmRmmmmRmmmRmRmmmRRRRRmmRRRm"
                                 + "mRmmmmmRmRRRRmRRRRRmRmmmRmmmmmmRmmm"
                                 + "mRRRRRmRmmmmRmmmmmmmRmmmRRRRRRRRmmm"
                                 + "mmmmmRmRRRRRRmRRRRRRRmmmmmmmmRmmmmm"
                                 + "mRRRmRmRmmmmmmRmmmRmmmmmmRRRRRmmmmm"
                                 + "mRmRRRmRRRRRRRRmmmRRRRRmmRmmmmmmmmm"
                                 + "mRmmmmmmmmmmmmmmmmmmmmRRRRRRRRRRRmm"
                                 + "mRmRRRRRmmRRRRRRRRmmmmRmmmmmmmmmRmm"
                                 + "mRmmmmmRmmRmmmmRmRRRRRRmmmmmmmmmRmm"
                                 + "mRRRRRRRRRRmRRRRmRmmRmmmmRRRRRRRRmm"
                                 + "mmmmmmmmmmmmRmmmmRmmRmmmmRmmmmmmRmm"
                                 + "RRRRRRRRRRRmRRRRmRmmRRRRRRRRmmmmRmm"
                                 + "RmmmmmmmmmRmmmmRmRmmmmmmmmmRmmmmRmm"
                                 + "RRRRRRRmmmRRRRRRmRmmmmmmmmmRRRRRRmm"
                                 + "mmmmmmRmmmmmmmmmmRRRRRRRRmmmmmmmmmm"
                                 + "mmmmmmRRRRRRRRRRmmmmmmmmRRRRRRRRRRR";

    public Level() {
        char veld;
        for (int y = 0; y < HOOGTE; y++) {
            for (int x = 0; x < BREEDTE; x++) {
                veld = ROUTE.charAt((y * BREEDTE) + x);
                if (veld == 'R') {
                    VELDEN[y][x] = new Veld(true);
                } else {
                    VELDEN[y][x] = new Veld(false);
                }
            }
        }
        SPELER = new Speler();
    }

    public void verplaatsSpeler(Richting richting) {
        Positie positie = new Positie(SPELER.getPositie());

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

        if (VELDEN[positie.y][positie.x].getToeganklijk() && SPELER.getGezetteStappen() < MAX_STAPPEN) {
            SPELER.setPositie(positie);
            this.repaint();
            if (SPELER.getPositie().x == EIND.x && SPELER.getPositie().y == EIND.y) {
                JOptionPane.showOptionDialog(this, "Je hebt het doolhof uitgespeeld!", null, 0, 2, null, new String[]{"OK"}, 0);
                resetLevel();
            }
        }
        else if (SPELER.getGezetteStappen() == MAX_STAPPEN) {
            JOptionPane.showOptionDialog(this, "Je mag niet meer stappen zetten!", null, 0, 2, null, new String[]{"OK"}, 0);
        }
    }

    public int berekenResterendeStappen() {
        return MAX_STAPPEN - SPELER.getGezetteStappen();
    }
    
    public void resetLevel() {
        SPELER.setPositie(BEGIN);
        SPELER.setGezetteStappen(0);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int y = 0; y < HOOGTE; y++) {
            for (int x = 0; x < BREEDTE; x++) {
                if (y == SPELER.getPositie().y && x == SPELER.getPositie().x) {
                    g.drawImage(SPELER.getAfbeelding(), x * AFMETING + MARGE, y * AFMETING, this);
                } else {
                    g.setColor(VELDEN[y][x].getKleur());
                    g.fillRect(x * AFMETING + MARGE, y * AFMETING, AFMETING, AFMETING);
                }                
            }
        }
    }
}
