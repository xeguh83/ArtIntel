package com.company;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by например Андрей on 04.10.2015.
 */
public class SolutionFinder {

    List<State> checkedStates = new ArrayList<>();
    List<State> solution = new ArrayList<>();

    public List<State> generalSearch(Problem problem, Strategy strategy) throws Exception {

        List<State> stackList = new ArrayList<State>();
        State rootState = problem.getStartState();
        stackList.add(rootState);

        while (true) {
            if (checkedStates.contains(stackList.get(0))) {
                stackList.remove(0);
                continue;
            } else {
                checkedStates.add(stackList.get(0));
            }

            State currentState = stackList.get(0);

            if (currentState.equals(problem.getEndState())) {
                //TODO реализовать что делать при нахождении результата
                return checkedStates;
            }

            List<Move> availableMoves = MoveRuler.getAvailableMoves(currentState);
            for (int i = 0; i < availableMoves.size(); i++) {
                stackList.add(0, availableMoves.get(i).rotate(currentState));
            }

            if (checkedStates.size() % 10000 == 0) {
                System.out.println(checkedStates.size());
            }
        }


    }

}
