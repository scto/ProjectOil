package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.TextureManager;

public class Enemy1 extends Entity{
	
	public static int score = 20;

	public Enemy1(Vector2 pos, Vector2 direction) {
		super(TextureManager.enemy1, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		//將移動到後方的敵人重新出現在玩家前方
		if (pos.x < -TextureManager.enemy1.getWidth()) {
			float y = MathUtils.random(0, ProjectOil.CAMERA_HEIGHT - TextureManager.enemy1.getHeight());
			float speed = MathUtils.random(2, 6);
			pos.set(ProjectOil.CAMERA_WIDTH, y);
			direction.set(-speed, 0);
		}
	}

}
