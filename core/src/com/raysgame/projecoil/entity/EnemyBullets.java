package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.TextureManager;

public class EnemyBullets extends Entity{

	public EnemyBullets(Vector2 pos, Vector2 direction) {
		super(TextureManager.enemyBullets, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
	}
	
	public boolean checkEnd() {
		if (pos.x <= 0 || pos.y <= 0 || pos.y >= ProjectOil.CAMERA_HEIGHT) {
			return true;
		}
		return false;
	}

}
