package com.raysgame.projecoil;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen{
	private ProjectOil games;
	OrthographicCamera camera;
	
	public GameScreen(ProjectOil _games) {
		this.games = _games;
		
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		
	}

	@Override
	public void render(float delta) {
		camera.update();    //60fps 速率更新鏡頭
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
