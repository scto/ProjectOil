package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	public static Texture textureBackground;    //圖片檔本身
	public static Sprite spriteBackgound;    //Game Object
    public static void load() {
    	textureBackground = new Texture(Gdx.files.internal("menu/back1.png"));    //設定textureBackground路徑
		textureBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);     //我猜是拉申用的
		spriteBackgound = new Sprite(textureBackground);
		spriteBackgound.flip(false, true);
    }
}
