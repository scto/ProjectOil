package com.raysgame.projecoil.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.TextureManager;

public class EntityManager {
    //控制畫面上的實體
	private final Array<Entity> entities = new Array<Entity>();
	private Player player;
	
	public EntityManager(int amount) {
		player = new Player(new Vector2(960 - 64, 540), new Vector2(0, 0), this);
		for (int i=0; i<amount; i++) {
			//為了讓怪物符合上下螢幕出現
			float y = MathUtils.random(0, ProjectOil.CAMERA_HEIGHT - TextureManager.enemy1.getHeight());
			//為了讓怪物出現在螢幕後面
			float x = MathUtils.random(ProjectOil.CAMERA_WIDTH+(ProjectOil.CAMERA_WIDTH/2) , ProjectOil.CAMERA_HEIGHT * 3);
			float speed = MathUtils.random(2, 6);
			addEntity(new Enemy1(new Vector2(x, y), new Vector2(-speed, 0)));    //向左移動
		}
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
		player.update();
	}
	
	public void render(SpriteBatch batch) {
		for (Entity e : entities) {
			if (e instanceof Bullet) {
			    e.renderAnimation(batch);	
			}
			else {
				e.render(batch);	
			}
		}
		player.render(batch);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private Array<Enemy1> getEnemies() {
		Array<Enemy1> ret = new Array<Enemy1>();
		for (Entity e : entities) {
			if (e instanceof Enemy1) {
				ret.add((Enemy1)e);
			}
		}
		return ret;
	}
	
	public boolean gameOver() {
		return getEnemies().size <= 0;
	}
}
