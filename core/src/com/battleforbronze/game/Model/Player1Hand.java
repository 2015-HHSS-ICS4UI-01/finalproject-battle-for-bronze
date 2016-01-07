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
    
    public Player1Hand() {
        
        hand = new Array<Card>();
        player1Deck = new Deck1();
        
    }
    
    
    public int currentHandSize(){
        return this.currentHandSize;
    }
    
    public void startingHand(){
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
    }
    
    public void draw(){
        hand.add(player1Deck.firstCard());
        player1Deck.removeFirst();
    }
    
    public boolean canDraw(){
        return this.canDraw;
    }
    
    public Card removeFromHand(){
        return hand.removeIndex(cardPlayed);
    }
    
    
}
