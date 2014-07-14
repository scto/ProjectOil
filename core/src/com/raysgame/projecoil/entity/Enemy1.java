package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.TextureManager;

public class Enemy1 extends Entity{

	public Enemy1(Vector2 pos, Vector2 direction) {
		super(TextureManager.enemy1, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
	}

}
