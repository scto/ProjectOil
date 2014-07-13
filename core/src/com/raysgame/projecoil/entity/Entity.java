package com.raysgame.projecoil.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Texture texture;
	protected Vector2 pos, direction;
	protected Sprite sprite;
	protected Rectangle bound;
	
    public Entity(Texture texture, Vector2 pos, Vector2 direction) {
    	this.texture = texture;
    	this.pos = pos;
    	this.direction = direction; 
    	this.sprite = new Sprite(this.texture);
    	this.sprite.flip(false, true);
    	this.bound = new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }
    
    public abstract void update();
    
    public void render(SpriteBatch spriteBatch) { 
    	spriteBatch.draw(sprite, pos.x, pos.y);
    }
    
    public Rectangle getBound() {
    	return bound;
    }
    
    public Vector2 getPosition() {
    	return pos;
    }
    //設定方向
    public void setDirection(float x, float y) {
    	direction.scl(Gdx.graphics.getDeltaTime());    //取得螢幕更新率
    	//System.out.println("GDX Graphics DeltaTime: " +Gdx.graphics.getDeltaTime());    //for test
    	direction.set(x, y);
    }
    
    //設定方向
    public void setDirection2(float x, float y) {
    	pos.x = x;
    	pos.y = y;
    }
    
}
