package com.raysgame.projecoil.entity;

 import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2; 
import com.raysgame.projecoil.SoundManager;
import com.raysgame.projecoil.TextureManager;

public class Player extends Entity{
    public int speed = 6;
    private EntityManager entityManager;
    private long lastFire;
    
	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
		super(TextureManager.textureAirPlane, pos, direction);
		this.entityManager = entityManager;
	}

	@Override
	public void update() {
		//pos.add(direction);    //似乎是移動用的
		if (entityManager.playerIsDead()) {
			return;
		}
		//移動判斷
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			pos.x -= speed;	
		} 
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			pos.x += speed;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			pos.y -= speed;
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			pos.y += speed;
		} 
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (System.currentTimeMillis() - lastFire > 250) {
				SoundManager.shoot.play();
				entityManager.addEntity(new Bullet(pos.cpy().add((TextureManager.textureAirPlane.getWidth()), (TextureManager.textureAirPlane.getHeight()/2))));
				lastFire = System.currentTimeMillis();
			}
		}
		
		//變速
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			this.speed = 3;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			this.speed = 6;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_3)) {
			this.speed = 9;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_4)) {
			this.speed = 12;
		}
	}

}
