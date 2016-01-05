/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author valet8115
 */
public class Deck1 {  
    private Array<Card> cards;
    
    public Deck1(){
        
        cards = new Array<Card>();
       
        cards.add(new Card("najkna", 10,  5, 2, 100));
    }
    
    public void createDeck(){
        
    }
    public void shuffle(){
        
    }   
    public void draw(){
        
    }   
    public void add(){       
    }   
}
