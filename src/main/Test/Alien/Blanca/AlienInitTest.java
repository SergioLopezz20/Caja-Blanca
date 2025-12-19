package Alien.Blanca;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import static org.junit.jupiter.api.Assertions.*;

class AlienInitTest {

    // Supón que Commons.BOARD_WIDTH = 358 y Commons.BOARD_HEIGHT = 350

    @Test
    void alienInit_xEnLimiteSuperior() {
        Alien alien = new Alien(500, 10); // x > BOARD_WIDTH
        assertEquals(358, alien.getX());
        assertEquals(10, alien.getY());
    }

    @Test
    void alienInit_xNegativo() {
        Alien alien = new Alien(-5, 10);
        assertEquals(0, alien.getX());
        assertEquals(10, alien.getY());
    }

    @Test
    void alienInit_yEnLimiteSuperior() {
        Alien alien = new Alien(10, 400); // y > BOARD_HEIGHT
        assertEquals(10, alien.getX());
        assertEquals(350, alien.getY());
    }

    @Test
    void alienInit_yNegativo() {
        Alien alien = new Alien(10, -8);
        assertEquals(10, alien.getX());
        assertEquals(0, alien.getY());
    }

    @Test
    void alienInit_ambosEnRango() {
        Alien alien = new Alien(20, 30);
        assertEquals(20, alien.getX());
        assertEquals(30, alien.getY());
    }

    // Extra: caso ambos fuera de rango positivo
    @Test
    void alienInit_ambosFueraDeRangoSuperior() {
        Alien alien = new Alien(400, 500);
        assertEquals(358, alien.getX());
        assertEquals(350, alien.getY());
    }

    // Extra: caso ambos negativos
    @Test
    void alienInit_ambosNegativos() {
        Alien alien = new Alien(-8, -4);
        assertEquals(0, alien.getX());
        assertEquals(0, alien.getY());
    }
}
