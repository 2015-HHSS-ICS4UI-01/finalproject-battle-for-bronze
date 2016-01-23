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
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.battleforbronze.game.Model.Card;
import com.battleforbronze.game.Model.Deck1;
import com.battleforbronze.game.Model.Deck2;
import com.battleforbronze.game.Model.Deck3;
import com.battleforbronze.game.Model.HUD;
import com.battleforbronze.game.Model.Minion;
import com.battleforbronze.game.Model.OnField;
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
    private boolean cardSelected;
    private TiledMap map;
    private Texture mana;
    private int p1cMana;
    private int p2cMana;
    private Texture border;
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
    private Card playCard;
    private Texture picture;
    private Texture minion;
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
    private int mapWidth;
    private int mapHeight;
    private Cell clicked;
    private Cell afterClick;
    private Vector3 click;
    private TiledMapTileLayer path;
    private TiledMapTileLayer base; 
    private TiledMapTileSet gameSet;
    private int cardSelect;
    private HUD playerOneHUD;
    private HUD playerTwoHUD;
    private HUD checkTurn;
    private Texture buttonNotPressed;
    private Texture buttonPressed;
    private boolean lockin;
    private Cell checkCell;
    private Cell placeTile;
    private Minion p1Played;
    private Minion p2Played;
    private Array<OnField> p1OnField;
    private Array<OnField> p2OnField;
    public WorldRenderer(Player1Hand h, Player2Hand h2,HUD p1HUD, HUD p2HUD, HUD turnNew) {
        
        p1OnField = new Array<OnField>();
        p2OnField = new Array<OnField>();
        playerOneHUD = p1HUD;
        playerTwoHUD = p2HUD;
        checkTurn = turnNew;
        cardSelected = false;
        playCard = new Card();
        border = new Texture("border.png");
        map = new TmxMapLoader().load("map.tmx");
        buttonNotPressed = new Texture("button_notpressed.png");
        buttonPressed = new Texture("button_pressed.png");
        mana = new Texture("mana.png");
        clicked = new Cell();
        afterClick = new Cell();
        checkCell = new Cell();
        placeTile = new Cell();
        deckOne = new Deck1();
        deckTwo = new Deck2();
        click = new Vector3();
        deckThree = new Deck3();
        hand = h;
        hand2 = h2;
        gameSet = map.getTileSets().getTileSet("tiles");
        path = (TiledMapTileLayer) map.getLayers().get("path");
        base = (TiledMapTileLayer) map.getLayers().get("base");
        TiledMapTileLayer powerUp = (TiledMapTileLayer) map.getLayers().get("base power ups");
        TiledMapTileLayer megaPowerUp = (TiledMapTileLayer) map.getLayers().get("mega power up");
        card = new Texture("Card.png");
        font = new BitmapFont();
        int mapWidth = map.getProperties().get("width", Integer.class);
        int mapHeight = map.getProperties().get("height", Integer.class);
        
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
        guiCam.position.x = V_WIDTH / 2;
        // move the y position of the camera
        camera.position.y = 0 + (592 / 4);
        guiCam.position.y = V_HEIGHT / 2;
        // update the camera
        camera.update();

        // loads in the images
        //AssetManager.load();
    }

    public void render(float delta) {
        // clear the screen with black
        Gdx.gl20.glClearColor(0, 2, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if(Gdx.input.isTouched()){
                Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(click);
                clicked = path.getCell((int)(click.x/(PPU-1)), (int)(click.y/(PPU-1)));
                if(clicked != null){
                    clicked.setTile(gameSet.getTile(188));
                }
        }
        //gggg
        // update the camera

        if (Gdx.input.isKeyPressed(Keys.A)) {
            if (camera.position.x >= 100) {
                camera.position.x = camera.position.x - 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            if (camera.position.x <= 300) {
                camera.position.x = camera.position.x + 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            if (camera.position.y <= 500) {
                camera.position.y = camera.position.y + 5;
            }
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            if (camera.position.y >= 100) {
                camera.position.y = camera.position.y - 5;
            }
        }

        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            if (hand.canDraw()) {
                if (hand.currentHandSize() < 5) {
                    
                    hand.draw();
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.SHIFT_LEFT)) {
            if (hand.currentHandSize() > 0) {
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
        int cards2 = 0;
        
        for (Card c : hand.getCards()) {
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
            if (attk == 1) {
                attkNumFinal = attkNum1;
            }
            if (attk == 2) {
                attkNumFinal = attkNum2;
            }
            if (attk == 3) {
                attkNumFinal = attkNum3;
            }
            if (attk == 4) {
                attkNumFinal = attkNum4;
            }
            if (attk == 5) {
                attkNumFinal = attkNum5;
            }
            if (attk == 6) {
                attkNumFinal = attkNum6;
            }
            if (attk == 7) {
                attkNumFinal = attkNum7;
            }
            if (attk == 8) {
                attkNumFinal = attkNum8;
            }
            if (attk == 9) {
                attkNumFinal = attkNum9;
            }

            if (dfns == 1) {
                defNumFinal = defNum1;
            }
            if (dfns == 2) {
                defNumFinal = defNum2;
            }
            if (dfns == 3) {
                defNumFinal = defNum3;
            }
            if (dfns == 4) {
                defNumFinal = defNum4;
            }
            if (dfns == 5) {
                defNumFinal = defNum5;
            }
            if (dfns == 6) {
                defNumFinal = defNum6;
            }
            if (dfns == 7) {
                defNumFinal = defNum7;
            }
            if (dfns == 8) {
                defNumFinal = defNum8;
            }
            if (dfns == 9) {
                defNumFinal = defNum9;
            }

            if (frc == 1) {
                frcNumFinal = frcNum1;
            }
            if (frc == 2) {
                frcNumFinal = frcNum2;
            }
            if (frc == 3) {
                frcNumFinal = frcNum3;
            }
            if (frc == 4) {
                frcNumFinal = frcNum4;
            }
            if (frc == 5) {
                frcNumFinal = frcNum5;
            }
            if (frc == 6) {
                frcNumFinal = frcNum6;
            }
            if (frc == 7) {
                frcNumFinal = frcNum7;
            }
            if (frc == 8) {
                frcNumFinal = frcNum8;
            }
            if (frc == 9) {
                frcNumFinal = frcNum9;
            }


            batch.draw(card, 810 - cards * 80, 230, 80, 120);
             batch.draw(attkNumFinal, 810 - cards * 80, 230, 80, 120);
             batch.draw(defNumFinal, 810 - cards * 80, 230, 80, 120);
             batch.draw(frcNumFinal, 810 - cards * 80, 230, 80, 120);
            
//            batch.draw(picture, 740, 305, 60, 60);
            font.draw(batch, name, 820 - cards * 80, 343);
             font.draw(batch, "" + cost, 850 - cards * 80, 290);
            cards++;
        }
        
        for (Card b : hand2.getCards()) {
            attk = b.getAttack();
            dfns = b.getDefense();
            frc = b.getForce();
            name = b.getName();
            cost = b.getCost();
//            name = getCard.getName();
//            attk = getCard.getAttack();
//            cost = getCard.getCost();
//            frc = getCard.getForce();
//            dfns = getCard.getDefense();
            if (attk == 1) {
                attkNumFinal = attkNum1;
            }
            if (attk == 2) {
                attkNumFinal = attkNum2;
            }
            if (attk == 3) {
                attkNumFinal = attkNum3;
            }
            if (attk == 4) {
                attkNumFinal = attkNum4;
            }
            if (attk == 5) {
                attkNumFinal = attkNum5;
            }
            if (attk == 6) {
                attkNumFinal = attkNum6;
            }
            if (attk == 7) {
                attkNumFinal = attkNum7;
            }
            if (attk == 8) {
                attkNumFinal = attkNum8;
            }
            if (attk == 9) {
                attkNumFinal = attkNum9;
            }

            if (dfns == 1) {
                defNumFinal = defNum1;
            }
            if (dfns == 2) {
                defNumFinal = defNum2;
            }
            if (dfns == 3) {
                defNumFinal = defNum3;
            }
            if (dfns == 4) {
                defNumFinal = defNum4;
            }
            if (dfns == 5) {
                defNumFinal = defNum5;
            }
            if (dfns == 6) {
                defNumFinal = defNum6;
            }
            if (dfns == 7) {
                defNumFinal = defNum7;
            }
            if (dfns == 8) {
                defNumFinal = defNum8;
            }
            if (dfns == 9) {
                defNumFinal = defNum9;
            }

            if (frc == 1) {
                frcNumFinal = frcNum1;
            }
            if (frc == 2) {
                frcNumFinal = frcNum2;
            }
            if (frc == 3) {
                frcNumFinal = frcNum3;
            }
            if (frc == 4) {
                frcNumFinal = frcNum4;
            }
            if (frc == 5) {
                frcNumFinal = frcNum5;
            }
            if (frc == 6) {
                frcNumFinal = frcNum6;
            }
            if (frc == 7) {
                frcNumFinal = frcNum7;
            }
            if (frc == 8) {
                frcNumFinal = frcNum8;
            }
            if (frc == 9) {
                frcNumFinal = frcNum9;
            }

            batch.draw(card, 310 + cards2 * 80, 550, 80, 120);
             batch.draw(attkNumFinal, 310 + cards2 * 80, 550, 80, 120);
             batch.draw(defNumFinal, 310 + cards2 * 80, 550, 80, 120);
             batch.draw(frcNumFinal, 310 + cards2 * 80, 550, 80, 120);
//            batch.draw(picture, 740, 305, 60, 60);
            font.draw(batch, name, 320 + cards2 * 80, 663);
             font.draw(batch, "" + cost, 360 + cards2 * 80, 610);
            cards2++;
        }
              
             if(Gdx.input.isTouched()){
                 Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                 guiCam.unproject(click);
                 //System.out.println("x: " + click.x + "  Y: " + click.y);
                 if(click.x>810 && click.x<890 && click.y>230 && click.y<350 && hand.handSize()>=1){
                     cardSelect = 1;
                     playCard = hand.getCard(0);
                     cardSelected = true;
                 }
                 if(click.x>730 && click.x<810 && click.y>230 && click.y<350 && hand.handSize()>=2){
                     cardSelect = 2;
                     playCard = hand.getCard(1);
                     cardSelected = true;
                 }
                 if(click.x>650 && click.x<730 && click.y>230 && click.y<350 && hand.handSize()>=3){
                     cardSelect = 3;
                     playCard = hand.getCard(2);
                     cardSelected = true;
                 }
                 if(click.x>570 && click.x<650 && click.y>230 && click.y<350 && hand.handSize()>=4){
                     cardSelect = 4;
                     playCard = hand.getCard(3);
                     cardSelected = true;
                 }
                 if(click.x>490 && click.x<570 && click.y>230 && click.y<350 && hand.handSize()>=5){
                     cardSelect = 5;
                     playCard = hand.getCard(4);
                     cardSelected = true;
                 }
                 
                 
                 
                 
                 if(click.x>310 && click.x<390 && click.y>550 && click.y<670 && hand2.handSize()>=1){
                     cardSelect = 6;
                     playCard = hand.getCard(5);
                     cardSelected = true;
                 }
                 if(click.x>390 && click.x<470 && click.y>550 && click.y<670 && hand2.handSize()>=2){
                     cardSelect = 7;
                     playCard = hand.getCard(6);
                     cardSelected = true;
                 }
                 if(click.x>470 && click.x<550 && click.y>550 && click.y<670 && hand2.handSize()>=3){
                     cardSelect = 8;
                     playCard = hand.getCard(7);
                     cardSelected = true;
                 }
                 if(click.x>550 && click.x<630 && click.y>550 && click.y<670 && hand2.handSize()>=4){
                     cardSelect = 9;
                     playCard = hand.getCard(8);
                     cardSelected = true;
                 }
                 if(click.x>630 && click.x<710 && click.y>550 && click.y<670 && hand2.handSize()>=5){
                     cardSelect = 10;
                     playCard = hand.getCard(9);
                     cardSelected = true;
                 }
//                 if(click.x>325 && click.x<405 && click.y>400 && click.y<480){
//                     lockin = true;
//                     cardSelected = true;
//                 }
                 
                
             }
             
         
                      
         if(cardSelect == 1){
             
              batch.draw(border, 803, 225, 94, 133);
         }
         else if(cardSelect == 2){

              batch.draw(border, 723, 225, 94, 133);
         }
         else if(cardSelect == 3){
         
              batch.draw(border, 643, 225, 94, 133);
         }
         else if(cardSelect == 4){
           
              batch.draw(border, 563, 225, 94, 133);
         }
         else if(cardSelect == 5){
            
              batch.draw(border, 483, 225, 94, 133);
         }
       
         if(cardSelect == 6){
             batch.draw(border, 303, 545, 94, 133);
         }
         else if(cardSelect == 7){
             batch.draw(border, 383, 545, 94, 133);
         }
         else if(cardSelect == 8){
             batch.draw(border, 463, 545, 94, 133);
         }
         else if(cardSelect == 9){
             batch.draw(border, 543, 545, 94, 133);
         }
         else if(cardSelect == 10){
             batch.draw(border, 623, 545, 94, 133);
         }
         
         
        
         
        
         for(int i = 0; i < playerOneHUD.getTurnNumberP1(); i++){
            if (playerOneHUD.getTurnNumberP1() < 10){
            batch.draw(mana, 310+15*i, 230, 20,20);
            } else {
                for (int j = 0; j < 10; j++) {
                    batch.draw(mana, 310+15*j, 230, 20,20);
                }
            }
         }
         
         for(int i = 0; i < playerTwoHUD.getTurnNumberP2(); i++){
            if (playerTwoHUD.getTurnNumberP2() < 10){
            batch.draw(mana, 870-15*i, 645, 20,20);
            } else {
                for (int j = 0; j < 10; j++) {
                    batch.draw(mana, 870-15*i, 645, 20,20);
                }
                
            }
            
         }
         if (playerOneHUD.getTurnValue() == true){
         if (Gdx.input.isKeyJustPressed(Keys.ENTER) && cardSelected == true){
                batch.draw(buttonPressed,325,400,80,80);
                if(playCard.getCost()<=playerOneHUD.getTurnNumberP1()){
                    hand.played(cardSelect-1);
                    cardSelected = false;
                    cardSelect = 0;
                    checkCell = path.getCell(13, 2);
                    checkCell.setTile(gameSet.getTile(186));
                   //14,3 p1 first spot
                }
          }
         }
         if (playerOneHUD.getTurnValue() == false){
         if (Gdx.input.isKeyJustPressed(Keys.ENTER) && cardSelected == true){
                batch.draw(buttonPressed,325,400,80,80);
                if(playCard.getCost()<=playerOneHUD.getTurnNumberP1()){
                    hand.played(cardSelect-1);
                    cardSelected = false;
                    cardSelect = 0;
                    checkCell = path.getCell(13, 34);
                    checkCell.setTile(gameSet.getTile(187));
                   //14,3 p1 first spot
                }
          }
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
            if (camera.zoom >= 1.6) {
            } else {
                camera.zoom *= 1.1f;
            }
        } else if (scale == -1) {
            if (camera.zoom <= .6) {
            } else {
                camera.zoom *= 0.9;
            }
        }
    }
    
    public void guiConvert(Vector3 v){
        guiCam.unproject(v);
    }
    
    public void camConvert(Vector3 v){
        camera.unproject(v);
    }
    

}
