package Shot;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

public class ShotInitShotTest {


    private int getIntField(Shot shot, String fieldName) throws Exception {
        Field f = Shot.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.getInt(shot);
    }

    @Test
    public void testInitShotStatementCoverage() throws Exception {
        int playerX = 100;
        int playerY = 200;
        Shot shot = new Shot(playerX, playerY);

        int H_SPACE = getIntField(shot, "H_SPACE");
        int V_SPACE = getIntField(shot, "V_SPACE");

        int expectedX = playerX + H_SPACE;
        int expectedY = playerY - V_SPACE;

        assertEquals(expectedX, shot.getX(),
                "La coordenada X del disparo debe ser x + H_SPACE");
        assertEquals(expectedY, shot.getY(),
                "La coordenada Y del disparo debe ser y - V_SPACE");
        assertTrue(shot.isVisible(),
                "El disparo debe quedar visible tras la inicialización");
    }
}
