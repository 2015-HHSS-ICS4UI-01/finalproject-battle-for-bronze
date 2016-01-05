/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.battleforbronze.game.Screens.WorldRenderer;

/**
 *
 * @author Leo Yao
 */
public class MainGame implements Screen, InputProcessor{
    
    //private TiledMap map;
//    private OrthogonalTiledMapRenderer render;
    //private OrthographicCamera camera;
    private WorldRenderer renderer;
    public MainGame() {
        
        //map = new TiledMap();
        renderer = new WorldRenderer();
        Gdx.input.setInputProcessor(this);
    }
    
    @Override
    public void show(){
        
        
    }
    
    public void render(float deltaTime){
        // draw the screen
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
        System.out.println(amount);
        renderer.zoom(amount);
        return false;
    }
}
