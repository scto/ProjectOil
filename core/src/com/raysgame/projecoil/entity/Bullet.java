package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.TextureManager;

public class Bullet extends Entity{

	public Bullet(Vector2 pos) {
		super(TextureManager.bulletSheet, 2, 1, 30, 8, pos, new Vector2(13, 0));
		
	}

	@Override
	public void update() {
		pos.add(direction);
	}

	public boolean checkEnd() {
		return pos.x >= ProjectOil.CAMERA_WIDTH;
	}

}
