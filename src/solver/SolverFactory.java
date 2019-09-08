/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import java.util.InputMismatchException;

/**
 *
 * @author Namchee
 */
public class SolverFactory {
    public static Solver createSolver(String args) {
        if (args.equals("bfs")) {
            return new BFSSolver();
        } else {
            throw new InputMismatchException("Hmm... saya tidak mengerti algoritma ini");
        }
    }
}
