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
    
    public Card(String name){
        this.name = name;
        this.attack = (int) Math.ceil(Math.random() * 9);
        this.cost = (int) Math.ceil(Math.random() * 9);
        this.defense = (int) Math.ceil(Math.random() * 9);
        this.force = (int) Math.ceil(Math.random() * 9);
    }
    
    public int getForce (){
        return this.force;      
    }   
    public int getAttack (){
        return this.attack;      
    }  
    public int getDefense (){
        return this.defense; 
    }   
    public int getCost (){
        return this.cost;
    }    
    public String getName(){
        return this.name;
    }  
    
}
