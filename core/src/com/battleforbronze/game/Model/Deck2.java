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
public class Deck2 {
    
    private Array<Card> cards;
    
    public Deck2(){
        
        cards = new Array<Card>();
        cards.add(new Card("Name", 1,  2, 1, 1));
        cards.add(new Card("Name", 2,  1, 1, 1));
        cards.add(new Card("Name", 3,  1, 1, 2));
        cards.add(new Card("Name", 1,  2, 3, 2));
        cards.add(new Card("Name", 4,  1, 1, 2));
        cards.add(new Card("Name", 1,  1, 6, 3));
        cards.add(new Card("Name", 5,  2, 2, 3));
        cards.add(new Card("Name", 1,  5, 2, 3));
        cards.add(new Card("Name", 3,  3, 2, 4));
        cards.add(new Card("Name", 2,  3, 3, 4));
        cards.add(new Card("Name", 5,  1, 1, 4));
        cards.add(new Card("Name", 1,  1, 6, 4));
        cards.add(new Card("Name", 5,  2, 2, 5));
        cards.add(new Card("Name", 2,  5, 2, 5));
        cards.add(new Card("Name", 5,  5, 2, 6));
        cards.add(new Card("Name", 2,  6, 4, 6));
        cards.add(new Card("Name", 1,  1, 7, 7));
        cards.add(new Card("Name", 3,  5, 3, 7));
        cards.add(new Card("Name", 8,  3, 3, 8));
        cards.add(new Card("Name", 9,  4, 4, 9));   
        
    }
   
    public void shuffle(){
        cards.shuffle();    
    }
    
    public void draw(){
        
    }
    
    public void add(){
        
    }
    
}
