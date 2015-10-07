package com.company;

/**
 * Created by например Андрей on 04.10.2015.
 */
public class Coordinates {

    private int i;
    private int j;

    public Coordinates(Coordinates anotherCoordinates) {
        this.i = anotherCoordinates.getI();
        this.j = anotherCoordinates.getJ();
    }

    public Coordinates(final int xCoordinate,final int yCoordinate) {
        this.i = xCoordinate;
        this.j = yCoordinate;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
