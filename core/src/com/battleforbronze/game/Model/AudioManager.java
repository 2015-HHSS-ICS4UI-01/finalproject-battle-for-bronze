/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battleforbronze.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 *
 * @author Leo Yao
 */
public class AudioManager {
    private static Music soundTrack;
    private static Music hit;
    private static Music draw;
    private static Music dlegend;
    private static Music yessir;
    public static final Music DRAW = Gdx.audio.newMusic(Gdx.files.internal("CardFlip.mp3"));
    public static final Music HIT = Gdx.audio.newMusic(Gdx.files.internal("Hit.mp3"));
    public static final Music YESSIR = Gdx.audio.newMusic(Gdx.files.internal("teemo.ogg"));
    public static final Music DLEGEND = Gdx.audio.newMusic(Gdx.files.internal("dLegend.mp3"));
    public static final Music GAME_MUSIC = Gdx.audio.newMusic(Gdx.files.internal("Bronze5.mp3"));
    
    public void play(){
        
        soundTrack = GAME_MUSIC;
        soundTrack.setLooping(true);
        soundTrack.play();
    }
    public void hit(){
        hit = HIT;
        hit.setLooping(false);
        hit.play();
    }
    
    public void draw(){
        draw = DRAW;
        draw.setLooping(false);
        draw.play();
    }
    
    public void dlegend(){
        dlegend = DLEGEND;
        dlegend.setLooping(false);
        dlegend.play();
    }
    
    public void yessir(){
        yessir = YESSIR;
        yessir.setLooping(false);
        yessir.play();
    }
    
}
