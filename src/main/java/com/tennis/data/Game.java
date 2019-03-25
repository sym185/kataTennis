package com.tennis.data;

import com.tennis.data.constant.Point;
import com.tennis.utils.errors.EnumFunctionalException;
import com.tennis.utils.errors.FunctionalException;

public class Game{

    private Player playerOne;
    private Player playerTwo;

    public Game() {
        playerOne = new Player(1, "playerOne", Point.ZERO, false, 0, false);
        playerTwo = new Player(2, "playerTwo", Point.ZERO, false, 0, false);
    }

    public void score(Player player) throws FunctionalException {
        switch (player.getPoint()){
            case ZERO: player.setPoint(Point.FIFTEEN) ;break;
            case FIFTEEN: player.setPoint(Point.THIRTY) ;break;
            case THIRTY: player.setPoint(Point.FORTY) ; manageDeuce() ;break;
            case FORTY: manageAdv(player); break;
            case DEUCE: manageAdv(player); break;
            case ADV: player.setPoint(Point.ZERO); player.setGameWinner(true) ; manageSetScore(player);break;
            default : throw new FunctionalException(EnumFunctionalException.ERROR_POINT);
        }
    }

    public void manageSetScore(Player player){
        player.setSetScore(player.getSetScore() + 1);

        if(player.getSetScore() >= 6){
               if(player == playerOne && playerTwo.getSetScore() < 5){
                   manageSetWinner(playerOne);
               }
               else if(player == playerTwo && playerOne.getSetScore() < 5){
                   manageSetWinner(playerTwo);
               }
               else if (player.getSetScore() == 7){
                   manageSetWinner(player);
               }
        }

    }

    public void manageSetWinner(Player player){
        player.setSetWinner(true);
        playerOne.setPoint(Point.ZERO);
        playerTwo.setPoint(Point.ZERO);
        playerOne.setGameWinner(false);
        playerTwo.setGameWinner(false);
    }

    public void manageDeuce(){
        if(playerOne.getPoint() == Point.FORTY && playerTwo.getPoint() == Point.FORTY){
            playerOne.setPoint(Point.DEUCE);
            playerTwo.setPoint(Point.DEUCE);
        }

    }

    public void manageAdv(Player player){
        if(playerOne.getPoint() == Point.FORTY && playerTwo.getPoint() != Point.DEUCE && playerTwo.getPoint() != Point.FORTY
                && playerTwo.getPoint() != Point.ADV) {
                manageGameWinner(player);
        }

        else if(playerTwo.getPoint() == Point.FORTY && playerOne.getPoint() != Point.DEUCE && playerOne.getPoint() != Point.FORTY
                && playerOne.getPoint() != Point.ADV) {
                manageGameWinner(player);
        }

        else if(playerOne.getPoint() == Point.DEUCE && playerTwo.getPoint() == Point.DEUCE){
            if(player == playerOne){
                playerOne.setPoint(Point.ADV);
                playerTwo.setPoint(Point.FORTY);
            }
            else if (player == playerTwo){
                playerOne.setPoint(Point.FORTY);
                playerTwo.setPoint(Point.ADV);
            }
        }

         else if(playerOne.getPoint() == Point.ADV && playerTwo.getPoint() == Point.FORTY){
            if(player == playerOne){
                playerOne.setPoint(Point.ZERO);
                playerTwo.setPoint(Point.ZERO);
                playerOne.setGameWinner(true);
                manageSetScore(playerOne);
            }
            else if (player == playerTwo){
                playerOne.setPoint(Point.DEUCE);
                playerTwo.setPoint(Point.DEUCE);
            }
        }

        else if(playerOne.getPoint() == Point.FORTY && playerTwo.getPoint() == Point.ADV){
            if(player == playerOne){
                playerOne.setPoint(Point.DEUCE);
                playerTwo.setPoint(Point.DEUCE);
            }
            else if (player == playerTwo){
                playerOne.setPoint(Point.ZERO);
                playerTwo.setPoint(Point.ZERO);
                playerTwo.setGameWinner(true);
                manageSetScore(playerTwo);
            }
        }

    }

        public void manageGameWinner(Player player) {

            if(player == playerOne){
                playerOne.setPoint(Point.ZERO);
                playerTwo.setPoint(Point.ZERO);
                playerOne.setGameWinner(true);
                manageSetScore(playerOne);
            }

            else if(player == playerTwo){
                playerOne.setPoint(Point.ZERO);
                playerTwo.setPoint(Point.ZERO);
                playerTwo.setGameWinner(true);
                manageSetScore(playerTwo);
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
