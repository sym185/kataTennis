package com.tennis.data;

import com.tennis.data.constant.Point;

import java.util.Objects;

public class Player{

    private long id;
    private String name;
    private Point point;
    private boolean gameWinner;
    private int setScore;
    private boolean setWinner;
    private int tieBreakScore;

    public Player(long id, String name, Point point, boolean gameWinner, int setScore, boolean setWinner) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.gameWinner = gameWinner;
        this.setScore = setScore;
        this.setWinner = setWinner;
    }

    public Player(long id, String name, Point point, boolean gameWinner) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.gameWinner = gameWinner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public boolean isGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(boolean gameWinner) {
        this.gameWinner = gameWinner;
    }

    public int getSetScore() {
        return setScore;
    }

    public void setSetScore(int setScore) {
        this.setScore = setScore;
    }

    public boolean isSetWinner() {
        return setWinner;
    }

    public void setSetWinner(boolean setWinner) {
        this.setWinner = setWinner;
    }

    public int getTieBreakScore() {
        return tieBreakScore;
    }

    public void setTieBreakScore(int tieBreakScore) {
        this.tieBreakScore = tieBreakScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                gameWinner == player.gameWinner &&
                Objects.equals(name, player.name) &&
                point == player.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, point, gameWinner);
    }
}