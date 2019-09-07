/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;
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
    
    @Override
    public int compareTo(Node other) {
        int currentCost = this.cost + this.currentState.getHeuristic();
        int otherCost = other.getCost() + other.getState().getHeuristic();
        
        return currentCost - otherCost;
    }
}
