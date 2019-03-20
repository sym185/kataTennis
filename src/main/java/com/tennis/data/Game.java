package com.tennis.data;

import com.tennis.data.constant.Point;
import com.tennis.utils.errors.EnumFunctionalException;
import com.tennis.utils.errors.FunctionalException;

public class Game{

    private Player playerOne;
    private Player playerTwo;

    public Game() {
        playerOne = new Player(1, "playerOne", Point.ZERO, false);
        playerTwo = new Player(2, "playerTwo", Point.ZERO, false);
    }

    public void score(Player player) throws FunctionalException {
        switch (player.getPoint()){
            case ZERO: player.setPoint(Point.FIFTEEN) ;break;
            case FIFTEEN: player.setPoint(Point.THIRTY) ;break;
            case THIRTY: player.setPoint(Point.FORTY) ;break;
            case FORTY: player.setPoint(Point.ZERO); player.setWinner(true); break;
            default : throw new FunctionalException(EnumFunctionalException.ERROR_POINT);
        }
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
}
