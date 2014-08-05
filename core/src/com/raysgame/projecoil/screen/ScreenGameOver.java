package com.raysgame.projecoil.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.SoundManager;
import com.raysgame.projecoil.TextureManager;

public class ScreenGameOver extends Screen{
    
	private OrthographicCamera camera;
	private Texture texture;
	private Sprite sprite;
	private BitmapFont font;
	
	public ScreenGameOver(boolean playerWin) {
		if (playerWin) {
			texture = TextureManager.gameover_win;
		}
		else {
			texture = TextureManager.gameover_lost;
		}
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.setScale(3, -3);
		sprite = new Sprite(texture);
		sprite.flip(false, true);
	}
	
	@Override
	public void create() {
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, ProjectOil.CAMERA_WIDTH, ProjectOil.CAMERA_HEIGHT);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		//true 是為了翻轉座標系統 libGDX 用的跟一般數學是一樣的，所以要翻轉
	}

	@Override
	public void update() {
		camera.update();
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			ProjectOil.score = 0;    //分數歸零
			SoundManager.bgm1.stop();
			ScreenManager.setScreen(new ScreenScene1());    //接關
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		Gdx.gl.glClearColor(0F, 0F, 0F, 0.95F);    //染成黑色背景
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    //畫布之類的吧
		camera.update();
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		//出現在畫面中間
		sb.draw(sprite, (ProjectOil.CAMERA_WIDTH/2)-(texture.getWidth()/2), (ProjectOil.CAMERA_HEIGHT/2)-(texture.getHeight()/2));
		font.draw(sb, "Your score:" +String.valueOf(ProjectOil.score), (ProjectOil.CAMERA_WIDTH/2)-(texture.getWidth()/2) +250, (ProjectOil.CAMERA_HEIGHT/2)-(texture.getHeight()/2 + 400));
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
