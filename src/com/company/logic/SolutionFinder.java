package com.company.logic;

import com.company.logic.dfs.TreeOfStatesForDepthSearch;
import com.company.logic.dsws.TreeOfStatesForDoubleSideWidthSearch;


import java.util.LinkedList;


/**
 * Created by �������� ������ on 04.10.2015.
 */
public class SolutionFinder {

    private long step = 0;

    public LinkedList<State> generalSearch(Problem problem, String strategy) throws Exception {
        if (strategy.equalsIgnoreCase("dfs")){
            return depthFirstSearch(problem);
        } else {
            throw new Exception("No correct strategy found");
        }
    }

    private LinkedList<State> depthFirstSearch(Problem problem) {
        TreeOfStatesForDepthSearch tree = new TreeOfStatesForDepthSearch(problem.getStartState());
        while (tree.getStackToWatch().size() != 0) {
            State currentState = tree.getStackToWatch().poll();
            step++;
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

    private LinkedList<State> doubleSideWidthSearch(Problem problem) {
        TreeOfStatesForDoubleSideWidthSearch tree = new TreeOfStatesForDoubleSideWidthSearch(problem.getStartState(), problem.getEndState());
        while ((tree.getStartQueue().size() != 0) || (tree.getEndQueue().size() != 0)) {
            step++;
            if (!tree.getStartQueue().isEmpty()){
                State currentStateStartQueue = tree.getStartQueue().poll();
                if (tree.getWatchedEndTree().contains(currentStateStartQueue)) {
                    return getSolutionList(currentStateStartQueue);
                }
                tree.addChildrenToStartQueue(currentStateStartQueue);
            }
            if (!tree.getEndQueue().isEmpty()){
                State currentStateEndQueue = tree.getEndQueue().poll();
                if (tree.getWatchedStartTree().contains(currentStateEndQueue)) {
                    return getSolutionList(currentStateEndQueue);
                }
                tree.addChildrenToEndQueue(currentStateEndQueue);
            }
        }
        return new LinkedList<State>();
    }

    private LinkedList<State> getSolutionList(State crossedState) {

        return null;
    }

    public long getStep(){
        return step;
    }

}
