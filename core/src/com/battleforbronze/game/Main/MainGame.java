/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.battleforbronze.game.Model.Deck1;
import com.battleforbronze.game.Model.Deck2;
import com.battleforbronze.game.Model.Player1Hand;
import com.battleforbronze.game.Model.Player2Hand;
import com.battleforbronze.game.Screens.WorldRenderer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Leo Yao
 */
public class MainGame implements Screen, InputProcessor, MouseListener {

    private Player1Hand playerOneHand;
    private Player2Hand playerTwoHand;
    private Deck1 deckOne;
    private Deck2 deckTwo;
    private WorldRenderer renderer;
    private boolean turn;
    private float timer = 0;

    public MainGame() {

        Timer timer = new Timer();
        deckOne = new Deck1();
        deckTwo = new Deck2();
        playerOneHand = new Player1Hand();
        playerTwoHand = new Player2Hand();
        renderer = new WorldRenderer();
        Gdx.input.setInputProcessor(this);
        deckOne.shuffle();
        deckTwo.shuffle();
        playerOneHand.startingHand();
        playerTwoHand.startingHand();
        
        System.out.println("Player One's turn, go!");


    }

    @Override
    public void show() {
    }

    public void render(float deltaTime) {
        // draw the screen
        renderer.render(deltaTime);
        //shuffle the deck then create the players hands 
        
        timer += deltaTime;
        if(timer >= (60 * 2)){
            System.out.println("swtiched turns");
            if (turn == true){ 
                playerOneHand.draw();
                System.out.println("Player ones hand is: " + playerOneHand.currentHandSize());
                turn = false; 
                timer = 0;
                
            } else {
                playerTwoHand.draw();
                System.out.println("Player twos hand is: " + playerTwoHand.currentHandSize());
                turn = true;
                timer = 0;
            }   
            
        }
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)){
            System.out.println("switched to player twos turn");
            playerTwoHand.draw();
            System.out.println("Players 2 hand is: " + playerTwoHand.currentHandSize());
            turn = false;
            timer = 0;
            
        }
        
        if (Gdx.input.isKeyJustPressed(Keys.SHIFT_RIGHT)){
            System.out.println("switched to player ones turn");
            playerOneHand.draw();
            System.out.println("Players 1 hand is: " + playerOneHand.currentHandSize());
            turn = true;
            timer = 0;
            
        }

    }

    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        renderer.zoom(amount);
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
