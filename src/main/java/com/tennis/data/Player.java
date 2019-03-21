package com.tennis.data;

import com.tennis.data.constant.Point;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                winner == player.winner &&
                Objects.equals(name, player.name) &&
                point == player.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, point, winner);
    }
}