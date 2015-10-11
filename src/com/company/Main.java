package com.company;

import com.company.logic.*;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        State startState = new State(new int[][]{
                {6, 0, 8},
                {5, 2, 1},
                {4, 3, 7}
        }, new Coordinates(1, 0));

        State endState = new State(new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        }, new Coordinates(1, 1));

        Problem problem = new Problem(startState, endState);

        List<State> solution = new SolutionFinder().generalSearch(problem, new Strategy());
        if (solution.isEmpty()) {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("There is no solution for this task");
            System.out.println("It takes " + (duration / 1000000) + "ms");
        } else {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Has solution with " + solution.size() + " steps");
            System.out.println("It takes " + (duration / 1000000) + "ms");

        }

    }
}
