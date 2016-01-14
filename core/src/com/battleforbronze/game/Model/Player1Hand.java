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
    
    public Array<Card> shuffleDeck(){
        return player1Deck.shuffle();
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
        hand.add(player1Deck.draw());
        hand.add(player1Deck.draw());
    }
    /*
     * draws the first card
     */
    public void draw(){
        hand.add(player1Deck.draw());  
    }
    /*
     * checks if you can draw
     */
    public boolean canDraw(){
        if(player1Deck.hasNext()){
            return true;
        }
        else{
            return false;
        }
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

