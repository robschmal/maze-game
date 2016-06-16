/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.java;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorn
 */
public class LevelTest {

    @Test
    public void testVerplaatsHeld() {
        Level speelveld = Maze.getLevel();
        int resterendeStappenVoor, resultaat, verwachtResultaat;
        
        resterendeStappenVoor = speelveld.getResterendeStappen();
        speelveld.verplaatsHeld(Richting.omhoog);        
        resultaat = speelveld.getResterendeStappen() - resterendeStappenVoor;
        verwachtResultaat = -1;
        assertEquals(verwachtResultaat, resultaat, 0);
    }

    @Test
    public void testSchietBazooka() {
        Level speelveld = Maze.getLevel();
        int resterendeBazookasVoor, resultaat, verwachtResultaat;
        
        resterendeBazookasVoor = speelveld.getHeldZijnAantalBazookas();
        speelveld.schietBazooka();
        resultaat = speelveld.getHeldZijnAantalBazookas() - resterendeBazookasVoor;
        verwachtResultaat = -1;
        assertEquals(verwachtResultaat, resultaat, 0);
    }   
}