package com.company;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by например Андрей on 04.10.2015.
 */
public class SolutionFinder {

    public Solution generalSearch(Problem problem, Strategy strategy) throws Exception {

        List<State> stackList = new ArrayList<State>();
        State rootState = problem.getStartState();
        List<Move> availableMoves = MoveRuler.getAvailableMoves(rootState);
        for (int i = 0; i < availableMoves.size(); i++) {
//            availableMoves.get(i).rotate(State)
        }


        return new Solution();
    }
}
