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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.battleforbronze.game.Model.Card;
import com.battleforbronze.game.Model.Deck1;
import com.battleforbronze.game.Model.Deck2;
import com.battleforbronze.game.Model.HUD;
import com.battleforbronze.game.Model.Player1Hand;
import com.battleforbronze.game.Model.Player2Hand;
import com.battleforbronze.game.Screens.WorldRenderer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.Collections;
import java.util.List;

//String name, int force, int attack, int defense, int cost
/**
 *
 * @author Leo Yao
 */
public class MainGame implements Screen, InputProcessor {

    private Player1Hand playerOneHand;
    private Player2Hand playerTwoHand;
    private Deck1 deckOne;
    private Deck2 deckTwo;
    private WorldRenderer renderer;
    private float timer = 0;
    private Card findCard;
    private int pos;
    private int attkFound;
    private int forceFound;
    private int defenceFound;
    private int costFound;
    private String nameFound;
    private Card drawn1;
    private Card drawn2;
    private HUD playerOneHUD;
    private HUD playerTwoHUD;
    private HUD turnNew;

    public MainGame() {
        playerTwoHUD = new HUD();
        playerOneHUD = new HUD();
        pos = 0;
        turnNew = new HUD();
        Timer timer = new Timer();
        deckOne = new Deck1();
        deckTwo = new Deck2();
        playerOneHand = new Player1Hand();
        playerTwoHand = new Player2Hand();
        renderer = new WorldRenderer(playerOneHand, playerTwoHand, playerOneHUD, playerTwoHUD, turnNew);
        Gdx.input.setInputProcessor(this);
        playerTwoHand.shuffleDeck();
        playerOneHand.shuffleDeck();
        playerOneHand.startingHand();
        playerTwoHand.startingHand();
    }

    @Override
    public void show() {
    }

    public void render(float deltaTime) {
        // draw the screen
//        renderer.render(deltaTime);

        timer += deltaTime;
        
        /* TRUE = PLAYER ONE
         * FALSE = PLAYER TWO
         * if the timer hits 1 minute
         * check what turn it is
         * draws for the player then re-sets the timer and changes the turn
         */
        if (timer >= (60)) {
            if (turnNew.getTurnValue() == true) {
                if(playerTwoHand.handSize()<5){
                    playerTwoHand.draw();
                }
                drawn2 = playerTwoHand.cardDrawn();
                System.out.println("switched to player two");
                playerTwoHUD.addOneP2();
                timer = 0;
                turnNew.changeTurn();
                

            } else if (turnNew.getTurnValue() == false) {
                if(playerOneHand.handSize()<5){
                    playerOneHand.draw();
                }
                drawn1 = playerOneHand.cardDrawn();
                System.out.println(playerOneHand.currentHandSize());
                System.out.println("switched to player one");
                playerOneHUD.addOneP1();
                timer = 0;
                turnNew.changeTurn();

            }
            /* when it is player ones turn and the player hits 1 it starts player ones turn by
             * drawing for player two and getting that drawn card
             * changes the turn value to switch the current turn
             * re-setting the timer
             */
            
        }
        if (turnNew.getTurnValue() == false && Gdx.input.isKeyJustPressed(Keys.Q)) {
                System.out.println("player two ended turn");
                if(playerOneHand.handSize()<5){
                    playerOneHand.draw();
                }
                drawn1 = playerOneHand.cardDrawn();
                playerOneHUD.addOneP1();
                System.out.println("added one p1");
                turnNew.changeTurn();
                timer = 0;
            }
            /* when it is player twos turn and the player hits 1 it starts player ones turn by
             * drawing for player one and getting that drawn card
             * changes the turn value
             * re-setting the timer
             */
            if (turnNew.getTurnValue() == true && Gdx.input.isKeyJustPressed(Keys.E)) {
                if(playerTwoHand.handSize()<5){
                    playerTwoHand.draw();
                    
                }
                drawn2 = playerTwoHand.cardDrawn();
                System.out.println("player one ended turn");
                playerTwoHUD.addOneP2();
                System.out.println("added one p2");
                turnNew.changeTurn();
                timer = 0;
            }
            
            if(Gdx.input.isTouched()){
                Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                renderer.guiConvert(click);
//                System.out.println("x: " + click.x + "  Y: " + click.y);
            }
            
            if(Gdx.input.isTouched()){
                Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                renderer.guiConvert(click);;
            }
            
            if(Gdx.input.isTouched()){
                Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                renderer.camConvert(click);
//                System.out.println("x: " + click.x + "  Y: " + click.y);
            }
            
            
            
        playerOneHand.update(deltaTime);
        playerTwoHand.update(deltaTime);
        renderer.render(deltaTime);
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
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        renderer.zoom(amount);
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
    
}
