package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen{
	ProjectOil games;
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle screenBounds;
    int characterX, characterY;
    final float speed = 6;
    
    AirPlane airPlane; 
	
	public GameScreen(ProjectOil _games) {
		this.games = _games;
		
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		//true 是為了翻轉座標系統 libGDX 用的跟一般數學是一樣的，所以要翻轉
		
		batch = new SpriteBatch();    //For Image Rendering
		
		//取得螢幕邊界
		screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//System.out.println("graphics Width: " +screenBounds.width);
		//System.out.println("graphics height: " +screenBounds.height);
		
		airPlane = new AirPlane(960 - 64, 540);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);    //test for rendering background color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    //畫布之類的吧
		
		camera.update();    //60fps 速率更新鏡頭
		batch.setProjectionMatrix(camera.combined);    //遊戲視窗內圖片大小縮放
		generalUpdate();    //控制移動
		batch.begin();
		//Rendering Code Here
		batch.draw(Assets.spriteBackgound, 0, 0);
		batch.draw(airPlane.image, airPlane.bound.x , airPlane.bound.y);
		batch.end();
	}

	public void generalUpdate() {
		
		//移動判斷
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			airPlane.bound.x -= speed;	
		} 
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			airPlane.bound.x += speed;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			airPlane.bound.y -= speed;
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			airPlane.bound.y += speed;
		}
		
		if (airPlane.bound.x < 0) {
			airPlane.bound.x = 0;
		}
		if (airPlane.bound.y < 0) {
			airPlane.bound.y = 0;
		}
		
		if ((airPlane.bound.x + airPlane.bound.getWidth()) > 1920) {
			airPlane.bound.x = 1919 - airPlane.bound.getWidth();
		}
		if ((airPlane.bound.y + airPlane.bound.getHeight()) > 1080) {
			airPlane.bound.y = 1079 - airPlane.bound.getHeight();
		}

	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
    //給 Android 和 iOS 使用，以防使用者跳出App外面
	@Override
	public void pause() {	
	}

	@Override
	public void resume() {
	}
    //===========

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
    //沒有使用
	@Override
	public void hide() {}
	
	@Override
	public void resize(int width, int height) {}

}
