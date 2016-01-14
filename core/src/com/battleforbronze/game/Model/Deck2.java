/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.utils.Array;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * String name, int force, int attack, int defense, int cost
 * @author valet8115
 */
public class Deck2 {   
    private Array<Card> deckTwo;
    private static final Random RAND = new Random();
    /**
     * creates the cards inside of the deck
     */
    public Deck2(){
        
        deckTwo = new Array<Card>();
        deckTwo.add(new Card("Mr Lamont", 1,  2, 1, 1));
        deckTwo.add(new Card("Master Yi", 2,  1, 1, 1));
        deckTwo.add(new Card("Chadee", 3,  1, 1, 2));
        deckTwo.add(new Card("Gestle", 1,  2, 3, 2));
        deckTwo.add(new Card("Caitlyn", 4,  1, 1, 2));
        deckTwo.add(new Card("Surick", 1,  1, 6, 3));
        deckTwo.add(new Card("Jax", 5,  2, 2, 3));
        deckTwo.add(new Card("Phaard", 1,  5, 2, 3));
        deckTwo.add(new Card("Jocstain", 3,  3, 2, 4));
        deckTwo.add(new Card("Gepalest", 2,  3, 3, 4));
        deckTwo.add(new Card("Lee Sin", 5,  1, 1, 4));
        deckTwo.add(new Card("Reytethor", 1,  1, 6, 4));
        deckTwo.add(new Card("Leo the Lion", 5,  2, 2, 5));
        deckTwo.add(new Card("Echo", 2,  5, 2, 5));
        deckTwo.add(new Card("Tim", 5,  5, 2, 6));
        deckTwo.add(new Card("XxOpticXfireXx", 2,  6, 4, 6));
        deckTwo.add(new Card("Azir", 1,  1, 7, 7));
        deckTwo.add(new Card("Zed", 3,  5, 3, 7));
        deckTwo.add(new Card("PhenoixPhlare", 8,  3, 3, 8));
        deckTwo.add(new Card("N@me", 9,  4, 4, 9));   
        
    }
   /**
    * shuffles the array
    */
    public Array<Card> shuffle(){    
        for (int i = 0; i < deckTwo.size; i++) {
            int length = deckTwo.size - i;
            int random = (int)Math.floor(i + Math.random() * (length));
            
            deckTwo.swap(i, random);
        }
        return deckTwo;
  
    }  
    /*
     * gets the first card in the deck
     */
    public Card firstCard(){
        return deckTwo.first();
           
    }
    /**
     * removes the first card
     * @return 
     */
    public Card removeFirst(){
        return deckTwo.removeIndex(0);
    }
    /**
     * gets the current deck size
     * @return 
     */
    public int deckSize(){
        return deckTwo.size;
    }
    
    public Card draw(){
        Card draw = deckTwo.get(0);
        deckTwo.removeIndex(0);
        return draw;
    }
    
        public String getName(int pos){
        Card temp = deckTwo.get(pos);
        String name = temp.getName();
        return name;



    }
    
}
