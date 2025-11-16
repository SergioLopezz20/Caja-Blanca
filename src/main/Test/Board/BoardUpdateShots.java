package Board;

import main.Board;
import main.Commons;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Shot;

import java.util.ArrayList;
import java.util.List;

import  static org.junit.jupiter.api.Assertions.*;

public class BoardUpdateShots {
    private Board board;
    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @AfterEach
    public void tearDown() {
    }

    private void callUpdateOnce() {
        try {
            var updateMethod = Board.class.getDeclaredMethod("update");
            updateMethod.setAccessible(true);
            updateMethod.invoke(board);
        } catch (Exception e) {}
    }

    //Camino 1-14
    @Test
    public void UpdateShots1(){
        board.setShot(new Shot(10,10));
        board.getShot().die();

        callUpdateOnce();

        assertFalse(board.getShot().isVisible());
    }

    //Camino 1-2-3-11-12-14
    @Test
    public void UpdateShots2(){
        board.setShot(new Shot(10,10));
        List<Alien> aliens = new ArrayList<>();
        board.setAliens(aliens);
        board.getShot().setY(-10);

        callUpdateOnce();

        assertFalse(board.getShot().isVisible());
    }
    //Camino 1-2-3-11-13-14
    @Test
    public void UpdateShots3(){
        board.setShot(new Shot(10,10));
        List<Alien> aliens = new ArrayList<>();
        board.setAliens(aliens);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertFalse(board.getAliens().getFirst().isDying());
    }
    //Camino 1-2-3-4-11-13-14
    @Test
    public void UpdateShots4(){
        board.setShot(new Shot(5,5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        alien.die();
        aliens.add(alien);
        board.setAliens(aliens);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertFalse(board.getAliens().getFirst().isDying());
    }
    //Camino 1-2-3-4-5-6-11-13-14
    @Test
    public void UpdateShots5() {
        board.setShot(new Shot(9, 5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10, 10);
        aliens.add(alien);
        board.setAliens(aliens);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertFalse(board.getAliens().getFirst().isDying());
    }
    //Camino 1-2-3-4-5-6-7-11-13-14
    @Test
    public void UpdateShots6(){
        board.setShot(new Shot(11+ Commons.ALIEN_WIDTH,5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-5-6-7-8-11-13-14
    @Test
    public void UpdateShots7(){
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH ,5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertFalse(board.getAliens().getFirst().isDying());    }
    //Camino 1-2-3-4-5-6-7-8-9-11-13-14
    @Test
    public void UpdateShots8(){
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH - 1,11+Commons.ALIEN_HEIGHT));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertFalse(board.getAliens().getFirst().isDying());    }
    //Camino 1-2-3-4-5-6-7-8-9-10-11-13-14
    @Test
    public void UpdateShots9(){
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH - 1,10+Commons.ALIEN_HEIGHT));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);
        board.getShot().setY(-10);

        callUpdateOnce();

        assertTrue(board.getShot().isVisible());
        assertTrue(board.getAliens().getFirst().isDying());    }

}
