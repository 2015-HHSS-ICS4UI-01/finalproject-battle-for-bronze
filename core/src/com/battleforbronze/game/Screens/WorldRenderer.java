/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.battleforbronze.game.Main.MainGame;
import com.battleforbronze.game.Model.Card;
import com.battleforbronze.game.Model.Deck1;
import com.battleforbronze.game.Model.Deck2;
import com.battleforbronze.game.Model.Deck3;
import com.battleforbronze.game.Model.Player1Hand;
import com.battleforbronze.game.Model.Player2Hand;

/**
 *
 * @author Leo Yao
 */
public class WorldRenderer {

    public final float PPU = 16;
    public final int V_WIDTH = 1200;
    public final int V_HEIGHT = 900;
    private Viewport viewport;
    private Viewport guiViewport;
    private OrthographicCamera camera;
    private OrthographicCamera guiCam;
    private SpriteBatch batch;
    private OrthogonalTiledMapRenderer render;
    private TiledMap map;
    private Texture card;
    private Texture attkNum1;
    private Texture attkNum2;
    private Texture attkNum3;
    private Texture attkNum4;
    private Texture attkNum5;
    private Texture attkNum6;
    private Texture attkNum7;
    private Texture attkNum8;
    private Texture attkNum9;
    
    private Texture defNum1;
    private Texture defNum2;
    private Texture defNum3;
    private Texture defNum4;
    private Texture defNum5;
    private Texture defNum6;
    private Texture defNum7;
    private Texture defNum8;
    private Texture defNum9;
    
    private Texture frcNum1;
    private Texture frcNum2;
    private Texture frcNum3;
    private Texture frcNum4;
    private Texture frcNum5;
    private Texture frcNum6;
    private Texture frcNum7;
    private Texture frcNum8;
    private Texture frcNum9;
    
    private Texture attkNumFinal;
    private Texture defNumFinal;
    private Texture frcNumFinal;
    
    private Texture picture;
    private BitmapFont font;
    
    private Deck1 deckOne;
    private Deck2 deckTwo;
    private Deck3 deckThree;
    private Player1Hand hand;
    private Player2Hand hand2;
    private Card getCard;
    private int attk;
    private int cost;
    private int frc;
    private int dfns;
    private String name;


    public WorldRenderer(/*World w*/) {

        map = new TmxMapLoader().load("map.tmx");
        
        deckOne = new Deck1();
        deckTwo = new Deck2();
        deckThree = new Deck3();
        hand = new Player1Hand();
        hand2 = new Player2Hand();
        hand.draw();
//        hand.draw();
//        hand.draw();
        hand2.draw();
        
        
        TiledMapTileLayer path = (TiledMapTileLayer)map.getLayers().get("path");
        TiledMapTileLayer base = (TiledMapTileLayer)map.getLayers().get("base");
        TiledMapTileLayer powerUp = (TiledMapTileLayer)map.getLayers().get("base power ups");
        TiledMapTileLayer megaPowerUp = (TiledMapTileLayer)map.getLayers().get("mega power up");
        card = new Texture("Card.png");
        font = new BitmapFont();
        
        attkNum1 = new Texture("Numbers/Attack/A1.png");
        attkNum2 = new Texture("Numbers/Attack/A2.png");
        attkNum3 = new Texture("Numbers/Attack/A3.png");
        attkNum4 = new Texture("Numbers/Attack/A4.png");
        attkNum5 = new Texture("Numbers/Attack/A5.png");
        attkNum6 = new Texture("Numbers/Attack/A6.png");
        attkNum7 = new Texture("Numbers/Attack/A7.png");
        attkNum8 = new Texture("Numbers/Attack/A8.png");
        attkNum9 = new Texture("Numbers/Attack/A9.png");

        defNum1 = new Texture("Numbers/Defence/D1.png");
        defNum2 = new Texture("Numbers/Defence/D2.png");
        defNum3 = new Texture("Numbers/Defence/D3.png");
        defNum4 = new Texture("Numbers/Defence/D4.png");
        defNum5 = new Texture("Numbers/Defence/D5.png");
        defNum6 = new Texture("Numbers/Defence/D6.png");
        defNum7 = new Texture("Numbers/Defence/D7.png");
        defNum8 = new Texture("Numbers/Defence/D8.png");
        defNum9 = new Texture("Numbers/Defence/D9.png");

        frcNum1 = new Texture("Numbers/Force/F1.png");
        frcNum2 = new Texture("Numbers/Force/F2.png");
        frcNum3 = new Texture("Numbers/Force/F3.png");
        frcNum4 = new Texture("Numbers/Force/F4.png");
        frcNum5 = new Texture("Numbers/Force/F5.png");
        frcNum6 = new Texture("Numbers/Force/F6.png");
        frcNum7 = new Texture("Numbers/Force/F7.png");
        frcNum8 = new Texture("Numbers/Force/F8.png");
        frcNum9 = new Texture("Numbers/Force/F9.png");
        
        font.setColor(Color.BLACK);
        
        
            
            
            
            
            
        
        

//        picture = new Texture("Player1.png");
        
        camera = new OrthographicCamera();
        guiCam = new OrthographicCamera();
        viewport = new FitViewport(V_WIDTH * 0.5f, V_HEIGHT * 0.5f, camera);
        guiViewport = new FitViewport(V_WIDTH * 0.5f, V_HEIGHT * 0.5f, guiCam);
        batch = new SpriteBatch();
        render = new OrthogonalTiledMapRenderer(map, batch);
        
        // move the x position of the camera
        camera.position.x = 432 / 2;
        guiCam.position.x = V_WIDTH/2;
        // move the y position of the camera
        camera.position.y = 0 + (592 / 4);
        guiCam.position.y = V_HEIGHT/2;
        // update the camera
        camera.update();

        // loads in the images
        //AssetManager.load();
    }

    public void render(float delta) {
        // clear the screen with black
        Gdx.gl20.glClearColor(0, 2, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // update the camera

        if (Gdx.input.isKeyPressed(Keys.A)) {
            if(camera.position.x>=100){
            camera.position.x = camera.position.x - 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            if(camera.position.x<=300){
            camera.position.x = camera.position.x + 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            if(camera.position.y<=500){
            camera.position.y = camera.position.y + 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            if(camera.position.y>=100){
            camera.position.y = camera.position.y - 5;
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            if(hand.canDraw()){
                hand.draw();
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.SHIFT_LEFT)) {
            if(hand.currentHandSize()>0){
                hand.removeFromHand();
            }
        }
        
        camera.update();
        guiCam.update();
        // links the renderer to the camera
        batch.setProjectionMatrix(camera.combined);
        render.setView(camera);
        render.render();
        
        batch.setProjectionMatrix(guiCam.combined);
        // tells the renderer this is the list
        batch.begin();
        // list of things to draw

        int cards = 0;
        for(Card c: hand.getCards()){
            attk = c.getAttack();
            dfns = c.getDefense();
            frc = c.getForce();
            name = c.getName();
            cost = c.getCost();
//            name = getCard.getName();
//            attk = getCard.getAttack();
//            cost = getCard.getCost();
//            frc = getCard.getForce();
//            dfns = getCard.getDefense();
            if(attk == 1){
                attkNumFinal = attkNum1;
            }
            if(attk == 2){
                attkNumFinal = attkNum2;
            }
            if(attk == 3){
                attkNumFinal = attkNum3;
            }
            if(attk == 4){
                attkNumFinal = attkNum4;
            }
            if(attk == 5){
                attkNumFinal = attkNum5;
            }
            if(attk == 6){
                attkNumFinal = attkNum6;
            }
            if(attk == 7){
                attkNumFinal = attkNum7;
            }
            if(attk == 8){
                attkNumFinal = attkNum8;
            }
            if(attk == 9){
                attkNumFinal = attkNum9;
            }
            
            if(dfns == 1){
                defNumFinal = defNum1;
            }
            if(dfns == 2){
                defNumFinal = defNum2;
            }
            if(dfns == 3){
                defNumFinal = defNum3;
            }
            if(dfns == 4){
                defNumFinal = defNum4;
            }
            if(dfns == 5){
                defNumFinal = defNum5;
            }
            if(dfns == 6){
                defNumFinal = defNum6;
            }
            if(dfns == 7){
                defNumFinal = defNum7;
            }
            if(dfns == 8){
                defNumFinal = defNum8;
            }
            if(dfns == 9){
                defNumFinal = defNum9;
            }
            
            if(frc == 1){
                frcNumFinal = frcNum1;
            }
            if(frc == 2){
                frcNumFinal = frcNum2;
            }
            if(frc == 3){
                frcNumFinal = frcNum3;
            }
            if(frc == 4){
                frcNumFinal = frcNum4;
            }
            if(frc == 5){
                frcNumFinal = frcNum5;
            }
            if(frc == 6){
                frcNumFinal = frcNum6;
            }
            if(frc == 7){
                frcNumFinal = frcNum7;
            }
            if(frc == 8){
                frcNumFinal = frcNum8;
            }
            if(frc == 9){
                frcNumFinal = frcNum9;
            }
            
            
            batch.draw(card, 725 - cards*60, 250, 90, 140);
            batch.draw(attkNumFinal, 725 - cards*60, 250, 90, 140);
            batch.draw(defNumFinal, 725 - cards*60, 250, 90, 140);
            batch.draw(frcNumFinal, 725 - cards*60, 250, 90, 140);
//            batch.draw(picture, 740, 305, 60, 60);
            font.draw(batch, name , 740 - cards*60, 380);
            font.draw(batch, "" + cost, 770 - cards*60, 320);
            cards++;
        }

        


        // finished listing things to draw
        batch.end();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
        guiViewport.update(width, height);
    }

    public void zoom(int scale) {
        if (scale == 1) {
            if (camera.zoom >= 1.6){
                
            } else {
                camera.zoom *= 1.1f;
            }            
        } else if (scale == -1) {
            if (camera.zoom <= .6){
                
            } else {
               camera.zoom *= 0.9;
            }            
        }
    }
}

