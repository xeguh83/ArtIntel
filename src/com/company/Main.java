package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        State startState = new State(new int[][]{
                {4, 5, 6},
                {3, 2, 0},
                {7, 1, 8}
        }, new Coordinates(2, 1));

        State endState = new State(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        }, new Coordinates(2, 2));

        Problem problem = new Problem(startState, endState);

        List<State> solution = new SolutionFinder().generalSearch(problem, new Strategy());
        if (solution == null) {
            System.out.println("There is no solution for this task");
        } else {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Has solution with " + solution.size() + " steps");
            System.out.println("It takes " + (duration / 1000000) + "ms");

        }

    }
}
