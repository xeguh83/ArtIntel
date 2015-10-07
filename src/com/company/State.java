package com.company;

import java.util.Arrays;


/**
 * Created by например Андрей on 04.10.2015.
 */
public class State {

    private int[][] data;
    private Coordinates zeroCoordinates;

    public State(int[][] data, Coordinates zeroCoordinates) {
        this.data = new int[Global.MATRIX_SIZE][];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = new int[Global.MATRIX_SIZE];
            System.arraycopy( data[i], 0, this.data[i], 0, data[i].length );
        }
        this.zeroCoordinates = zeroCoordinates;
    }

    public int[][] getData() {
        return data;
    }

    public Coordinates getZeroCoordinates() {
        return zeroCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return Arrays.deepEquals(data, state.data);

    }

    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }



}
