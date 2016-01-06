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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 *
 * @author Leo Yao
 */
public class WorldRenderer {

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
        TiledMapTileLayer path = (TiledMapTileLayer)map.getLayers().get("path");
        TiledMapTileLayer base = (TiledMapTileLayer)map.getLayers().get("base");
        TiledMapTileLayer powerUp = (TiledMapTileLayer)map.getLayers().get("base power ups");
        TiledMapTileLayer megaPowerUp = (TiledMapTileLayer)map.getLayers().get("mega power up");

        camera = new OrthographicCamera();
        viewport = new FitViewport(V_WIDTH * 0.5f, V_HEIGHT * 0.5f, camera);
        batch = new SpriteBatch();
        render = new OrthogonalTiledMapRenderer(map, batch);
        // move the x position of the camera
        camera.position.x = 432 / 2;
        // move the y position of the camera
        camera.position.y = 0 + (592 / 4);
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

    public void zoom(int scale) {
        if (scale == 1) {
            camera.zoom *= 1.1f;
        } else if (scale == -1) {
            camera.zoom *= 0.9;
        }
    }
}
