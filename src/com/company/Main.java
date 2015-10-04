package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        State startState = new State(new Integer[][]{
                {6, 0, 8},
                {5, 2, 1},
                {4, 3, 7}
        });

        State endState = new State(new Integer[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        });

        Problem problem = new Problem(startState, endState);

        List<State> states = new SolutionFinder().generalSearch(problem, new Strategy());
        System.out.println("Proceeded " + states.size() + " steps");
    }
}
