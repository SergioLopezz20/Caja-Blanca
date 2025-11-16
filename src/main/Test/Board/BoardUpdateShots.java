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

public class BoardUpdateShots {
    @BeforeEach
    public void setup() {
    }
    @AfterEach
    public void tearDown() {
    }

    //Camino 1-14
    @Test
    public void UpdateShots1(){
        Board board = new Board();
        board.setShot(new Shot(10,10));
        board.getShot().die();
        //board.update();
    }

    //Camino 1-2-3-11-1w-14
    @Test
    public void UpdateShots2(){
        Board board = new Board();
        board.setShot(new Shot(10,10));
        List<Alien> aliens = new ArrayList<>();
        board.setAliens(aliens);
        board.getShot().setY(-10);
        //board.update();
    }
    //Camino 1-2-3-11-13-14
    @Test
    public void UpdateShots3(){
        Board board = new Board();
        board.setShot(new Shot(10,10));
        List<Alien> aliens = new ArrayList<>();
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-11-13-14
    @Test
    public void UpdateShots4(){
        Board board = new Board();
        board.setShot(new Shot(5,5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        alien.die();
        aliens.add(alien);
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-5-6-11-13-14
    @Test
    public void UpdateShots5() {
        Board board = new Board();
        board.setShot(new Shot(9, 5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10, 10);
        aliens.add(alien);
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-5-6-7-11-13-14
    @Test
    public void UpdateShots6(){
        Board board = new Board();
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
        Board board = new Board();
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH ,5));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-5-6-7-8-9-11-13-14
    @Test
    public void UpdateShots8(){
        Board board = new Board();
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH - 1,11+Commons.ALIEN_HEIGHT));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);
        //board.update();
    }
    //Camino 1-2-3-4-5-6-7-8-9-10-11-13-14
    @Test
    public void UpdateShots9(){
        Board board = new Board();
        board.setShot(new Shot(10 + Commons.ALIEN_WIDTH - 1,10+Commons.ALIEN_HEIGHT));
        List<Alien> aliens = new ArrayList<>();
        Alien alien = new Alien(10,10);
        aliens.add(alien);
        board.setAliens(aliens);
        board.getShot().setY(-10);
        //board.update();
    }

}
