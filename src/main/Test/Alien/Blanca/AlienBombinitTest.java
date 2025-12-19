package Alien.Blanca;

import main.Commons;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienBombinitTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // Camino 1-2-3-4-6
    @Test
    public void BombinitCorrecto1() {
        int x = 10;
        int y = 10;
        Alien alien = new Alien(x,y);
        Alien.Bomb bomb = alien.getBomb();
        assertTrue(x == bomb.getX() && y == bomb.getY());
    }
    // Camino 1-2-5-6
    @Test
    public void BombinitCorrecto2() {
        int x = Commons.BOARD_WIDTH + 1;
        int y = 10;
        Alien alien = new Alien(x,y);
        Alien.Bomb bomb = alien.getBomb();
        assertTrue(Commons.BOARD_WIDTH == bomb.getX() && y == bomb.getY());
    }
    // Camino 1-2-3-5-6
    @Test
    public void BombinitCorrecto3() {
        int x = 10;
        int y = Commons.BOARD_HEIGHT + 1;
        Alien alien = new Alien(x,y);
        Alien.Bomb bomb = alien.getBomb();
        assertTrue(x == bomb.getX() && Commons.BOARD_HEIGHT == bomb.getY());
    }
}
