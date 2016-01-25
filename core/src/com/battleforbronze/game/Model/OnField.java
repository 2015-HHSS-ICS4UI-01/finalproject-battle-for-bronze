/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

/**
 *
 *
 */
public class OnField {

    private int x;
    private int y;

    public OnField(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int changeX(int newX) {
        x = newX;
        return x;
    }

    public int changeY(int newY) {
        y = newY;
        return y;
    }

}
