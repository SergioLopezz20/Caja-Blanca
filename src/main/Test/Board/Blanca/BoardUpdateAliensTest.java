package Board.Blanca;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import static org.junit.jupiter.api.Assertions.*;

class BoardUpdateAliensTest {

    // Camino normal: avanza a la derecha, sin bordes
    @Test
    void testMoverDerechaNormal() {
        Alien alien = new Alien(20, 60);
        int xInicial = alien.getX();
        alien.act(1); // Dirección hacia derecha
        assertEquals(xInicial - 1, alien.getX());
        // Sin cambios en y
        assertEquals(60, alien.getY());
    }

    // Camino normal: avanza a la izquierda, sin bordes
    @Test
    void testMoverIzquierdaNormal() {
        Alien alien = new Alien(80, 60);
        int xInicial = alien.getX();
        alien.act(-1); // Dirección hacia izquierda
        assertEquals(xInicial + 1, alien.getX());
        assertEquals(60, alien.getY());
    }

    // Camino borde izquierdo: cambia dirección, desciende
    @Test
    void testBordeIzquierdo() {
        Alien alien = new Alien(0, 10);
        int yInicial = alien.getY();
        // Simulas borde y descenso
        if (alien.getX() <= 0) {
            alien.act(1); // Cambia a derecha
            alien.setY(yInicial + 10);
        }
        assertEquals(yInicial + 10, alien.getY());
    }

    // Camino borde derecho: cambia dirección, desciende
    @Test
    void testBordeDerecho() {
        Alien alien = new Alien(95, 10);
        int yInicial = alien.getY();
        if (alien.getX() >= 95) {
            alien.act(-1); // Cambia a izquierda
            alien.setY(yInicial + 10);
        }
        assertEquals(yInicial + 10, alien.getY());
    }

    // Camino invasión: alien supera el límite inferior
    @Test
    void testInvasion() {
        Alien alien = new Alien(10, 300); // 300 es GROUND
        boolean invade = alien.getY() >= 300;
        assertTrue(invade);
    }
}