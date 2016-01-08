/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Tim Valeriote
 */
public class Player1Hand {
    
    private int currentHandSize;
    private Deck1 player1Deck;
    private Array<Card> hand;
    private boolean canDraw;
    private int cardPlayed;
    
    /**
     * player 1's hand
     */
    public Player1Hand() {
        
        hand = new Array<Card>();
        player1Deck = new Deck1();
        
    }
    
    /*
     * gets the current hand size
     */
    public int currentHandSize(){
        return hand.size;
    }
    /*
     * creates the starting hand
     */
    public void startingHand(){
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
    }
    /*
     * draws the first card
     */
    public void draw(){
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
    }
    /*
     * checks if you can draw
     */
    public boolean canDraw(){
        return this.canDraw;
    }
    /*
     * removes the card that is played from the array
     */
    public Card removeFromHand(){
        return hand.removeIndex(cardPlayed);
    }
    
    public Array<Card> getCards(){
        return hand;
    }
    
    
}
