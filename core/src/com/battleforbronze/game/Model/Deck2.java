/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.utils.Array;

/**
 * String name, int force, int attack, int defense, int cost
 * @author valet8115
 */
public class Deck2 {
    
    private Array<Card> deckTwo;
    
    public Deck2(){
        
        deckTwo = new Array<Card>();
        deckTwo.add(new Card("Name", 1,  2, 1, 1));
        deckTwo.add(new Card("Name", 2,  1, 1, 1));
        deckTwo.add(new Card("Name", 3,  1, 1, 2));
        deckTwo.add(new Card("Name", 1,  2, 3, 2));
        deckTwo.add(new Card("Name", 4,  1, 1, 2));
        deckTwo.add(new Card("Name", 1,  1, 6, 3));
        deckTwo.add(new Card("Name", 5,  2, 2, 3));
        deckTwo.add(new Card("Name", 1,  5, 2, 3));
        deckTwo.add(new Card("Name", 3,  3, 2, 4));
        deckTwo.add(new Card("Name", 2,  3, 3, 4));
        deckTwo.add(new Card("Name", 5,  1, 1, 4));
        deckTwo.add(new Card("Name", 1,  1, 6, 4));
        deckTwo.add(new Card("Name", 5,  2, 2, 5));
        deckTwo.add(new Card("Name", 2,  5, 2, 5));
        deckTwo.add(new Card("Name", 5,  5, 2, 6));
        deckTwo.add(new Card("Name", 2,  6, 4, 6));
        deckTwo.add(new Card("Name", 1,  1, 7, 7));
        deckTwo.add(new Card("Name", 3,  5, 3, 7));
        deckTwo.add(new Card("Name", 8,  3, 3, 8));
        deckTwo.add(new Card("Name", 9,  4, 4, 9));   
        
    }
   
    public void shuffle(){
        deckTwo.shuffle();
    }   
    public Card firstCard(){
        return deckTwo.first();
           
    }
    public Card removeFirst(){
        return deckTwo.removeIndex(0);
    }
    
    public int deckSize(){
        return deckTwo.size;
    }
    
}
