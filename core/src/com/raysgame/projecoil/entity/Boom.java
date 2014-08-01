package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.TextureManager;

public class Boom extends Entity{

	public Boom(Vector2 pos) {
		super(TextureManager.boom, 4, 2, 180, 120, pos, new Vector2(0, 0));
	}

	@Override
	public void update() {
		pos.add(direction);
	}
	
	

}
