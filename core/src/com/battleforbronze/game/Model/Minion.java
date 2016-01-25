/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

/**
 *
 * @author valet8115
 */
public class Minion {

    private String name;
    private int force;
    private int attack;
    private int defense;

    public Minion(String name, int force, int attack, int defense, int cost) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.force = force;
    }

    public int getForce() {
        return this.force;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public String getName() {
        return this.name;
    }

}
