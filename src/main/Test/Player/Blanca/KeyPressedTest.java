package Player.Blanca;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class KeyPressedTest {

    // Utilidad: Accede al dx privado de Sprite (padre de Player)
    private int getDxByReflection(Player player) {
        try {
            Field dxField = Player.class.getSuperclass().getDeclaredField("dx");
            dxField.setAccessible(true);
            return dxField.getInt(player);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Camino 1: Pulsar VK_LEFT asigna dx = -2
    @Test
    void testKeyPressed_Izquierda() {
        Player player = new Player();
        KeyEvent event = new KeyEvent(new TextField(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

        player.keyPressed(event);

        assertEquals(-2, getDxByReflection(player));
    }

    // Camino 2: Pulsar VK_RIGHT asigna dx = 2
    @Test
    void testKeyPressed_Derecha() {
        Player player = new Player();
        KeyEvent event = new KeyEvent(new TextField(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

        player.keyPressed(event);

        assertEquals(2, getDxByReflection(player));
    }

    // Camino 3: Pulsar otra tecla no modifica dx
    @Test
    void testKeyPressed_OtraTecla() {
        Player player = new Player();
        KeyEvent event = new KeyEvent(new TextField(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_SPACE, KeyEvent.CHAR_UNDEFINED);

        player.keyPressed(event);

        assertEquals(0, getDxByReflection(player));
    }
}