package com.raysgame.projecoil;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.raysgame.projecoil.screen.ScreenManager;
import com.raysgame.projecoil.screen.ScreenScene1;

public class ProjectOil implements ApplicationListener{
	public static int CAMERA_WIDTH = 1920;
    public static int CAMERA_HEIGHT = 1080;
    private SpriteBatch batch;
	@Override
	public void create() {
		Assets.load();
		batch = new SpriteBatch();
		ScreenManager.setScreen(new ScreenScene1());
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);    //test for rendering background color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    //畫布之類的吧
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().update();
			ScreenManager.getCurrentScreen().render(batch);
		}
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}

	@Override
	public void dispose() {
		if (ScreenManager.getCurrentScreen() != null)
		    ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
	}
	
	

}
