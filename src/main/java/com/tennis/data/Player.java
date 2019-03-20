package com.tennis.data;

import com.tennis.data.constant.Point;

public class Player{

    private long id;
    private String name;
    private Point point;
    private boolean winner;

    public Player(long id, String name, Point point, boolean winner) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.winner = winner;
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

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}