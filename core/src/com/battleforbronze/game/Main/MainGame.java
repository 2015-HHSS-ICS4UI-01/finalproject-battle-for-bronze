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
import com.battleforbronze.game.Model.Card;
import com.battleforbronze.game.Model.Deck1;
import com.battleforbronze.game.Model.Deck2;
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
public class MainGame implements Screen, InputProcessor, MouseListener {

    private Player1Hand playerOneHand;
    private Player2Hand playerTwoHand;
    private Deck1 deckOne;
    private Deck2 deckTwo;
    private WorldRenderer renderer;
    private boolean turn;
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

    public MainGame() {
        pos = 0;
        turn = true;
        Timer timer = new Timer();
        deckOne = new Deck1();
        deckTwo = new Deck2();
        playerOneHand = new Player1Hand();
        playerTwoHand = new Player2Hand();
        renderer = new WorldRenderer();
        Gdx.input.setInputProcessor(this);
        playerTwoHand.shuffleDeck();
        playerOneHand.startingHand();
        playerTwoHand.startingHand();
        playerOneHand.draw();
        playerTwoHand.draw();
    }

    @Override
    public void show() {
    }

    public void render(float deltaTime) {
        // draw the screen
        renderer.render(deltaTime);

        timer += deltaTime;

        if (turn == true) {
            //code for players turns (playing cards etc....)
        } else {
            //for player 2
        }
        /* TRUE = PLAYER ONE
         * FALSE = PLAYER TWO
         * if the timer hits 1 minute
         * check what turn it is
         * draws for the player then re-sets the timer and changes the turn
         */
        if (timer >= (60)) {
            if (turn == true) {
                playerOneHand.draw();
                drawn1 = playerOneHand.cardDrawn();
                System.out.println("switched to player two");
                timer = 0;
                turn = false;

            } else if (turn == false) {
                playerTwoHand.draw();
                drawn2 = playerTwoHand.cardDrawn();
                System.out.println(playerTwoHand.currentHandSize());
                System.out.println("switched to player one");
                timer = 0;
                turn = true;

            }
            /* when it is player ones turn and the player hits 1 it starts player ones turn by
             * drawing for player two and getting that drawn card
             * changes the turn value to switch the current turn
             * re-setting the timer
             */
            if (turn == true && Gdx.input.isKeyJustPressed(Keys.NUM_2)) {
                playerTwoHand.draw();
                drawn2 = playerTwoHand.cardDrawn();
                turn = false;
                timer = 0;
            }
            /* when it is player twos turn and the player hits 1 it starts player ones turn by
             * drawing for player one and getting that drawn card
             * changes the turn value
             * re-setting the timer
             */
            if (turn == false && Gdx.input.isKeyJustPressed(Keys.NUM_1)) {
                playerOneHand.draw();
                drawn1 = playerOneHand.cardDrawn();
                turn = true;
                timer = 0;
            }
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

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
