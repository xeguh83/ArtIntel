package com.company;

/**
 * Created by �������� ������ on 04.10.2015.
 */
public enum Move {
    RIGHT_ROTATE {
        public State rotate(State state) throws Exception {
            Coordinates coord = state.getZeroCoordinates();
            Integer[][] data = state.getData();
            Integer currentPoint = new Integer(data[coord.getJ()][coord.getI()]);
            data[coord.getJ()][coord.getI()] = data[coord.getJ()][coord.getI() + 1];
            data[coord.getJ()][coord.getI() + 1] = currentPoint;
            return state;
        }
    },

    LEFT_ROTATE {
        public State rotate(State state) throws Exception {
            Coordinates coord = state.getZeroCoordinates();
            Integer[][] data = state.getData();
            Integer currentPoint = new Integer(data[coord.getJ()][coord.getI()]);
            data[coord.getJ()][coord.getI()] = data[coord.getJ()][coord.getI() - 1];
            data[coord.getJ()][coord.getI() - 1] = currentPoint;
            return state;
        }
    },

    DOWN_ROTATE {
        public State rotate(State state) throws Exception {
            Coordinates coord = state.getZeroCoordinates();
            Integer[][] data = state.getData();
            Integer currentPoint = new Integer(data[coord.getJ()][coord.getI()]);
            data[coord.getJ()][coord.getI()] = data[coord.getJ() + 1][coord.getI()];
            data[coord.getJ() + 1][coord.getI()] = currentPoint;
            return state;
        }
    },
    UP_ROTATE {
        public State rotate(State state) throws Exception {
            Coordinates coord = state.getZeroCoordinates();
            Integer[][] data = state.getData();
            Integer currentPoint = new Integer(data[coord.getJ()][coord.getI()]);
            data[coord.getJ()][coord.getI()] = data[coord.getJ() - 1][coord.getI()];
            data[coord.getJ() - 1][coord.getI()] = currentPoint;
            return state;
        }
    };

    public abstract State rotate(State state) throws Exception;

}
