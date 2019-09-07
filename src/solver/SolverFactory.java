/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

/**
 *
 * @author Namchee
 */
public class SolverFactory {
    public static Solver createSolver(String args) {
        if (args.equals("bfs")) {
            return new BFSSolver();
        } else {
            return new BFSSolver();
        }
    }
}
