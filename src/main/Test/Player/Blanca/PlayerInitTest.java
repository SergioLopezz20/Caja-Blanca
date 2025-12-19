package Player.Blanca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerInitTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void playerInitCorrecto(){
       Player player=new Player();
       assertNotEquals(null,player);
    }
}