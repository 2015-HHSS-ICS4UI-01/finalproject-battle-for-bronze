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
    private Texture attkNum;
    private Texture defNum;
    private Texture frcNum;
    private Texture picture;
    private BitmapFont font;
    
    private Deck1 deckOne;
    private Deck2 deckTwo;
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
        hand = new Player1Hand();
        hand2 = new Player2Hand();
        hand.draw();
        hand.draw();
        hand2.draw();
        
        
        TiledMapTileLayer path = (TiledMapTileLayer)map.getLayers().get("path");
        TiledMapTileLayer base = (TiledMapTileLayer)map.getLayers().get("base");
        TiledMapTileLayer powerUp = (TiledMapTileLayer)map.getLayers().get("base power ups");
        TiledMapTileLayer megaPowerUp = (TiledMapTileLayer)map.getLayers().get("mega power up");
        card = new Texture("Card.png");
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        
        
            getCard = hand.getCard(1);
            name = getCard.getName();
            attk = getCard.getAttack();
            cost = getCard.getCost();
            frc = getCard.getForce();
            dfns = getCard.getDefense();

            if(attk == 1){
                attkNum = new Texture("Numbers/Attack/A1.png");
            }
            else if(attk == 2){
                attkNum = new Texture("Numbers/Attack/A2.png");
            }
            else if(attk == 3){
                attkNum = new Texture("Numbers/Attack/A3.png");
            }
            else if(attk == 4){
                attkNum = new Texture("Numbers/Attack/A4.png");
            }
            else if(attk == 5){
                attkNum = new Texture("Numbers/Attack/A5.png");
            }
            else if(attk == 6){
                attkNum = new Texture("Numbers/Attack/A6.png");
            }
            else if(attk == 7){
                attkNum = new Texture("Numbers/Attack/A7.png");
            }
            else if(attk == 8){
                attkNum = new Texture("Numbers/Attack/A8.png");
            }
            else if(attk == 9){
                attkNum = new Texture("Numbers/Attack/A9.png");
            }
            
            
            
            if(dfns == 1){
                defNum = new Texture("Numbers/Defence/D1.png");
            }
            else if(dfns == 2){
                defNum = new Texture("Numbers/Defence/D2.png");
            }
            else if(dfns == 3){
                defNum = new Texture("Numbers/Defence/D3.png");
            }
            else if(dfns == 4){
                defNum = new Texture("Numbers/Defence/D4.png");
            }
            else if(dfns == 5){
                defNum = new Texture("Numbers/Defence/D5.png");
            }
            else if(dfns == 6){
                defNum = new Texture("Numbers/Defence/D6.png");
            }
            else if(dfns == 7){
                defNum = new Texture("Numbers/Defence/D7.png");
            }
            else if(dfns == 8){
                defNum = new Texture("Numbers/Defence/D8.png");
            }
            else if(dfns == 9){
                defNum = new Texture("Numbers/Defence/D9.png");
            }
            
            
            if(frc == 1){
                frcNum = new Texture("Numbers/Force/F1.png");
            }
            else if(frc == 2){
                frcNum = new Texture("Numbers/Force/F2.png");
            }
            else if(frc == 3){
                frcNum = new Texture("Numbers/Force/F3.png");
            }
            else if(frc == 4){
                frcNum = new Texture("Numbers/Force/F4.png");
            }
            else if(frc == 5){
                frcNum = new Texture("Numbers/Force/F5.png");
            }
            else if(frc == 6){
                frcNum = new Texture("Numbers/Force/F6.png");
            }
            else if(frc == 7){
                frcNum = new Texture("Numbers/Force/F7.png");
            }
            else if(frc == 8){
                frcNum = new Texture("Numbers/Force/F8.png");
            }
            else if(frc == 9){
                frcNum = new Texture("Numbers/Force/F9.png");
            }
            
            
            
        
        
        
        
        
        

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

        //for(Card b: Player1Hand.getCards()){
            batch.draw(card, 725, 250, 90, 140);
            batch.draw(attkNum, 725, 250, 90, 140);
            batch.draw(defNum, 725, 250, 90, 140);
            batch.draw(frcNum, 725, 250, 90, 140);
//            batch.draw(picture, 740, 305, 60, 60);
            font.draw(batch, name, 740, 380);
            font.draw(batch, "" + cost, 770, 320);
        //}

        


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

