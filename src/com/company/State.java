package com.company;

import java.util.Arrays;


/**
 * Created by �������� ������ on 04.10.2015.
 */
public class State {

    private Integer[][] data;

    public State(Integer[][] data) {
        this.data = data;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
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
}
