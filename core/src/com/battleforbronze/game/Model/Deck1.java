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
public class Deck1 {  
    private Array<Card> deckOne;
    /**
     * creates deck and makes all cards
     */
    public Deck1(){
        
        deckOne = new Array<Card>();
        deckOne.add(new Card("Name", 1,  2, 1, 1));
        deckOne.add(new Card("Name", 2,  1, 1, 1));
        deckOne.add(new Card("Name", 3,  1, 1, 2));
        deckOne.add(new Card("Name", 1,  2, 3, 2));
        deckOne.add(new Card("Name", 4,  1, 1, 2));
        deckOne.add(new Card("Name", 1,  1, 6, 3));
        deckOne.add(new Card("Name", 5,  2, 2, 3));
        deckOne.add(new Card("Name", 1,  5, 2, 3));
        deckOne.add(new Card("Name", 3,  3, 2, 4));
        deckOne.add(new Card("Name", 2,  3, 3, 4));
        deckOne.add(new Card("Name", 5,  1, 1, 4));
        deckOne.add(new Card("Name", 1,  1, 6, 4));
        deckOne.add(new Card("Name", 5,  2, 2, 5));
        deckOne.add(new Card("Name", 2,  5, 2, 5));
        deckOne.add(new Card("Name", 5,  5, 2, 6));
        deckOne.add(new Card("Name", 2,  6, 4, 6));
        deckOne.add(new Card("Name", 1,  1, 7, 7));
        deckOne.add(new Card("Name", 3,  5, 3, 7));
        deckOne.add(new Card("Name", 8,  3, 3, 8));
        deckOne.add(new Card("Name", 9,  4, 4, 9));
    }
    /**
     * shuffles the array
     */
    public void shuffle(){
        deckOne.shuffle();
    }   
    /**
     * gets the first card
     * @return 
     */
    public Card firstCard(){
        return deckOne.first();
           
    }
    /**
     * removes the first card
     * @return 
     */
    public Card removeFirst(){
        return deckOne.removeIndex(0);
    }
    /**
     * gets the current deck size
     * @return 
     */
    public int deckSize(){
        return deckOne.size;
    }
    
}
