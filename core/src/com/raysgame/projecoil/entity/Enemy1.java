package com.raysgame.projecoil.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.TextureManager;

public class Enemy1 extends Entity{
	
	public static int score = 20;
	Player player;
	EntityManager entityManager;
	private long lastFire;
	private boolean cooldown = true;

	public Enemy1(Vector2 pos, Vector2 direction, Player player, EntityManager entityManager) {
		super(TextureManager.enemy1, pos, direction);
		this.player = player;
		this.entityManager = entityManager;
	}

	@Override
	public void update() {
		pos.add(direction);
		//簡單的AI
		/*
		if (player.getPosition().x > pos.x) {
			pos.x++;
		}
		else {
			pos.x--;
		}
		if (player.getPosition().y > pos.y) {
			pos.y++;
		}
		else {
			pos.y--;
		}*/
		//發出子彈
		if (!cooldown) {
			int time = MathUtils.random(4000, 10000);
			if (System.currentTimeMillis() - lastFire > time) {
				//SoundManager.shoot.play();
				int speed = MathUtils.random(10, 30);
			    float y_diff = player.getBoundPerFrame().y - pos.y;
			    int y_shift = 0;
				//System.out.println("Position temp: " +(player.getBoundPerFrame().y - pos.y));
			    if (y_diff > 100) {
			    	y_shift = 2;
			    }
			    else if (y_diff > 200) {
			    	y_shift = 3;
			    }
			    else if (y_diff >400) {
			    	y_shift = 5;
			    }
			    else if (y_diff > 600) {
			    	y_shift = 9;
			    }
			    else if (y_diff > 700) {
					y_shift = 11;
				}
			    else if (y_diff <= -50) {
					y_shift = -1;
				}
			    else if (y_diff <= -100) {
					y_shift = -2;
				}
			    else if (y_diff <= -200) {
					y_shift = -3;
				}
			    else if (y_diff <= -400) {
			    	y_shift = -5;
			    }
			    else if (y_diff <= -600) {
			    	y_shift = -9;
			    }
			    else if (y_diff <= -700) {
					y_shift = -11;
				}
				entityManager.addEntity(new EnemyBullets(pos.cpy().add(0, (TextureManager.enemy1.getHeight()/2)), new Vector2(-speed, y_shift)));
				lastFire = System.currentTimeMillis();
			}
		}
		else {
			if (pos.x < ProjectOil.CAMERA_WIDTH - TextureManager.enemy1.getWidth()) {
				cooldown = false;
			}
		}
	    
		
		//將移動到後方的敵人重新出現在玩家前方
		if (pos.x < -TextureManager.enemy1.getWidth()) {
			float y = MathUtils.random(0, ProjectOil.CAMERA_HEIGHT - TextureManager.enemy1.getHeight());
			float speed = MathUtils.random(2, 6);
			pos.set(ProjectOil.CAMERA_WIDTH, y);
			direction.set(-speed, 0);
		}
	}
	
	public void collision() {
		
	}

}
