/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;
import state.Node;

/**
 *
 * @author Namchee
 */
public abstract class Solver {
    protected static final int[] MOVES = { -1, 1, -3, 3 };
    
    public abstract Node solve(int[] puzzle);
}
