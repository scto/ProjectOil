package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	public static Sound bgm1 = Gdx.audio.newSound(Gdx.files.internal("sound/Raging_Thunderhead.mp3"));
    public static Sound shoot = Gdx.audio.newSound(Gdx.files.internal("sound/shoot.wav"));
    public static Sound boom = Gdx.audio.newSound(Gdx.files.internal("sound/boom.ogg"));
}
