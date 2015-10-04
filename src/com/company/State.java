package com.company;

import java.util.Arrays;
import java.util.Objects;


/**
 * Created by например Андрей on 04.10.2015.
 */
public class State implements Cloneable {

    private Integer[][] data;

    public State(Integer[][] data) {
        this.data = data;
    }

    public Integer[][] getData() {
        return data;
    }

    public Coordinates getZeroCoordinates() throws Exception {
        for (int j = 0; j < data.length; j++) {
            for (int i = 0; i < data[j].length; i++) {
                if (Integer.valueOf(0).equals(data[j][i])) {
                    return new Coordinates(i,j);
                }
            }
        }
        throw new Exception("There is no zero point in state");
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
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < data.length ; j++) {
            sb.append(Arrays.toString(data[j]));
        }
        return "State{" +
                "data=" + sb.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }

    @Override
    public Object clone() {
        Integer[][] data = this.getData();

        if (data == null)
            return null;
        Integer[][] result = new Integer[data.length][];
        for (int r = 0; r < data.length; r++) {
            result[r] = data[r].clone();
        }
        return new State(result);
    }


}
