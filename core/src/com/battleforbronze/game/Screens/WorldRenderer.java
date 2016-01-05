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

/**
 *
 * @author Leo Yao
 */
public class WorldRenderer {
    
    public float Z_WIDTH = 0;
    public float Z_HEIGHT = 0;
    public final float PPU = 16;
    public final int V_WIDTH = 700;
    public final int V_HEIGHT = 700;
    private Viewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private OrthogonalTiledMapRenderer render;
    private TiledMap map;

    public WorldRenderer(/*World w*/) {

        map = new TmxMapLoader().load("map.tmx");

        camera = new OrthographicCamera();
        viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
        batch = new SpriteBatch();
        render = new OrthogonalTiledMapRenderer(map, batch);
        // move the x position of the camera
        camera.position.x = 432/2;
        // move the y position of the camera
        camera.position.y = 0+(592/4);
        // update the camera
        camera.update();

        // loads in the images
        //AssetManager.load();
    }

    public void render(float delta) {
        // clear the screen with black
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // update the camera

        
        camera.update();

        // links the renderer to the camera
        batch.setProjectionMatrix(camera.combined);

        render.setView(camera);
        render.render();

        // tells the renderer this is the list
        batch.begin();
        // list of things to draw


        // finished listing things to draw
        batch.end();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
    
    
    public void zoom(int scale){
        if(scale == 1){
            camera.zoom *= 0.8 ;
        }else if (scale == -1){
            camera.zoom *= 1.2f;
        }
    }
}
