/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

/**
 *
 * @author Leo Yao
 */
public class Entity {
    private int posX;
    private int posY;
    private boolean hasCrashed;
    
    public Entity(int x, int y){
      posX = x;
      posY = y;  
      hasCrashed = false;
    }
    
    public void crash(){
        hasCrashed = true;
    } 
    
    public boolean hasCrashed(){
       return hasCrashed;
    }

    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
