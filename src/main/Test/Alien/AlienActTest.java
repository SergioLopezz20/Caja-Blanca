package Alien;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienActTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void alienActcorrecto(){
        Alien alien=new Alien(10,0);
        alien.act(5);
        assertEquals(15, alien.getX());
    }
}