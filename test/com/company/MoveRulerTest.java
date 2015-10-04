package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by например Андрей on 04.10.2015.
 */
public class MoveRulerTest {
    @Test
    public void shouldHaveTwoMovesInTheConer() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 0},
                {3, 2, 5},
                {6, 7, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.LEFT_ROTATE);
        movesForCheck.add(Move.DOWN_ROTATE);

        assertEquals(movesForCheck,availableMoves);

    }


    @Test
    public void shouldHaveThreeMovesInTheRightSide() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 5},
                {3, 2, 0},
                {6, 7, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.LEFT_ROTATE);
        movesForCheck.add(Move.DOWN_ROTATE);
        movesForCheck.add(Move.UP_ROTATE);

        assertEquals(movesForCheck, availableMoves);

    }

    @Test
    public void shouldHaveThreeMovesInTheLeftSide() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 5},
                {0, 2, 3},
                {6, 7, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.RIGHT_ROTATE);
        movesForCheck.add(Move.DOWN_ROTATE);
        movesForCheck.add(Move.UP_ROTATE);

        assertEquals(movesForCheck, availableMoves);

    }

    @Test
    public void shouldHaveThreeMovesInTheBottomSide() throws Exception {
        State state = new State(new Integer[][] {
                {1, 4, 5},
                {7, 2, 3},
                {6, 0, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.LEFT_ROTATE);
        movesForCheck.add(Move.RIGHT_ROTATE);
        movesForCheck.add(Move.UP_ROTATE);

        assertEquals(movesForCheck, availableMoves);

    }

    @Test
    public void shouldHaveThreeMovesInTheTopSide() throws Exception {
        State state = new State(new Integer[][] {
                {1, 0, 5},
                {7, 2, 3},
                {6, 4, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.LEFT_ROTATE);
        movesForCheck.add(Move.RIGHT_ROTATE);
        movesForCheck.add(Move.DOWN_ROTATE);

        assertEquals(movesForCheck, availableMoves);

    }

    @Test
    public void shouldHaveFourMovesInTheCenter() throws Exception {
        State state = new State(new Integer[][] {
                {1, 2, 5},
                {7, 0, 3},
                {6, 4, 8}
        });

        List<Move> availableMoves = MoveRuler.getAvailableMoves(state);
        List<Move> movesForCheck = new ArrayList<Move>();
        movesForCheck.add(Move.LEFT_ROTATE);
        movesForCheck.add(Move.RIGHT_ROTATE);
        movesForCheck.add(Move.DOWN_ROTATE);
        movesForCheck.add(Move.UP_ROTATE);


        assertEquals(movesForCheck, availableMoves);

    }
}