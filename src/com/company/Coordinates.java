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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (i != that.i) return false;
        return j == that.j;

    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
