/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Namchee
 */
public class Node implements Comparable<Node> {
    private State currentState;
    private Node parent;
    private int cost;
    private int path;
    
    public Node(State state, int cost, int path) {
        this.currentState = state;
        this.cost = cost;
        this.parent = null;
        this.path = path;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public State getState() {
        return this.currentState;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public int getPath() {
        return this.path;
    }
    
    public List<Node> getSuccessorNodes(int[] moves) {
        List<Node> successors = new ArrayList();
        
        for (int i = 0, sz = moves.length; i < sz; i++) {
            try {
                int[] newPuzzle = currentState.getSuccessor(moves[i]);
                State newState = new State(newPuzzle);
                Node newNode = new Node(newState, this.getCost() + 1, moves[i]);
                
                newNode.setParent(this);
                
                successors.add(newNode);
            } catch (IndexOutOfBoundsException err) {
                
            }
        }
        
        return successors;
    }
    
    public static void translateMoves(Node solution, List<String> bucket) {
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
    
    @Override
    public int compareTo(Node other) {
        int currentCost = this.cost + this.currentState.getManhattanDistance();
        int otherCost = other.getCost() + other.getState().getManhattanDistance(); 
        
        return currentCost - otherCost;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.currentState);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        Node other = (Node)obj;
        
        return this.currentState.equals(other.currentState);
    }
}

