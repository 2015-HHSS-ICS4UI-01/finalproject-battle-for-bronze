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
public class Card {
    
    private String name;
    private int force;
    private int attack;
    private int defense;
    private int cost;
  
    public Card(String name, int force, int attack, int defense, int cost){
        this.name = name;
        this.attack = attack;
        this.cost = cost;
        this.defense = defense;
        this.force = force;
    }
      
    public int force (){
        return this.force;      
    }
    
    public int attack (){
        return this.attack;      
    }
    
    public int defense (){
        return this.defense; 
    }
    
    public int cost (){
        return this.cost;
    }
    
    public String name(){
        return this.name;
    }
    
    
    
}
