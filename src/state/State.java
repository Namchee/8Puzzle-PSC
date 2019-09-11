/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author Namchee
 */
public class State {
    private static final int[] GOAL_STATE = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
    
    private int[] puzzle;
    
    public State(int[] puzzle) {
        this.isValidState(puzzle);
        this.puzzle = puzzle;
    }
    
    public int[] getPuzzle() {
        return this.puzzle;
    }
    
    public void print(){
        for (int i = 0; i < this.puzzle.length; i++) {
            System.out.print(this.puzzle[i]+" ");
        }
        System.out.println("");
    }
    
    public boolean isGoalState() {
        for (int i = 0; i < 9; i++) {
            if (this.puzzle[i] != State.GOAL_STATE[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int[] getSuccessor(int swap) {
        int[] copy = this.copyArray();
        
        try {
            int blankIdx = this.getBlank();
            
            copy[blankIdx] += copy[blankIdx + swap];
            copy[blankIdx + swap] = copy[blankIdx] - copy[blankIdx + swap];
            copy[blankIdx] -= copy[blankIdx + swap];
            
            return copy;
        } catch (IndexOutOfBoundsException err) {
            throw err;
        }
    }
    
    public int getHeuristic() {
        int heuristic = 0;
        
        for (int i = 0; i < 9; i++) {
            if (this.puzzle[i] != State.GOAL_STATE[i]) {
                heuristic++;
            }
        }
        
        return heuristic;
    }
    
    public int getManhattanDistance() {
        int distance = 0;
        
        for (int i = 0; i < 9; i++) {
            distance += Math.abs(i - (this.puzzle[i] - 1));
        }
        
        return distance;
    }
    
    private int getBlank() {
        for (int i = 0; i < 9; i++) {
            if (this.puzzle[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int[] copyArray() {
        return Arrays.copyOf(this.puzzle, this.puzzle.length);
    }
    
    private void isValidState(int[] puzzle) {
        int[] frequency = new int[9];
        
        for (int i = 0; i < 9; i++) {
            if (puzzle[i] >= 0 && puzzle[i] < 9) {
                frequency[puzzle[i]]++;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (frequency[i] != 1) {
                throw new InputMismatchException("Illegal puzzle");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        
        return Arrays.equals(this.puzzle, other.puzzle);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Arrays.hashCode(this.puzzle);
        return hash;
    }
}
