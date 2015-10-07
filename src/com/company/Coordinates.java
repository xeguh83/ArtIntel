package com.company;

/**
 * Created by например Андрей on 04.10.2015.
 */
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(Coordinates anotherCoordinates) {
        this.x = anotherCoordinates.getX();
        this.y = anotherCoordinates.getY();
    }

    public Coordinates(final int xCoordinate,final int yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
