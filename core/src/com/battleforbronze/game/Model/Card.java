/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

/**
 *
 * @author Leo Yao
 */
public class Card {

    private String name;
    private int force;
    private int attack;
    private int defense;
    private int cost;
    private String pre;
    private String root;
    private String suf;

    public Card(String name, int force, int attack, int defense, int cost) {
        this.name = name;
        this.attack = attack;
        this.cost = cost;
        this.defense = defense;
        this.force = force;
    }

    /**
     * Random attack/cost/defense and force REQUIRED: use random method;
     *
     * @param name
     */
    public Card(String name) {
        this.name = name;
        this.attack = (int) Math.ceil(Math.random() * 6);
        this.cost = (int) Math.ceil(Math.random() * 4);
        this.defense = (int) Math.ceil(Math.random() * 6);
        this.force = (int) Math.ceil(Math.random() * 6);
    }

    /**
     * Random name/attack/cost/defense and force REQUIRED: use random method.
     */
    public Card() {
        int numPre = (int) Math.ceil(Math.random() * 6);
        int numRoot = (int) Math.ceil(Math.random() * 6);
        int numSuf = (int) Math.ceil(Math.random() * 6);

        //Prefix

        if (numPre == 1) {
            pre = "Un";
        } else if (numPre == 2) {
            pre = "Ex";
        } else if (numPre == 3) {
            pre = "Mis";
        } else if (numPre == 4) {
            pre = "Co";
        } else if (numPre == 5) {
            pre = "Dis";
        } else if (numPre == 6) {
            pre = "Re";
        }

        //Root

        if (numRoot == 1) {
            pre = "techno";
        } else if (numRoot == 2) {
            pre = "acro";
        } else if (numRoot == 3) {
            pre = "meta";
        } else if (numRoot == 4) {
            pre = "para";
        } else if (numRoot == 5) {
            pre = "struck";
        } else if (numRoot == 6) {
            pre = "bene";
        }

        //Sufix

        if (numSuf == 1) {
            suf = "able";
        } else if (numSuf == 2) {
            suf = "en";
        } else if (numSuf == 3) {
            suf = "else";
        } else if (numSuf == 4) {
            suf = "al";
        } else if (numSuf == 5) {
            suf = "ic";
        } else if (numSuf == 6) {
            suf = "ian";
        }

        this.name = pre + root + suf;
        this.attack = (int) Math.ceil(Math.random() * 6);
        this.cost = (int) Math.ceil(Math.random() * 4);
        this.defense = (int) Math.ceil(Math.random() * 6);
        this.force = (int) Math.ceil(Math.random() * 6);
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

    public int getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }
}
