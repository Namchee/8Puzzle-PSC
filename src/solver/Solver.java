/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import state.Node;
import state.State;

/**
 *
 * @author Namchee
 */
public abstract class Solver {
    protected static final int[] MOVES = { -1, 1, -3, 3 };
    
    public abstract Node solve(int[] puzzle);
    
    protected List<Integer> generatePuzzleSet(int[] puzzle) {
        List<Integer> puzzleSet = new ArrayList();
        
        for (int i = 0; i < 9; i++) {
            puzzleSet.add(puzzle[i]);
        }
        
        return puzzleSet;
    }
    
    
    
    protected List<Node> getSuccessorNodes(Node currentNode, HashSet<List<Integer> > set) {
        List<Node> successors = new ArrayList();
        State currentState = currentNode.getState();
        
        for (int i = 0; i < 4; i++) {
            try {
                int[] newPuzzle = currentState.getSuccessor(MOVES[i]);
                List<Integer> puzzleSet = this.generatePuzzleSet(newPuzzle);
            
                if (!set.contains(puzzleSet)) {
                    set.add(puzzleSet);
                
                    State newState = new State(newPuzzle);
                    Node newNode = new Node(newState, currentNode.getCost() + 1, MOVES[i]);
                
                    newNode.setParent(currentNode);
                
                    successors.add(newNode);
                }
            } catch (IndexOutOfBoundsException err) {
                
            }
        }
        
        return successors;
    }
    
    public void translateMoves(Node solution, List<String> bucket) {
        if (solution.getParent() != null) {
            translateMoves(solution.getParent(), bucket);
        }
        
        int path = solution.getPath();
        
        switch (path) {
            case 1: bucket.add("RIGHT");
            break;
            case -1: bucket.add("LEFT");
            break;
            case 3: bucket.add("DOWN");
            break;
            case -3: bucket.add("UP");
            break;
            default: bucket.add("START");
            break;
        }
    }
}
