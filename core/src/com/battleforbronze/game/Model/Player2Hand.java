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
    private Deck2 player2Deck;
    private Array<Card> hand;
    private boolean canDraw;
    private int cardPlayed;
    
    public Player2Hand() {
        
        hand = new Array<Card>();
        player2Deck = new Deck2();
        
    }
  
    public int currentHandSize(){
        return hand.size;
    }
    
    public void startingHand(){
        hand.add(player2Deck.draw());
        hand.add(player2Deck.draw());
        hand.add(player2Deck.draw());
    }
    
    public void draw(){
        hand.add(player2Deck.draw());
    }
    
    public boolean canDraw(){
        return this.canDraw;
    }
    
    public Card removeFromHand(){
        return hand.removeIndex(cardPlayed);
    }
    
    public Array<Card> getCards(){
        return hand;
    }
    
    public Card getCard(int pos){
        return hand.get(pos);
    }
    
    public int handSize(){
        return hand.size;
    }
    
    public int getAttk(Card card){
        return card.getAttack();
    }
    public int getFrc(Card card){
        return card.getForce();
    }
    public int getDfnc(Card card){
        return card.getDefense();
    }
    public int getCost(Card card){
        return card.getCost();
    }
    public String getName(Card card){
        return card.getName();
    }
    
    
}
