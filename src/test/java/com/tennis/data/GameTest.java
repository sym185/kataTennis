package com.tennis.data;

import com.tennis.data.constant.Point;
import com.tennis.utils.errors.FunctionalException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue(game.getPlayerOne().isWinner());
    }

    @Test(expected=FunctionalException.class)
    public void scoreException() throws FunctionalException {
        game.getPlayerOne().setPoint(Point.WIN);
        game.score(game.getPlayerOne());
    }


}
