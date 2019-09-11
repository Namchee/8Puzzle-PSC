
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import solver.Solver;
import solver.SolverFactory;
import state.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Namchee
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String argument = sc.next();
        
        int [] puzzle = new int[9];
        
        for (int i = 0; i < 9; i++) {
            puzzle[i] = sc.nextInt();
        }
        
        Solver solver = SolverFactory.createSolver(argument);
        
        long start = System.currentTimeMillis();
        
        Node solution = solver.solve(puzzle);
        
        long end = System.currentTimeMillis();
        
        List<String> paths = new ArrayList();
        
        System.out.println("Solvable in: " + solution.getCost() + " moves.");
        
        System.out.println("Expanded nodes: " + solver.getExpandedNodes() + " nodes.");
        
        System.out.println("Moves used:");
        
        Node.translateMoves(solution, paths);
        
        paths.forEach((path) -> {
            System.out.println(path);
        });
        
        System.out.println("Solved in: " + (end - start) + " millis.");
    }
}