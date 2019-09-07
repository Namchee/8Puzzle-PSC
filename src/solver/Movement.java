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

// HMM, gw gk tau kenapa kalo pake enum malah ga ketemu jawabannya...
public enum Movement {
    LEFT(-1), RIGHT(1), UP(-3), DOWN(3);
    
    public final int x;
    
    private Movement(int x) {
        this.x = x;
    }
}
