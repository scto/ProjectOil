package com.raysgame.projecoil;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{
	private ProjectOil games;
	
	public GameScreen(ProjectOil _games) {
		this.games = _games;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
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
