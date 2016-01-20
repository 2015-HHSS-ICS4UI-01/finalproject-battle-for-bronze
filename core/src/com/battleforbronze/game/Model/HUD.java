/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

/**
 *
 * @author valet8115
 */
public class HUD {
    
    private int turnNumberP1;
    private int turnNumberP2;
        
    public HUD() {
        turnNumberP1 = 1;
        turnNumberP2 = 1;
    }
    
    public int addOneP1(){
        if (turnNumberP1 < 10){
        turnNumberP1++;
        return turnNumberP1; 
        } else {
        return turnNumberP1;
        }
        
    }
    
    public int addOneP2(){
        if (turnNumberP2 < 10){
        turnNumberP2++;
        return turnNumberP2; 
        } else {
        return turnNumberP2;
        }
    }
    
    public int getTurnNumberP1(){
        return turnNumberP1;
    }
    
    public int getTurnNumberP2(){
        return turnNumberP2;
    }
    
    
}
