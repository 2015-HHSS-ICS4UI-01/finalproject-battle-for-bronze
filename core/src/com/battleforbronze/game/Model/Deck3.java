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
    public Deck3() {

        deckThree = new Array<Card>();
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());
        deckThree.add(new Card());

    }

    /**
     * shuffles the array
     */
    public void shuffle() {
        deckThree.shuffle();
    }

    /**
     * gets the first card
     *
     * @return
     */
    public Card firstCard() {
        return deckThree.first();

    }

    /**
     * removes the first card
     *
     * @return
     */
    public Card removeFirst() {
        return deckThree.removeIndex(0);
    }

    /**
     * gets the current deck size
     *
     * @return
     */
    public int deckSize() {
        return deckThree.size;
    }
}
