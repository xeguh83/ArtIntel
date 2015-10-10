package com.company;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by например Андрей on 04.10.2015.
 */
public class SolutionFinder {

    public List<State> generalSearch(Problem problem, Strategy strategy) throws Exception {

        TreeOfStates tree = new TreeOfStates(problem.getStartState());
        while (tree.getStackToWatch().size() != 0) {
            State currentState = tree.getStackToWatch().poll();
            if (currentState.equals(problem.getEndState())) {
                LinkedList<State> solutionList = new LinkedList<>();
                solutionList.push(currentState);
                while (currentState.getParent() != null) {
                    currentState = currentState.getParent();
                    solutionList.push(currentState);
                }
                return solutionList;
            }
            tree.addChildrenToStack(currentState);
        }
        return new LinkedList<State>();


    }

}
