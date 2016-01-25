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
    public static final Music GAME_MUSIC = Gdx.audio.newMusic(Gdx.files.internal("Bronze5.mp3"));
    
    public void play(){
        soundTrack = GAME_MUSIC;
        soundTrack.setLooping(true);
        soundTrack.play();
    }
    
}
