package com.raysgame.projecoil.entity;

 import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2; 
import com.raysgame.projecoil.TextureManager;

public class Player extends Entity{
    public int speed = 6;
    
	public Player(Vector2 pos, Vector2 direction) {
		super(TextureManager.textureAirPlane, pos, direction);
	}

	@Override
	public void update() {
		//pos.add(direction);    //似乎是移動用的
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
