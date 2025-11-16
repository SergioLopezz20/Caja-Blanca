package Board;

import main.Board;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

public class BoardUpdateTest{

    private void invokeUpdate(Board board) {
        try {
            Method m = Board.class.getDeclaredMethod("update");
            m.setAccessible(true);
            m.invoke(board);
        } catch (Exception e) {
            fail("No se pudo invocar Board.update() por reflexión: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateBranchFalseWhenDeathsNot24() {
        Board board = new Board();

        board.setDeaths(23);
        board.setInGame(true);
        board.setMessage("Game Over");
        invokeUpdate(board);
        assertTrue(board.isInGame(), "El juego debería seguir en marcha");
        assertNotEquals("Game won!", board.getMessage(),
                "No debería ponerse 'Game won!' cuando deaths != 24");
    }

    @Test
    public void testUpdateBranchTrueWhenDeathsEquals24() {
        Board board = new Board();
        board.setDeaths(24);
        board.setInGame(true);
        board.setMessage("Game Over");
        invokeUpdate(board);
        assertFalse(board.isInGame(), "El juego debería pasar a terminado");
        assertEquals("Game won!", board.getMessage(),
                "El mensaje debería ser 'Game won!' al destruir todos los aliens");
        assertFalse(board.getTimer().isRunning(),
                "El temporizador debería estar parado tras ganar la partida");
    }
}