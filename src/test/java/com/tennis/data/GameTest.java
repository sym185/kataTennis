package com.tennis.data;

import com.tennis.data.constant.Point;
import com.tennis.utils.errors.FunctionalException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void runBeforeTestMethod() {
        game = new Game();
    }

    @After
    public void runAfterTestMethod() {
        game = new Game();
    }

    @Test
    public void scoreTest() throws FunctionalException {
        game.score(game.getPlayerOne());
        assertEquals(game.getPlayerOne().getPoint(), Point.FIFTEEN);

        game.score(game.getPlayerOne());
        assertEquals(game.getPlayerOne().getPoint(), Point.THIRTY);

        game.score(game.getPlayerOne());
        assertEquals(game.getPlayerOne().getPoint(), Point.FORTY);

        game.score(game.getPlayerOne());
        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerOne().isGameWinner());
    }

    @Test(expected=FunctionalException.class)
    public void scoreException() throws FunctionalException {
        game.getPlayerOne().setPoint(Point.WIN);
        game.score(game.getPlayerOne());
    }


    @Test
    public void manageWinnerTest(){
        game.manageGameWinner(game.getPlayerOne());

        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerOne().isGameWinner());
        assertFalse(game.getPlayerTwo().isGameWinner());
    }

    @Test
    public void manageDeuceTest(){
        game.getPlayerOne().setPoint(Point.FORTY);
        game.getPlayerTwo().setPoint(Point.FORTY);

        game.manageDeuce();

        assertEquals(game.getPlayerOne().getPoint(), Point.DEUCE);
        assertEquals(game.getPlayerTwo().getPoint(), Point.DEUCE);
    }

    @Test
    public void manageAdvTest(){

        game.getPlayerOne().setPoint(Point.FORTY);
        game.manageAdv(game.getPlayerOne());

        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerOne().isGameWinner());

    }

    @Test
    public void manageAdvTest1(){

        game.getPlayerTwo().setPoint(Point.FORTY);
        game.manageAdv(game.getPlayerTwo());

        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerTwo().isGameWinner());

    }

    @Test
    public void manageAdvTest2(){

        game.getPlayerOne().setPoint(Point.DEUCE);
        game.getPlayerTwo().setPoint(Point.DEUCE);
        game.manageAdv(game.getPlayerOne());

        assertEquals(game.getPlayerOne().getPoint(), Point.ADV);
        assertEquals(game.getPlayerTwo().getPoint(), Point.FORTY);
    }

    @Test
    public void manageAdvTest3(){

        game.getPlayerOne().setPoint(Point.DEUCE);
        game.getPlayerTwo().setPoint(Point.DEUCE);
        game.manageAdv(game.getPlayerTwo());

        assertEquals(game.getPlayerOne().getPoint(), Point.FORTY);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ADV);
    }

    @Test
    public void manageAdvTest4(){
        game.getPlayerOne().setPoint(Point.ADV);
        game.getPlayerTwo().setPoint(Point.FORTY);
        game.manageAdv(game.getPlayerOne());

        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerOne().isGameWinner());
    }

    @Test
    public void manageAdvTest5(){
        game.getPlayerOne().setPoint(Point.ADV);
        game.getPlayerTwo().setPoint(Point.FORTY);
        game.manageAdv(game.getPlayerTwo());

        assertEquals(game.getPlayerOne().getPoint(), Point.DEUCE);
        assertEquals(game.getPlayerTwo().getPoint(), Point.DEUCE);
    }

    @Test
    public void manageTest6(){
        game.getPlayerOne().setPoint(Point.FORTY);
        game.getPlayerTwo().setPoint(Point.ADV);
        game.manageAdv(game.getPlayerOne());

        assertEquals(game.getPlayerOne().getPoint(), Point.DEUCE);
        assertEquals(game.getPlayerTwo().getPoint(), Point.DEUCE);

    }

    @Test
    public void manageTest7(){
        game.getPlayerOne().setPoint(Point.FORTY);
        game.getPlayerTwo().setPoint(Point.ADV);
        game.manageAdv(game.getPlayerTwo());

        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertTrue(game.getPlayerTwo().isGameWinner());
    }


    @Test
    public void manageSetWinnerTest(){
        game.manageSetWinner(game.getPlayerOne());
        assertEquals(game.getPlayerOne().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerTwo().getPoint(), Point.ZERO);
        assertEquals(game.getPlayerOne().isGameWinner(), false);
        assertEquals(game.getPlayerTwo().isGameWinner(), false);
        assertTrue(game.getPlayerOne().isSetWinner());
    }

    @Test
    public void manageSetScoreTest(){
        game.getPlayerOne().setSetScore(5);
        game.manageSetScore(game.getPlayerOne());

        assertTrue(game.getPlayerOne().isSetWinner());
    }

    @Test
    public void manageSetScoreTest2(){
        game.getPlayerOne().setSetScore(5);
        game.getPlayerTwo().setSetScore(5);
        game.manageSetScore(game.getPlayerOne());

        assertFalse(game.getPlayerOne().isSetWinner());
        assertFalse(game.getPlayerTwo().isSetWinner());
    }


    @Test
    public void manageSetScoreTest3(){
        game.getPlayerOne().setSetScore(6);
        game.getPlayerTwo().setSetScore(5);
        game.manageSetScore(game.getPlayerOne());

        assertTrue(game.getPlayerOne().isSetWinner());
        assertFalse(game.getPlayerTwo().isSetWinner());
    }

}
