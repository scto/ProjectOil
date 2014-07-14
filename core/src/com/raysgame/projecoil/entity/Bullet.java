package com.raysgame.projecoil.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity{

	public Bullet(Texture texture, Vector2 pos, Vector2 direction) {
		super(texture, pos, direction);
		
	}

	@Override
	public void update() {
		pos.add(direction);
	}

}
