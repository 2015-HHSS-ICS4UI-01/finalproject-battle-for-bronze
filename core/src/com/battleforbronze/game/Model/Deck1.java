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
 *
 * @author valet8115
 */
public class Deck1 {

    private Array<Card> deckOne;
    private static final Random RAND = new Random();

    /**
     * creates deck and makes all cards
     */
    public Deck1() {

        deckOne = new Array<Card>();
        deckOne.add(new Card("Mr Lamont", 1, 2, 1, 1));
        deckOne.add(new Card("Master Yi", 2, 1, 1, 1));
        deckOne.add(new Card("Chadee", 3, 1, 1, 2));
        deckOne.add(new Card("Gestle", 1, 2, 3, 2));
        deckOne.add(new Card("Caitlyn", 4, 1, 1, 2));
        deckOne.add(new Card("Surick", 1, 1, 6, 3));
        deckOne.add(new Card("Jax", 5, 2, 2, 3));
        deckOne.add(new Card("Phaard", 1, 5, 2, 3));
        deckOne.add(new Card("Jocstain", 3, 3, 2, 4));
        deckOne.add(new Card("Gepalest", 2, 3, 3, 4));
        deckOne.add(new Card("Lee Sin", 5, 1, 1, 4));
        deckOne.add(new Card("Reytethor", 1, 1, 6, 4));
        deckOne.add(new Card("Leo the Lion", 5, 2, 2, 5));
        deckOne.add(new Card("Echo", 2, 5, 2, 5));
        deckOne.add(new Card("Tim", 5, 5, 2, 6));
        deckOne.add(new Card("XxOpticXfireXx", 2, 6, 4, 6));
        deckOne.add(new Card("Azir", 1, 1, 7, 7));
        deckOne.add(new Card("Zed", 3, 5, 3, 7));
        deckOne.add(new Card("PhenoixPhlare", 8, 3, 3, 8));
        deckOne.add(new Card("N@me", 9, 4, 4, 9));
    }

    /**
     * shuffles the array
     */
    public Array<Card> shuffle(){    
        for (int i = 0; i < deckOne.size; i++) {
            int length = deckOne.size - i;
            int random = (int)Math.floor(i + Math.random() * (length));
            
            deckOne.swap(i, random);
        }
        return deckOne;
  
    } 
    
   
    
    /**
     * for length of array
     * get size of array
     * get a random in from the size of the array
     * remove the card at random
     * remove the card at the current spot (i)
     * place the randomly removed card at i
     * place the card at spot i in the random spot
     */

      
    /**
     * gets the first card
     *
     * @return
     */
    public Card firstCard() {
        return deckOne.first();

    }

    /**
     * removes the first card
     *
     * @return
     */
    public Card removeFirst() {
        return deckOne.removeIndex(0);
    }

    /**
     * gets the current deck size
     *
     * @return
     */
    public int deckSize() {
        return deckOne.size;
    }
    
    public Card draw(){
        Card draw = deckOne.get(0);
        deckOne.removeIndex(0);
        return draw;
    }
    
    public String getName(int pos){
        Card temp = deckOne.get(pos);
        String name = temp.getName();
        return name;
    }
    
    
}
