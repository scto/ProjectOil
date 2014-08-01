package com.raysgame.projecoil.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Texture texture;
	protected Vector2 pos, direction;
	protected Sprite sprite;
	protected Rectangle bound;
	
	protected TextureRegion[] sheet_frames;
	protected TextureRegion current_frame;
	protected Animation loading_animation;
	private int row, col, width, height;
	private float stateTime;
	
    public Entity(Texture texture, Vector2 pos, Vector2 direction) {
    	this.texture = texture;
    	this.pos = pos;
    	this.direction = direction; 
    	this.sprite = new Sprite(this.texture);
    	this.sprite.flip(false, true);
    	this.bound = new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }
    
    //動畫使用
    public Entity(Texture texture, int row, int col, int width, int height, Vector2 pos, Vector2 direction) {
    	this.texture = texture;
    	this.row = row;
    	this.col = col;
    	this.width = width;
    	this.height = height;
    	this.pos = pos;
    	this.direction = direction; 
    	this.sprite = new Sprite(this.texture);
    	this.sprite.flip(false, true);
    	this.bound = new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    	loadAnimation();
    	this.stateTime = 0f;
    }
    
    public abstract void update();
    
    public void render(SpriteBatch spriteBatch) { 
    	spriteBatch.draw(sprite, pos.x, pos.y);
    }
    
    public void renderAnimation(SpriteBatch spriteBatch) { 
    	stateTime += Gdx.graphics.getDeltaTime();
    	current_frame = loading_animation.getKeyFrame(stateTime, true);
    	spriteBatch.draw(current_frame, pos.x, pos.y);
    }
    
    public void renderOnceAnimation(SpriteBatch spriteBatch) { 
    	stateTime += Gdx.graphics.getDeltaTime();
    	current_frame = loading_animation.getKeyFrame(stateTime, false);
    	spriteBatch.draw(current_frame, pos.x, pos.y);
    }
    
    public boolean animationIsStop() {
    	return loading_animation.isAnimationFinished(stateTime);
    }
    
    public Rectangle getBoundPerFrame() {
    	return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
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
    
    private void loadAnimation() {
    	int total_frame = row*col;
    	TextureRegion[][] temp = TextureRegion.split(texture, width, height);    //[row][col]
    	sheet_frames = new TextureRegion[total_frame];
    	int index = 0;
    	//System.out.println("totol_frame: " +total_frame +"\n sheet_frames:" +sheet_frames.length);
    	//col
    	for(int i=0; i<col; i++) {
    		//row
    		for (int j=0; j<row; j++) {
    			sheet_frames[index++] = temp[i][j];
    		}
    	}
    	for (int i=0; i<index; i++) {
    		sheet_frames[i].flip(false, true);
    	}
    	loading_animation = new Animation(0.07f, sheet_frames);
    }
    
}
