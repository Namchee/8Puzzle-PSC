/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import state.Node;
import state.State;

/**
 *
 * @author Namchee
 */
public class BFSSolver extends Solver {
    @Override
    public Node solve(int[] initialPuzzle) {
        HashSet<Node> repeatingNodes = new HashSet();
        Queue<Node> queue = new LinkedList();
        
        State initalState = new State(initialPuzzle);
        Node initialNode = new Node(initalState, 0, 0);
        
        repeatingNodes.add(initialNode);
        queue.add(initialNode);
        
        Node goal = null;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            State currentState = currentNode.getState();
            
            if (currentState.isGoalState()) {
                goal = currentNode;
                break;
            } else {
                List<Node> nextNodes = currentNode.getSuccessorNodes(MOVES);
                
                for (Node nextNode: nextNodes) {
                    if (!repeatingNodes.contains(nextNode)) {
                        repeatingNodes.add(nextNode);
                        queue.add(nextNode);
                    }
                }
            }
        }
        
        return goal;
    }
}
