package com.raysgame.projecoil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	ProjectOil games;
	OrthographicCamera camera;
	SpriteBatch batch;

	
	public GameScreen(ProjectOil _games) {
		this.games = _games;
		
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		//true 是為了翻轉座標系統 libGDX 用的跟一般數學是一樣的，所以要翻轉
		
		batch = new SpriteBatch();    //For Image Rendering
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);    //test for rendering background color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    //畫布之類的吧
		
		camera.update();    //60fps 速率更新鏡頭
		batch.setProjectionMatrix(camera.combined);    //遊戲視窗內圖片大小縮放
		
		batch.begin();
		//Rendering Code Here
		batch.draw(Assets.spriteBackgound, 0, 0);
		batch.end();
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
