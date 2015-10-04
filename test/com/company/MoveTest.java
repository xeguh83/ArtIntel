package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by например Андрей on 04.10.2015.
 */
public class MoveTest {

    @Test
    public void shouldCorrectlyMoveTopRight() throws Exception {
        State state = new State(new Integer[][] {
                {1, 0, 2},
                {3, 4, 5},
                {6, 7, 8}
        });

        State changedState = Move.RIGHT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 2, 0},
                {3, 4, 5},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldCorrectlyMoveTopLeft() throws Exception {
        State state = new State(new Integer[][] {
                {1, 0, 2},
                {3, 4, 5},
                {6, 7, 8}
        });

        State changedState = Move.LEFT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
         public void shouldCorrectlyMoveMidRight() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });

        State changedState = Move.RIGHT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 4, 2},
                {3, 5, 0},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldCorrectlyMoveMidLeft() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });

        State changedState = Move.LEFT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 4, 2},
                {0, 3, 5},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldCorrectlyMoveLowRight() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 7, 5},
                {6, 0, 8}
        });

        State changedState = Move.RIGHT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 4, 2},
                {3, 7, 5},
                {6, 8, 0}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldCorrectlyMoveMidUp() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });

        State changedState = Move.UP_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 0, 2},
                {3, 4, 5},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldCorrectlyMoveMidDown() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });

        State changedState = Move.DOWN_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 4, 2},
                {3, 7, 5},
                {6, 0, 8}
        });

        assertEquals(stateForCheck, changedState);
    }

    @Test
    public void shouldStateNotChangedWhileRotating() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });
        State changedState = Move.RIGHT_ROTATE.rotate(state);

        State stateForCheck = new State(new Integer[][] {
                {1, 4, 2},
                {3, 0, 5},
                {6, 7, 8}
        });

        assertEquals(stateForCheck, state);
    }

}