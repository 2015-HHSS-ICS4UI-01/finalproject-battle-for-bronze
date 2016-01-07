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
public class Player2Hand {
    
    private int currentHandSize;
    private Deck2 Player2Hand;
    private Array<Card> hand;
    private boolean canDraw;
    private int cardPlayed;
    
    public Player2Hand() {
        
        hand = new Array<Card>();
        Player2Hand = new Deck2();
        
    }
  
    public int currentHandSize(){
        return this.currentHandSize;
    }
    
    public void startingHand(){
        hand.add(Player2Hand.firstCard());
        Player2Hand.removeFirst();
        hand.add(Player2Hand.firstCard());
        Player2Hand.removeFirst();
        hand.add(Player2Hand.firstCard());
        Player2Hand.removeFirst();
        hand.add(Player2Hand.firstCard());
        Player2Hand.removeFirst();
    }
    
    public void draw(){
        hand.add(Player2Hand.firstCard());
        Player2Hand.removeFirst();
    }
    
    public boolean canDraw(){
        return this.canDraw;
    }
    
    public Card removeFromHand(){
        return hand.removeIndex(cardPlayed);
    }
    
}
