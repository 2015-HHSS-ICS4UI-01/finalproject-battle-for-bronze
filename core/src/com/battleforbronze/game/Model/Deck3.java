/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author paulm6438
 */
public class Deck3 {
    private Array<Card> deckThree;

     
    /**
     * creates deck and makes all cards
     */
    public Deck3(){ 

        deckThree = new Array<Card>();
        deckThree.add(new Card("Mr Lamont"));
        deckThree.add(new Card("Master Yi"));
        deckThree.add(new Card("Chadee"));
        deckThree.add(new Card("Gestle"));
        deckThree.add(new Card("Caitlyn"));
        deckThree.add(new Card("Surick"));
        deckThree.add(new Card("Jax"));
        deckThree.add(new Card("Phaard"));
        deckThree.add(new Card("Jocstain"));
        deckThree.add(new Card("Gepalest"));
        deckThree.add(new Card("Lee Sin"));
        deckThree.add(new Card("Reytethor"));
        deckThree.add(new Card("Leo the Lion"));
        deckThree.add(new Card("Echo"));
        deckThree.add(new Card("Tim"));
        deckThree.add(new Card("XxOpticXfireXx"));
        deckThree.add(new Card("Azir"));
        deckThree.add(new Card("Zed"));
        deckThree.add(new Card("PhenoixPhlare"));
        deckThree.add(new Card("N@me"));
        
        
        

    }
    /** Random name Method
//    public Deck3(){ 
//
//        deckThree = new Array<Card>();
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//        deckThree.add(new Card());
//    }
    
    /**
     * shuffles the array
     */
    public void shuffle(){
        deckThree.shuffle();
    }   
    /**
     * gets the first card
     * @return 
     */
    public Card firstCard(){
        return deckThree.first();
           
    }
    /**
     * removes the first card
     * @return 
     */
    public Card removeFirst(){
        return deckThree.removeIndex(0);
    }
    /**
     * gets the current deck size
     * @return 
     */
    public int deckSize(){
        return deckThree.size;
    }
    
}
