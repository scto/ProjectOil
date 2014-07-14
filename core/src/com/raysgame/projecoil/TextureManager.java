package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	//將圖檔都放在這裡
	public static Texture textureAirPlane = new Texture(Gdx.files.internal("data/airplane_template.png"));
	public static Texture bulletSheet = new Texture(Gdx.files.internal("data/bullets.png"));
	public static Texture textureBackground = new Texture(Gdx.files.internal("data/sky.png"));
	public static Texture enemy1 = new Texture(Gdx.files.internal("data/enemy1.png"));
	
}
