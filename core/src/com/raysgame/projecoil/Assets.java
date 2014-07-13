package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture textureBackground;    //圖片檔本身
	public static Sprite spriteBackgound;    //Game Object
	
	public static Texture textureAirPlane;
	public static Sprite spriteAirPlane;
	
	public static Texture bulletSheet;
	public static TextureRegion[] bulletFrames;
	public static TextureRegion currentFrame;
	public static Animation loading_Animation;
	
    public static void load() {
    	textureBackground = new Texture(Gdx.files.internal("data/sky.png"));    //設定textureBackground路徑
		textureBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);     //我猜是拉申用的
		spriteBackgound = new Sprite(textureBackground);
		spriteBackgound.flip(false, true);
		
		//Picture for airplane
		textureAirPlane = new Texture(Gdx.files.internal("data/airplane_template.png"));
		spriteAirPlane = new Sprite(textureAirPlane);
		spriteAirPlane.flip(false, true);
		
		//Picture for bullets 動畫的處理
		bulletSheet = new Texture(Gdx.files.internal("data/bullets.png"));
		TextureRegion[][] temp = TextureRegion.split(bulletSheet, 30, 8);
		bulletFrames = new TextureRegion[2];
		int index = 0;
		for (int i=0; i<2; i++) {
			bulletFrames[index] = temp[i][0];
			bulletFrames[index++].flip(false, true);
		}
		loading_Animation = new Animation(0.2F, bulletFrames);
		
    }
}
